package com.segumentfault.spring.cloud.lesson7.api;

import com.segumentfault.spring.cloud.lesson7.domain.User;

import java.util.List;
public interface UserService {

    /**
     * 保存用户
     *
     * @param user
     * @return
     */
    boolean saveUser(User user);


    /**
     * 查询所有的用户列表
     *
     * @return non-null
     */
    List<User> findAll();

}
