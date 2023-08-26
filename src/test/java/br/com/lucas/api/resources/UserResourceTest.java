package br.com.lucas.api.resources;

import br.com.lucas.api.domain.User;
import br.com.lucas.api.domain.dto.UserDTO;
import br.com.lucas.api.services.users.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserResourceTest {

    public static final Integer ID = 1;
    public static final String NAME = "Lucas";
    public static final String EMAIL = "lucas@email.com";
    public static final String PASSWORD = "123456";

    private User user;
    private UserDTO userDTO;

    @InjectMocks
    private UserResource userResource;

    @Mock
    private UserService userService;
    @Mock
    private ModelMapper modelMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        start();
    }

    @Test
    void findById() {
    }

    @Test
    void findAll() {
    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    private void start() {
        this.user = new User(ID, NAME, EMAIL, PASSWORD);
        this.userDTO = new UserDTO(ID, NAME, EMAIL, PASSWORD);
    }
}