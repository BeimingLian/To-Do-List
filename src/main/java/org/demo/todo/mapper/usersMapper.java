package org.demo.todo.mapper;

import org.demo.todo.domain.users;

import java.util.List;

public interface usersMapper {
    users selectUserById(Long id);

    List<users> selectAllUsers();

    int insertUser(users user);

    int updateUser(users user);

    void deleteUser(Long id);
}
