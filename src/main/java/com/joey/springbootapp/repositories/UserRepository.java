package com.joey.springbootapp.repositories;

import com.joey.springbootapp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}