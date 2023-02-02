package com.andyron.controller;

import com.andyron.entity.User;
import com.andyron.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author Andy Ron
 */
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    /*  保存数据，并缓存
        http://localhost:8080/saveUser?id=1&userName=andyron&userPassword=987654321
     */
    @GetMapping("/saveUser")
    @CachePut(value = "user", key = "#id")
    public User saveUser(Long id, String userName, String userPassword) {
        User user = new User(id, userName, userPassword);
        userRepository.save(user);
        return user;
    }
    /*
        因为在配置文件中设置了查询数据库就打印SQL。清空控制台，调用缓存就不打印SQL
        http://localhost:8080/queryUser?id=1
     */
    @GetMapping("/queryUser")
    @Cacheable(value = "user", key = "#id")
    public Optional<User> queryUser(Long id){
        return userRepository.findById(id);
    }

    /*
        删除缓存后，调用查询时就会打印SQL
       http://localhost:8080/deleteUser?id=1
     */
    @GetMapping("/deleteUser")
    @CacheEvict(value = "user", key = "#id")
    public String deleteUser(Long id){
        userRepository.deleteById(id);
        return "success";
    }
    // 删除全部缓存
    @GetMapping("/deleteCache")
    @CacheEvict(value = "user", allEntries = true)
    public void deleteCache() {
    }
}
