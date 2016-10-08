package com.github.duychuongvn.user.manager;

import com.github.duychuongvn.user.dao.entity.User;
import com.github.duychuongvn.user.exception.UserAlreadyExistsException;
import com.github.duychuongvn.user.exception.UserNotFoundException;

/**
 * Created by huynhduychuong on 10/8/2016.
 */
public interface UserManager {

    User findUserByUsername(String username) throws UserNotFoundException;
    User findUserById(String userId) throws UserNotFoundException;
    User createUser(User user) throws UserAlreadyExistsException;
    User enableUser(User user) throws UserNotFoundException;
    User updateUser(User user) throws UserNotFoundException, UserAlreadyExistsException;
    User changePassword(String userId, String newPassword) throws UserNotFoundException;
}
