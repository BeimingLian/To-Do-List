package org.demo.todo.service;

import org.demo.todo.domain.users;

import java.util.List;

public interface usersService {
    users selectUserById(Long id);

    List<users> selectAllUsers();

    int insertUser(users user);

    int updateUser(users user);

    void deleteUser(Long id);

    users findUserByNameAndPassword(String userName, String password);

    users findUserByName(String userName);

}
