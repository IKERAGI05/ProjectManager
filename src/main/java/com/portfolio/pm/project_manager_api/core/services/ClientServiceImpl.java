package com.portfolio.pm.project_manager_api.core.services;

import com.portfolio.pm.project_manager_api.core.model.dto.client.ClientReturn;
import com.portfolio.pm.project_manager_api.core.model.dto.client.CreateClientBody;
import com.portfolio.pm.project_manager_api.core.model.dto.client.CreateClientResponse;
import com.portfolio.pm.project_manager_api.core.model.exception.ClientNotFoundException;
import com.portfolio.pm.project_manager_api.core.model.exception.ClientRepositoryException;
import com.portfolio.pm.project_manager_api.core.model.utils.assembler.ClientAssembler;
import com.portfolio.pm.project_manager_api.core.repositories.ClientRepository;
import com.portfolio.pm.project_manager_api.infrastructure.entity.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Override
    public List<ClientReturn> getAllClients() {
        try {
            List<Client> listClients = clientRepository.findAll();
            return ClientAssembler.buildResponse(listClients);
        } catch (Exception ex) {
            throw new ClientRepositoryException("Database error while retrieving clients", ex);
        }
    }

    @Override
    public ClientReturn getClientById(Long id) {
        if (!clientRepository.existsById(id)) {
            throw new ClientNotFoundException("Client does not exist with ID: " + id);
        }
        try {
            Client client = clientRepository.findById(id)
                    .orElseThrow(() -> new ClientNotFoundException("Client not found with ID: " + id));
            return ClientAssembler.buildResponseById(client);
        } catch (Exception ex) {
            throw new ClientRepositoryException("Database error while retrieving client by ID", ex);
        }
    }

    @Override
    public CreateClientResponse insertClient(CreateClientBody body) {
        try {
            clientRepository.save(ClientAssembler.buildEntity(body));
            return CreateClientResponse.builder()
                    .valid(true)
                    .build();
        } catch (Exception ex) {
            throw new ClientRepositoryException("Database error while saving client", ex);
        }
    }
}
