package com.github.duychuongvn.user.manager;

import com.github.duychuongvn.user.dao.entity.Account;
import com.github.duychuongvn.user.exception.AccountAlreadyExistException;
import com.github.duychuongvn.user.exception.AccountNotFoundException;

public interface AccountManager {
    Account findByAccountId(String accountId) throws AccountNotFoundException;
    Account findByUsername(String username) throws AccountNotFoundException;
    Account create(Account account) throws AccountAlreadyExistException;
    Account update(Account account) throws AccountAlreadyExistException;
    void delete(Account account);
    void changePassword(String accountId, String newPassword) throws AccountNotFoundException;

}
