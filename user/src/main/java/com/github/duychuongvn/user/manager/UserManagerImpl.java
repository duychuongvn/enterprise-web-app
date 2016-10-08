package com.github.duychuongvn.user.manager;

import com.github.duychuongvn.user.dao.entity.PasswordHistory;
import com.github.duychuongvn.user.dao.entity.User;
import com.github.duychuongvn.user.dao.repository.UserRepository;
import com.github.duychuongvn.user.exception.UserAlreadyExistsException;
import com.github.duychuongvn.user.exception.UserNotFoundException;
import org.apache.commons.lang.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;

/**
 * Created by huynhduychuong on 10/8/2016.
 */
@Component
public class UserManagerImpl implements UserManager {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User findUserByUsername(String username) throws UserNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UserNotFoundException("Cannot find user by username: " + username);
        }
        return user;
    }

    @Override
    public User findUserById(String userId) throws UserNotFoundException {
        User user = userRepository.findOne(userId);
        if (user == null) {
            throw new UserNotFoundException("Cannot find user by id: " + userId);
        }
        return user;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.DEFAULT, readOnly = false)
    public User createUser(User user) throws UserAlreadyExistsException {
        ;
        if (userExists(user)) {
            throw new UserAlreadyExistsException();
        }
        PasswordHistory passwordHistory = user.getPasswordHistory();
        passwordHistory.addPassword(user.getPassword());
        passwordHistory.setLastPasswordChanged(Calendar.getInstance().getTime());
        user.setEnabled(false);
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        return userRepository.save(user);
    }

    private boolean userExists(User user) {
        return userRepository.countByUsernameOrEmailOrPhoneAndIdNotIn(user.getUsername(),
                user.getEmail(), user.getPhoneNumber(), user.getId()) > 0;
    }

    @Override
    public User enableUser(User user) throws UserNotFoundException {
        throw new NotImplementedException();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.DEFAULT, readOnly = false)
    public User updateUser(User user) throws UserNotFoundException, UserAlreadyExistsException {
        if (userExists(user)) {
            throw new UserAlreadyExistsException(
                    "User already exists with email id: " + user.getEmail()
                            + " and/or phone number: "
                            + user.getPhoneNumber() + " and/or username: " + user.getUsername());
        }
        return userRepository.save(user);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.DEFAULT, readOnly = false)
    public User changePassword(String userId, String newPassword) throws UserNotFoundException {
        User user = findUserById(userId);
        PasswordHistory passwordHistory = user.getPasswordHistory();
        passwordHistory.addPassword(newPassword);
        passwordHistory.setLastPasswordChanged(Calendar.getInstance().getTime());
        user.setPassword(newPassword);
        return userRepository.save(user);
    }
}
