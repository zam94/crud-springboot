package com.test.code.repository;

import com.test.code.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsersRepository extends JpaRepository<Users, Integer> {

    Users findById(Integer id);

}
