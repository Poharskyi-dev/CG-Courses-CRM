package com.opencourse.cgcoursescrm.domain.service;

import com.opencourse.cgcoursescrm.domain.model.User;
import com.opencourse.cgcoursescrm.domain.repository.UserRepository;
import com.opencourse.cgcoursescrm.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    // private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository/*, PasswordEncoder passwordEncoder*/) {
        this.userRepository = userRepository;
        // this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User createUser(User user) {
//        String encodedPassword = passwordEncoder.encode(user.getPassword());
//        user.setPassword(encodedPassword);

        return userRepository.save(user);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(UUID userId) {
        Optional<User> user = userRepository.findById(userId);

        return user.orElseThrow(() -> new UserNotFoundException(userId));
    }

    @Override
    public User updateUser(UUID userId, User userToUpdateFrom) {
        User user = getUserById(userId);

        user.update(userToUpdateFrom);

        return userRepository.save(user);
    }

    @Override
    public void deleteUser(UUID userId) {
        User user = getUserById(userId);

        userRepository.delete(user);
    }












}
