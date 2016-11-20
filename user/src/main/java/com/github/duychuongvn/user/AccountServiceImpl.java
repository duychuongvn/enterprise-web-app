package com.github.duychuongvn.user;

import com.github.duychuongvn.user.dao.entity.Account;
import com.github.duychuongvn.user.dto.AccountDto;
import com.github.duychuongvn.user.exception.AccountAlreadyExistException;
import com.github.duychuongvn.user.manager.AccountManager;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by huynhduychuong on 11/20/2016.
 */
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountManager accountManager;

    @Override
    public Account createAccount(AccountDto accountDto) throws AccountAlreadyExistException {
        Account account = new Account();
        account.setEmail(accountDto.getEmail());
        account.setUsername(account.getUsername());
        account.setPhoneNumber(account.getPhoneNumber());
        account.setEnabled(false);
        return accountManager.create(account);
    }
}
