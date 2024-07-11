package com.lewis.userlogin.service;

import com.lewis.userlogin.entity.UserUpDownLoad;
import com.lewis.userlogin.repository.UserUpDownLoadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserUpDownLoadService {

    @Autowired
    private UserUpDownLoadRepository userUpDownLoadRepository;

    public void createUser(UserUpDownLoad userUpDownLoad){
        userUpDownLoadRepository.save(userUpDownLoad);
    }

    public Optional<UserUpDownLoad> getUserUpDownLoadById(Long id){
        return userUpDownLoadRepository.findById(id);
    }

    public List<UserUpDownLoad> getAllUserUpDownLoads(){
        return userUpDownLoadRepository.findAll();
    }
}
