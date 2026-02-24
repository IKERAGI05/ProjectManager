package com.portfolio.pm.project_manager_api.core.facades.client.impl;

import com.portfolio.pm.project_manager_api.core.facades.client.ClientFacade;
import com.portfolio.pm.project_manager_api.core.model.dto.client.ClientReturn;
import com.portfolio.pm.project_manager_api.core.model.dto.client.CreateClientBody;
import com.portfolio.pm.project_manager_api.core.model.dto.client.CreateClientResponse;
import com.portfolio.pm.project_manager_api.core.services.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ClientFacadeImpl implements ClientFacade {

    private final ClientService clientService;

    @Override
    public List<ClientReturn> getClients() {
        return clientService.getAllClients();
    }

    @Override
    public ClientReturn getClientById(Long id) {
        return clientService.getClientById(id);
    }

    @Override
    public CreateClientResponse insertClient(CreateClientBody body) {
        return clientService.insertClient(body);
    }
}
