package com.Malshika.service;

import com.Malshika.model.User;

public interface UserService {

    public User findUserById(Long userId)throws Exception;

}
