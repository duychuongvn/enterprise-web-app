package com.github.duychuongvn.user.dao.entity;

import com.github.duychuongvn.core.jpa.auditing.AbstractAuditableEntity;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.UUID;

/**
 * Created by huynhduychuong on 10/30/2016.
 */
@Entity
@Table(name = "account")
public class Account extends AbstractAuditableEntity<String> {

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "account", cascade = CascadeType.ALL)
    private PasswordHistory passwordHistory;
    @Column(name = "username")
    @Size(max = 45)
    @NotEmpty
    private String username;
    @Column(name = "password")
    @NotEmpty
    private String password;
    @Email
//    @Max(100)
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "account_non_locked")
    private boolean accountNonLocked = true;
    private boolean enabled = false;
    @Column(name = "credentials_non_expired")
    private boolean credentialsNonExpired = true;
    @Column(name = "account_non_expired")
    private boolean accountNonExpired = true;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_access_timestamp")
    private Date lastAccessTimestamp;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "activation_time")
    private Date activationTime;

    public Account() {
        this.setId(UUID.randomUUID().toString());
        passwordHistory = new PasswordHistory(this.getId());
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public PasswordHistory getPasswordHistory() {
        return passwordHistory;
    }

    public Date getLastAccessTimestamp() {
        return lastAccessTimestamp;
    }

    public void setLastAccessTimestamp(Date lastAccessTimestamp) {
        this.lastAccessTimestamp = lastAccessTimestamp;
    }

    public Date getActivationTime() {
        return activationTime;
    }

    public void setActivationTime(Date activationTime) {
        this.activationTime = activationTime;
    }
}
