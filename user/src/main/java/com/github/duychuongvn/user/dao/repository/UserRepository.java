package com.github.duychuongvn.user.dao.repository;

import com.github.duychuongvn.user.dao.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by huynhduychuong on Oct 3, 2016.
 */
public interface UserRepository extends JpaRepository<User, String> {

    User findByUsername(String username);

    @Query("SELECT COUNT(u) FROM User u WHERE u.id != :id and (u.username = :username or u.email = :email or u.phoneNumber =:phoneNumber) ")
    int countByUsernameOrEmailOrPhoneAndIdNotIn(@Param("username") String username, @Param("email") String email, @Param("phoneNumber") String phoneNumber, @Param("id") String id);
}
