package com.github.duychuongvn.user.manager;

import com.github.duychuongvn.user.dao.entity.UserProfile;
import com.github.duychuongvn.user.dao.repository.AccountRepository;
import com.github.duychuongvn.user.dao.repository.UserProfileRepository;
import com.github.duychuongvn.user.exception.UserNotFoundException;
import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class UserManagerImplTest {
    @Mock
    private UserProfileRepository userProfileRepository;
    @Mock
    private AccountRepository accountRepository;
    @InjectMocks
    private UserManager userManager = new UserManagerImpl();

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void ignoreTest() {

    }
}