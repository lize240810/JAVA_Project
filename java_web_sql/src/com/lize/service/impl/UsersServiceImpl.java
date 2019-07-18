package com.lize.service.impl;

import com.lize.entity.Users;
import com.lize.repository.UserRepository;
import com.lize.repository.impl.UsersRepositoryImpl;
import com.lize.service.UserService;
import com.lize.utils.Tools;

import java.util.List;

/**
 * 服务层
 * 接受Servlet 的请求
 */
public class UsersServiceImpl implements UserService {

    private UserRepository UserRepository = new UsersRepositoryImpl();

    @Override
    public List<Users> findAll() {
        return UserRepository.findAll();
    }

    @Override
    public void add(String name, String score, String birthday) {
        Integer scoreInt = Integer.parseInt(score);
        Users users = new Users();
        users.setName(name);
        users.setScore(scoreInt);
        users.setBirthday(Tools.turnDate(birthday));
        UserRepository.add(users);
    }

    @Override
    public void deleteById(String idStr) {
        Integer id = Integer.parseInt(idStr);
        UserRepository.deleteById(id);
    }

    @Override
    public Users findById(String idStr) {
        Integer id = Integer.parseInt(idStr);
        return UserRepository.findById(id);
    }

    @Override
    public void update(String idStr, String name, String scoreStr, String birthday) {
        Integer id = Integer.parseInt(idStr);
        Integer score = Integer.parseInt(scoreStr);
        Users users = new Users(id,name,score,Tools.turnDate(birthday));

        UserRepository.update(users);
    }
}
