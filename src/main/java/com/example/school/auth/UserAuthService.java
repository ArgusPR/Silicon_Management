//package com.example.school.auth;
//
//import com.example.school.dao.UserRepository;
//import com.example.school.entity.User;
//import com.example.school.entity.UserDetails;
//import com.example.school.entity.UserRole;
//import com.example.school.service.UserDetailsService;
//import jakarta.transaction.Transactional;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//public class UserAuthService implements UserDetailsService {
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Override
//    @Transactional
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepository.findByUserName(username).get();
//
//        List<UserRole> userRoles = user.getUserRoles().stream().collect(Collectors.toList());
//
//        List<GrantedAuthority> grantedAuthorities = userRoles.stream().map(r -> {
//            return new SimpleGrantedAuthority(r.getRole());
//        }).collect(Collectors.toList());
//
//        return new User(username, user.getUserPass(), grantedAuthorities);
//    }
//
//    public void saveUser(Request request) {
//        if (userRepository.findByUserName(request.getUserName()).isPresent()) {
//            throw new RuntimeException("User already exists");
//        }
//
//        User user = new User();
//        user.setUserName(request.getUserName());
//        user.setUserPass(passwordEncoder.encode(request.getUserPwd()));
//
//        user.setUserRoles(request.getRoles().stream().map(r -> {
//            UserRole ur = new UserRole();
//            ur.setRole(r);
//            return ur;
//        }).collect(Collectors.toSet()));
//
//        userRepository.save(user);
//    }
//
//
//
//}
