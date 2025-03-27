package me.dio.decola_tech_2025.service.impl;

import me.dio.decola_tech_2025.model.User;
import me.dio.decola_tech_2025.service.UserService;
import org.springframework.stereotype.Service;
import repository.UserRepository;

import java.util.NoSuchElementException;

@Service

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        if (userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())) {
            throw new IllegalArgumentException("This Account number exists!");
        }
        return userRepository.save(userToCreate);
    }
}
