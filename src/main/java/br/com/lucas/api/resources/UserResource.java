package br.com.lucas.api.resources;

import br.com.lucas.api.domain.User;
import br.com.lucas.api.domain.dto.UserDTO;
import br.com.lucas.api.services.users.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserResource {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserService userService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Integer id){
        System.out.println("Find by id: " + id);
        return ResponseEntity.ok().body(modelMapper.map(userService.findById(id), UserDTO.class));
    }
}
