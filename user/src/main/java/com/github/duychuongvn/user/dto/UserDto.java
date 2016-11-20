package com.github.duychuongvn.user.dto;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

/**
 * Created by huynhduychuong on 10/30/2016.
 */
public class UserDto {
    @NotEmpty
    @Size(max = 45)
    private String username;
    private String password;

}
