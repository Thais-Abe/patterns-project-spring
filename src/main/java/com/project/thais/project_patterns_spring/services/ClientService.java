package com.project.thais.project_patterns_spring.services;

import com.project.thais.project_patterns_spring.exceptions.ConflictException;
import com.project.thais.project_patterns_spring.exceptions.NotFoundException;
import com.project.thais.project_patterns_spring.models.Client;
import com.project.thais.project_patterns_spring.repositories.IClientsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final IClientsRepository iClientsRepository;
    public Client getClientById(Long id) {
        return iClientsRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Os dados do ID " + id + " não foram encontrados!"));
    }


    public List<Client> getAllClients() {
        return iClientsRepository.findAll().stream().toList();
    }


    public Client saveClient(Client client) {
        var clientFounded = iClientsRepository.findById(client.getId());
        if(clientFounded.isPresent()){
            throw new ConflictException("Cliente já cadastrado");
        }
        return iClientsRepository.save(client);
    }

    public Client modifyClient(Long id, Client client) {
        var clientFounded = iClientsRepository.findById(id);
        if (clientFounded.isEmpty()){
            throw new NotFoundException("Cliente não cadastrado!");
        }
        return iClientsRepository.save(client);
    }

    public void deleteClient(Long id) {
        var clientFounded = iClientsRepository.findById(id).orElseThrow(()-> new NotFoundException("Cliente não cadastrado!"));
        iClientsRepository.delete(clientFounded);
    }

}
