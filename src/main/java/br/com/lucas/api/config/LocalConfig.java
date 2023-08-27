package br.com.lucas.api.config;

import br.com.lucas.api.domain.User;
import br.com.lucas.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("local")
public class LocalConfig {

    @Autowired
    private UserRepository userRepository;

    @Bean
    public void starDB() {
        User user01 = new User(null, "Lucas", "lucas@email.com", "123456");
        User user02 = new User(null, "Thiago", "Thiago@email.com", "123456");

        userRepository.saveAll(List.of(user01, user02));

    }
}
