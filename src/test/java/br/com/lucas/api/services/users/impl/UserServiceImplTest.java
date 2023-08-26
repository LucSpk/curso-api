package br.com.lucas.api.services.users.impl;

import br.com.lucas.api.domain.User;
import br.com.lucas.api.domain.dto.UserDTO;
import br.com.lucas.api.repositories.UserRepository;
import br.com.lucas.api.services.exceptions.ObjectNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class UserServiceImplTest {

    public static final Integer ID = 1;
    public static final String NAME = "Lucas";
    public static final String EMAIL = "lucas@email.com";
    public static final String PASSWORD = "123456";
    @InjectMocks
    private UserServiceImpl userServiceImp;
    @Mock
    private UserRepository userRepository;
    @Mock
    private ModelMapper modelMapper;
    private User user;
    private UserDTO userDTO;
    private Optional<User> optionalUser;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        this.start();
    }

    @Test
    void whenFindByIdThenReturnAnUserInstance() { // - findById
        // Mocka a resposta -> quando findById do userRepository for chamado, somente com um atributo int sera retornado um optionalUser
        Mockito.when(userRepository.findById(Mockito.anyInt())).thenReturn(this.optionalUser);
        // Faz a busca por ID
        User response = userServiceImp.findById(ID);
        // Confere se a reposta não é nula
        Assertions.assertNotNull(response);
        // Confere se o retorno é do tipo esperado
        Assertions.assertEquals(User.class, response.getClass());
        // Confere se os atributos sao iguais
        Assertions.assertEquals(ID, response.getId());
        Assertions.assertEquals(NAME, response.getName());
        Assertions.assertEquals(EMAIL, response.getEmail());
        Assertions.assertEquals(PASSWORD, response.getPassword());
    }

    @Test
    void whenFindByIdThenReturnAnObjectNotFoundException() {
        Mockito.when(userRepository.findById(Mockito.anyInt())).thenThrow(new ObjectNotFoundException("Objeto não encontrado"));

        try {
            userServiceImp.findById(ID);
        } catch (Exception ex) {
            Assertions.assertEquals(ObjectNotFoundException.class, ex.getClass());
            Assertions.assertEquals("Objeto não encontrado", ex.getMessage());
        }
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

    @Test
    void findByEmail() {
    }

    private void start() {
        this.user = new User(ID, NAME, EMAIL, PASSWORD);
        this.userDTO = new UserDTO(ID, NAME, EMAIL, PASSWORD);
        this.optionalUser = Optional.of(new User(ID, NAME, EMAIL, PASSWORD));
    }
}