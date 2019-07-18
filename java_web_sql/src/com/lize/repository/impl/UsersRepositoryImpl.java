package com.lize.repository.impl;

import com.lize.entity.Users;
import com.lize.repository.UserRepository;
import com.lize.utils.JDBCTools;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UsersRepositoryImpl implements UserRepository {


    @Override
    public List<Users> findAll() {
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select * from Users";
        List<Users> list = null;
        Connection connection = null;
        try {
            connection = JDBCTools.getConnection();
            list = queryRunner.query(connection,sql,new BeanListHandler<>(Users.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCTools.release(connection,null,null);
        }
        return list;
    }

    @Override
    public void add(Users Users) {
        QueryRunner queryRunner = new QueryRunner();
        String sql = "insert into Users(name,score,birthday) values(?,?,?)";
        Connection connection = JDBCTools.getConnection();
        try {
            queryRunner.update(connection,sql,Users.getName(),Users.getScore(),Users.getBirthday());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTools.release(connection,null,null);
        }
    }

    @Override
    public void deleteById(Integer id) {
        QueryRunner queryRunner = new QueryRunner();
        String sql = "delete from Users where id = ?";
        Connection connection = JDBCTools.getConnection();
        try {
            queryRunner.update(connection,sql,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCTools.release(connection,null,null);
        }
    }

    @Override
    public Users findById(Integer id) {
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select * from Users where id = ?";
        Connection connection = JDBCTools.getConnection();
        Users Users = null;
        try {
            Users = queryRunner.query(connection,sql,new BeanHandler<>(Users.class),id);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTools.release(connection,null,null);
        }
        return Users;
    }

    @Override
    public void update(Users Users) {
        QueryRunner queryRunner = new QueryRunner();
        String sql = "update Users set name=?,score=? where id = ?";
        Connection connection = JDBCTools.getConnection();
        try {
            queryRunner.update(connection,sql,Users.getName(),Users.getScore(),Users.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCTools.release(connection,null,null);
        }
    }
}
