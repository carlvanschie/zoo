package com.vanschie.authenticator.controller;

import com.vanschie.authenticator.model.User;
import com.vanschie.authenticator.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        List list = new ArrayList<>();
        userRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    public void delete(long id) {
        userRepository.deleteById(id);
    }

    public User save(User user) {
        return userRepository.save(user);
    }
}
//
//@Service
//public class UserService implements UserDetailsService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
//        User user = userRepository.findByUsername(userId);
//        if(user == null){
//            throw new UsernameNotFoundException("Invalid username or password.");
//        }
//        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority());
//    }
//
//    private List getAuthority() {
//        return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
//    }
//
//    public List<User> findAll() {
//        List list = new ArrayList<>();
//        userRepository.findAll().iterator().forEachRemaining(list::add);
//        return list;
//    }
//
//    public void delete(long id) {
//        userRepository.deleteById(id);
//    }
//
//    public User save(User user) {
//        return userRepository.save(user);
//    }
//}