package br.com.lucas.api.resources;

import br.com.lucas.api.domain.User;
import br.com.lucas.api.domain.dto.UserDTO;
import br.com.lucas.api.services.users.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/user")
public class UserResource {

    @Autowired
    private UserService userService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Integer id){
        return ResponseEntity.ok().body(
                modelMapper.map(userService.findById(id), UserDTO.class)
        );
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        return ResponseEntity.ok().body(
                userService.findAll().stream().map(urs -> modelMapper.map(urs, UserDTO.class)).collect(Collectors.toList())
        );
    }

    @PostMapping
    public ResponseEntity<UserDTO> create(@RequestBody UserDTO userDTO) {
        return ResponseEntity.created(                                                          // Retorna um Status 201
                ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(  // Busca da URI do Usuário que ta sendo criado
                        userService.create(userDTO).getId()                                     // Cria o Usuário
                ).toUri()                                                                       // Pega a URI desse usuário
        ).build();                                                                              // Bilda tudo para retornar ao cliente (status 201 e URI)
    }
}
