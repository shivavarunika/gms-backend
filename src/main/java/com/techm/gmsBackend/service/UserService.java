package com.techm.gmsBackend.service;

import com.techm.gmsBackend.dao.UserRepository;
import com.techm.gmsBackend.entity.GymUser;
import com.techm.gmsBackend.util.JwtUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public String register(GymUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user).getName();
    }

    public String login(String name, String password) {
        Optional<GymUser> userOpt = userRepository.findByName(name);
        if (userOpt.isPresent() && passwordEncoder.matches(password, userOpt.get().getPassword())) {
            try {
                return JwtUtil.generateToken(name);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        throw new RuntimeException("Invalid credentials");
    }

    public Optional<GymUser> findByName(String name) {
        return userRepository.findByName(name);
    }
}

//
//    private final UserRepository userRepository;
//
//    public UserService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    public String addUser(GymUser user) {
//        userRepository.save(user);
//        return "trainer created/updated";
//    }
//
//    public List<GymUser> getAllUsers() {
//        return userRepository.findAll();
//    }
//
//    public GymUser getUser(long id) {
//        return userRepository.findById(id).orElse(null);
//    }
//
//    public String deleteUser(long id) {
//        userRepository.deleteById(id);
//        return "trainer deleted";
//    }
//
//}
