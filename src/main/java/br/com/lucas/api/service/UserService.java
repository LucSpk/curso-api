package br.com.lucas.api.service;

import br.com.lucas.api.domain.User;

public interface UserService {

    User findById(Integer id);
}
