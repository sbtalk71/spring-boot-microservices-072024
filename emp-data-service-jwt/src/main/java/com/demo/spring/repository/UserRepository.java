package com.demo.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.spring.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {

	public User findByUserName(String userName);

}
