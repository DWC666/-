package com.dwc.service;

import com.dwc.error.BusinessException;
import com.dwc.service.model.UserModel;

public interface UserService {
    UserModel getUserById(Integer id);
    void register(UserModel userModel) throws BusinessException;
    UserModel validateLogin(String telphone, String encryptPassword) throws BusinessException;
}
