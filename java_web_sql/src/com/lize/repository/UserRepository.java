package com.lize.repository;

import com.lize.entity.Users;

import java.util.List;

public interface UserRepository {
    public List<Users> findAll();
    public void add(Users Users);
    public void deleteById(Integer id);
    public Users findById(Integer id);
    public void update(Users Users);
}
