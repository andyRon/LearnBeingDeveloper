package com.andyron.dao;

import com.andyron.entity.User;
import com.andyron.provider.UserSqlProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Andy Ron
 */
@Mapper
public interface UserMapper {
    User findUserByUsername(String username);

    void updateUserByUsername(User user);

    void deleteUserByUsername(String username);

    void saveUser(User user);

    List<User> getUserList();

    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "user_name",column = "user_name"),
            @Result(property = "pass_word",column = "pass_word")
    })
    @Select("SELECT * FROM USER")
    List<User> findAll();

    @SelectProvider(type = UserSqlProvider.class,method = "getSql")
    List<User> findUserById(@Param("id") int id);
}
