package br.com.lucas.api.services.users;

import br.com.lucas.api.domain.User;
import br.com.lucas.api.domain.dto.UserDTO;

import java.util.List;

public interface UserService {

    User findById(Integer id);
    List<User> findAll();
    User create(UserDTO userDTO);
    User update(UserDTO userDTO);
    void delete(Integer id);
}
