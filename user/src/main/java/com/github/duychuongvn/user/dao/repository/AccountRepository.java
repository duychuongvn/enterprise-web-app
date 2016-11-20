package com.github.duychuongvn.user.dao.repository;

import com.github.duychuongvn.user.dao.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by huynhduychuong on 10/30/2016.
 */
public interface AccountRepository extends JpaRepository<Account, String> {

    Account findByUsername(String username);
    @Query("SELECT COUNT(u) FROM Account u WHERE u.id != :id and (u.username = :username or u.email = :email or u.phoneNumber =:phoneNumber) ")
    int countByUsernameOrEmailOrPhoneAndIdNotIn(@Param("username") String username, @Param("email") String email, @Param("phoneNumber") String phoneNumber, @Param("id") String id);
}
