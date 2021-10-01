package com.fabbi.news.service.impl;

import com.fabbi.news.dto.UserDTO;
import com.fabbi.news.entity.UserEntity;
import com.fabbi.news.repository.UserRepository;
import com.fabbi.news.service.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<UserEntity> getAll(){
        return userRepository.findAll();
    }

    @Override
    public UserEntity createUser(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity = modelMapper.map(userDTO, UserEntity.class);
        userRepository.save(userEntity);
        return userEntity;
    }

}
