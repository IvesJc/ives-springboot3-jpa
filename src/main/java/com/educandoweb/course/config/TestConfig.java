package com.educandoweb.course.config;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.OrderRepository;
import com.educandoweb.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
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

    @Autowired
    private OrderRepository orderRepository;
    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");

        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456789");

        Order o1 = new Order(null, Instant.parse("2024-02-02T19:10:00Z"), u1);
        Order o2 = new Order(null, Instant.parse("2023-12-14T21:40:00Z"), u2);
        Order o3 = new Order(null, Instant.parse("2024-07-21T06:30:00Z"), u1);

        // SALVAR OS USUARIOS NO DB
        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));

    }
}
