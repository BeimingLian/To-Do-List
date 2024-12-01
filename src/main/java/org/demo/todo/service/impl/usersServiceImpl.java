package org.demo.todo.service.impl;

import org.demo.todo.domain.users;
import org.demo.todo.mapper.usersMapper;
import org.demo.todo.service.usersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class usersServiceImpl implements usersService {

    @Autowired
    private usersMapper userMapper;

    @Override
    public users selectUserById(Long id) {
        return userMapper.selectUserById(id);
    }

    @Override
    public List<users> selectAllUsers() {
        return userMapper.selectAllUsers();
    }

    @Override
    public int insertUser(users user) {
        return userMapper.insertUser(user);
    }

    @Override
    public int updateUser(users user) {
        return userMapper.updateUser(user);
    }

    @Override
    public void deleteUser(Long id) {
        userMapper.deleteUser(id);
    }

    @Override
    public users findUserByNameAndPassword(String userName, String password) {
        return userMapper.findUserByNameAndPassword(userName, password);
    }

    @Override
    public users findUserByName(String userName) {
        return userMapper.findUserByName(userName);
    }



}