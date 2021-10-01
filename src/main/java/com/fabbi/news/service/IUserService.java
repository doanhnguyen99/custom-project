package com.fabbi.news.service;

import com.fabbi.news.dto.UserDTO;
import com.fabbi.news.entity.UserEntity;

import java.util.List;

public interface IUserService {
    List<UserEntity> getAll();

    UserEntity createUser(UserDTO userDTO);
}
