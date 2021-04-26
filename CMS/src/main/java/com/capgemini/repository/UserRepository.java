package com.capgemini.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
