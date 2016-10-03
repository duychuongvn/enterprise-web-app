package com.github.duychuongvn.user.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.duychuongvn.user.dao.entity.User;

/**
 * Created by huynhduychuong on Oct 3, 2016.
 *
 */
public interface UserRepository extends JpaRepository<User, String> {

}
