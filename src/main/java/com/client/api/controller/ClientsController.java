package com.client.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.client.api.model.Client;
import com.client.api.repository.ClientRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/clients")
public class ClientsController {
    
    @Autowired
    private ClientRepository clientRepository;

    @Operation(summary = "Listar clientes")
    @GetMapping
    public List<Client> list() {
        return clientRepository.findAll();
    }

    @Operation(summary = "Adicionar cliente")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Cliente criado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Requisição inválida")
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client store(@RequestBody Client cliente) {
        return clientRepository.save(cliente);
    }
}
