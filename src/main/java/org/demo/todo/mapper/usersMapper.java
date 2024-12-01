package org.demo.todo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.demo.todo.domain.users;
import org.apache.ibatis.annotations.Param;
import java.util.List;
@Mapper
public interface usersMapper {
    users selectUserById(Long id);

    List<users> selectAllUsers();

    int insertUser(users user);

    int updateUser(users user);

    void deleteUser(Long id);

    users findUserByNameAndPassword(@Param("userName") String userName, @Param("password") String password);

    users findUserByName(String userName);
}
