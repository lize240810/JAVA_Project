package com.lize.service;

import com.lize.entity.Users;

import java.util.List;

public interface UserService {
    public List<Users> findAll();
    public void add(String name,String score, String birthday);
    public void deleteById(String idStr);
    public Users findById(String idStr);
    public void update(String idStr,String name,String scoreStr,String birthday);
}
