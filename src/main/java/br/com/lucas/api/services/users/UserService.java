package br.com.lucas.api.services.users;

import br.com.lucas.api.domain.User;

public interface UserService {

    User findById(Integer id);
}
