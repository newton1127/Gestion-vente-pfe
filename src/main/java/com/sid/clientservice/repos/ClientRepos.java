package com.sid.clientservice.repos;

import com.sid.clientservice.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ClientRepos extends JpaRepository<Client,Long> {
    public Client findClientByNom(String nom);
    public Client findClientById(Long id);

}
