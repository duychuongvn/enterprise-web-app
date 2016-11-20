package com.github.duychuongvn.user.manager;

import com.github.duychuongvn.user.dao.entity.Account;
import com.github.duychuongvn.user.dao.repository.AccountRepository;
import com.github.duychuongvn.user.exception.AccountNotFoundException;
import org.fest.assertions.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static  org.mockito.Mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

/**
 * Created by huynhduychuong on 11/20/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class AccountManagerImpl_findByUsernameTest {

    @Mock
    private AccountRepository accountRepository;
    @InjectMocks
    private AccountManagerImpl accountManager;
    @Test(expected = AccountNotFoundException.class)
    public void shouldThrowAccountNotFoundExceptionWhenDataNotExits() throws Exception {
        when(accountManager.findByUsername(anyString())).thenReturn(null);
        accountManager.findByUsername("not.found");
    }
    @Test
    public void shouldReturnAccountWhenFindData() throws AccountNotFoundException {
        Account account = prepareAccount();
        when(accountRepository.findByUsername(anyString())).thenReturn(account);
        Account result = accountManager.findByUsername("User1");
        Assertions.assertThat(result.getUsername()).isEqualTo("User1");
        Assertions.assertThat(result.getEmail()).isEqualTo("email@mail.com");
    }

    private Account prepareAccount() {

        Account account = new Account();
        account.setUsername("User1");
        account.setEmail("email@mail.com");
        return account;
    }

}