package com.mycompany.dao.impl;

import com.mycompany.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer>, UserRepositoryCustom {

    User findByName(String name);

    @Query(value="select u from User u where u.email=:email")//u.email=?1  de yazmaq olar
    User findByEmail(String email);//Eger burda String alma yazsaq onda @Param("email") yazmaliyiq

}
