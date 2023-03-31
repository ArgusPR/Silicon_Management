package com.example.school.service;

import com.example.school.dao.StudentRepository;
import com.example.school.dao.UserDetailsRepository;
import com.example.school.entity.Student;
import com.example.school.entity.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
    private UserDetailsRepository userDetailsRepository;

    @Autowired
    public UserDetailsServiceImpl(UserDetailsRepository theUserDetailsRepository) {
        userDetailsRepository = theUserDetailsRepository;
    }
    @Override
    public List<UserDetails> findAll() {
        return userDetailsRepository.findAll();
    }

    @Override
    public UserDetails findById(int theId) {
        Optional<UserDetails> result = userDetailsRepository.findById(theId);

        UserDetails theUser = null;

        if (result.isPresent()) {
            theUser = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find student id - " + theId);
        }
        return theUser;
    }

    @Override
    public void save(UserDetails theUser) {
        userDetailsRepository.save(theUser);
    }

    @Override
    public void deleteById(int theId) {
        userDetailsRepository.deleteById(theId);
    }
}
