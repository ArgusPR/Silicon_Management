package com.example.school.service;

import com.example.school.entity.Student;
import com.example.school.entity.UserDetails;
import jakarta.transaction.Transactional;


import java.util.List;

public interface UserDetailsService {
    public List<UserDetails> findAll();

    public UserDetails findById(int theId);

    public void save(UserDetails theUser);

    public void deleteById(int theId);

}
