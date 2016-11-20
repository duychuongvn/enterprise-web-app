package com.github.duychuongvn.user.manager;

import com.github.duychuongvn.user.dao.entity.UserProfile;
import com.github.duychuongvn.user.dao.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by huynhduychuong on 10/8/2016.
 */
@Component
public class UserManagerImpl implements UserManager {
    @Autowired
    private UserProfileRepository userProfileRepository;

    @Override
    public UserProfile createOrUpdate(UserProfile userProfile) {
        return userProfileRepository.save(userProfile);
    }
}
