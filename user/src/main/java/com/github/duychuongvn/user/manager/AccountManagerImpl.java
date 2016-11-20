package com.github.duychuongvn.user.manager;

import com.github.duychuongvn.user.dao.entity.Account;
import com.github.duychuongvn.user.dao.entity.PasswordHistory;
import com.github.duychuongvn.user.dao.repository.AccountRepository;
import com.github.duychuongvn.user.exception.AccountAlreadyExistException;
import com.github.duychuongvn.user.exception.AccountNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;

/**
 * Created by huynhduychuong on 11/20/2016.
 */
public class AccountManagerImpl implements AccountManager {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account findByAccountId(String accountId) throws AccountNotFoundException {
        Account account = accountRepository.findOne(accountId);
        if (account == null) {
            throw new AccountNotFoundException();
        }
        return account;

    }

    @Override
    public Account findByUsername(String username) throws AccountNotFoundException {
        Account account = accountRepository.findByUsername(username);
        if (account == null) {
            throw new AccountNotFoundException();
        }
        return account;
    }

    @Override
    public Account create(Account account) throws AccountAlreadyExistException {

        if (isExists(account)) {
            throw new AccountAlreadyExistException();
        }
        return accountRepository.save(account);
    }

    private boolean isExists(Account account) {
        return accountRepository.countByUsernameOrEmailOrPhoneAndIdNotIn(account.getUsername(),
                account.getEmail(), account.getPhoneNumber(), account.getId()) > 0;
    }

    @Override
    public Account update(Account account) throws AccountAlreadyExistException {
        if (isExists(account)) {
            throw new AccountAlreadyExistException();
        }
        return accountRepository.save(account);
    }

    @Override
    public void delete(Account account) {
        accountRepository.delete(account);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.DEFAULT, readOnly = false)
    public void changePassword(String accountId, String newPassword) throws AccountNotFoundException {
        Account account = findByAccountId(accountId);
        PasswordHistory passwordHistory = account.getPasswordHistory();
        passwordHistory.addPassword(newPassword);
        passwordHistory.setLastPasswordChanged(Calendar.getInstance().getTime());
        account.setPassword(newPassword);
        accountRepository.save(account);
    }
}
