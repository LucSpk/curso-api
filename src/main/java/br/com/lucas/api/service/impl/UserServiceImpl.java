package br.com.lucas.api.service.impl;

import br.com.lucas.api.domain.User;
import br.com.lucas.api.repositories.UserRepository;
import br.com.lucas.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findById(Integer id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }
}
