package com.sid.clientservice;

import com.sid.clientservice.models.Client;
import com.sid.clientservice.repos.ClientRepos;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class ClientServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(ClientRepos clientRepos , RepositoryRestConfiguration restConfiguration){
        restConfiguration.exposeIdsFor(ClientRepos.class);
        return args -> {
            clientRepos.save(new Client(null , "omar","maanaoui","m;mfà@", "sfe",12,"sgz"));

            clientRepos.findAll().forEach(c->{
                System.out.println(c.toString());
            });
        };
    }
}
