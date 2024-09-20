package com.prakash.SmartContactManager.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prakash.SmartContactManager.Model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
