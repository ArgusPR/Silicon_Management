package com.example.school.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.school.entity.UserDetails;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Integer> {
}
