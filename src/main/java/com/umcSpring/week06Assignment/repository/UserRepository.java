package com.umcSpring.week06Assignment.repository;

import com.umcSpring.week06Assignment.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{

}
