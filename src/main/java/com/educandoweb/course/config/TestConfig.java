package com.educandoweb.course.config;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

// @Configuration = Spring identifica que essa é uma classe para configuração
@Configuration
// @Profile = Classe específica para o perfil 'Test'
@Profile("test")
public class TestConfig implements CommandLineRunner {

    // @Autowired = "Auto liga/conecta o userRepository a classe UserRepository sem a necessidade de uma
    // nova instanciação
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");

        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456789");

        // SALVAR OS USUARIOS NO DB
        userRepository.saveAll(Arrays.asList(u1, u2));

    }
}
