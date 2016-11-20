package com.github.duychuongvn.user.dao.repository;

import com.github.duychuongvn.core.jpa.repository.AuditingRepository;
import com.github.duychuongvn.user.dao.entity.UserProfile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by huynhduychuong on Oct 3, 2016.
 */
public interface UserProfileRepository extends AuditingRepository<UserProfile, String> {
}
