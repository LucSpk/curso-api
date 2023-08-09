package br.com.lucas.api.services.users;

import br.com.lucas.api.domain.User;

import java.util.List;

public interface UserService {

    User findById(Integer id);
    List<User> findAll();
}
