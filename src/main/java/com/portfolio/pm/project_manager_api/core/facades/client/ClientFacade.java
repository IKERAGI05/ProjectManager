package com.portfolio.pm.project_manager_api.core.facades.client;

import com.portfolio.pm.project_manager_api.core.model.dto.client.ClientReturn;
import com.portfolio.pm.project_manager_api.core.model.dto.client.CreateClientBody;
import com.portfolio.pm.project_manager_api.core.model.dto.client.CreateClientResponse;

import java.util.List;

public interface ClientFacade {

    List<ClientReturn> getClients();

    ClientReturn getClientById(Long id);

    CreateClientResponse insertClient(CreateClientBody body);
}
