package com.project.thais.project_patterns_spring.controllers;

import com.project.thais.project_patterns_spring.models.Client;
import com.project.thais.project_patterns_spring.services.ClientService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("client")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(Long id){
        return ResponseEntity.ok(clientService.getClientById(id));
    }
    @GetMapping
    public ResponseEntity<List<Client>> getAllClients(){
        return ResponseEntity.ok(clientService.getAllClients());
    }

    @PostMapping
    public ResponseEntity<Client> saveClient(@RequestBody Client client){
        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.saveClient(client));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Client> modifyClient(@RequestBody Client client, @PathParam("Id") Long id){
        return ResponseEntity.ok(clientService.modifyClient(id,client));
    }
    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> deleteClient(@PathParam("id") Long id){
        clientService.deleteClient(id);
        return ResponseEntity.ok().build();
    }
}
