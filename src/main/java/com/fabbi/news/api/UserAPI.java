package com.fabbi.news.api;

import com.fabbi.news.entity.UserEntity;
import com.fabbi.news.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserAPI {
    @Autowired
    IUserService iUserService;

    @GetMapping(value = "/all")
    @PreAuthorize("hasRole('ADMIN')")
    public List<UserEntity> getAll(){
        return iUserService.getAll();
    }

}
