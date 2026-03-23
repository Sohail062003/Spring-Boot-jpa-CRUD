package com.example.jpademo.repository;

import com.example.jpademo.entity.UserClassSpringBoot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserClassSpringBoot, Long> {


}


