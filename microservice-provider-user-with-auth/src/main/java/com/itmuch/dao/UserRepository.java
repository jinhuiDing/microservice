package com.itmuch.dao;

import com.itmuch.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @description: UserRespository
 * @author: ding
 * @date: 2019/11/5 20:07
 * @version: 1.0
 */


public interface UserRepository extends JpaRepository<User,Long> {
}
