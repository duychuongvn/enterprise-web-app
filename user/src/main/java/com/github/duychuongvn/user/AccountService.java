package com.github.duychuongvn.user;

import com.github.duychuongvn.user.dao.entity.Account;
import com.github.duychuongvn.user.dto.AccountDto;
import com.github.duychuongvn.user.exception.AccountAlreadyExistException;

public interface AccountService {

    Account createAccount(AccountDto accountDto) throws AccountAlreadyExistException;
}
