package com.github.duychuongvn.user.manager;

import com.github.duychuongvn.user.dao.entity.UserProfile;
import com.github.duychuongvn.user.exception.UserAlreadyExistsException;
import com.github.duychuongvn.user.exception.UserNotFoundException;

/**
 * Created by huynhduychuong on 10/8/2016.
 */
public interface UserManager {

    UserProfile createOrUpdate(UserProfile userProfile);
}
