package br.com.lucas.api.services.users.impl;

import br.com.lucas.api.domain.User;
import br.com.lucas.api.domain.dto.UserDTO;
import br.com.lucas.api.repositories.UserRepository;
import br.com.lucas.api.services.exceptions.DataIntegratyViolationException;
import br.com.lucas.api.services.exceptions.ObjectNotFoundException;
import br.com.lucas.api.services.users.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public User findById(Integer id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User create(UserDTO userDTO) {
        this.verificaEmailExistente(userDTO);
        return userRepository.save(modelMapper.map(userDTO, User.class));
    }

    public void verificaEmailExistente(UserDTO userDTO) {
        Optional<User> user = userRepository.findByEmail(userDTO.getEmail());
        if(user.isPresent()) {
            throw new DataIntegratyViolationException("E-mail já cadastrado no sistema");
        }
    }

}
