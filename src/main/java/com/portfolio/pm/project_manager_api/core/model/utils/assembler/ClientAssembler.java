package com.portfolio.pm.project_manager_api.core.model.utils.assembler;

import com.portfolio.pm.project_manager_api.core.model.dto.client.ClientReturn;
import com.portfolio.pm.project_manager_api.core.model.dto.client.CreateClientBody;
import com.portfolio.pm.project_manager_api.infrastructure.entity.Client;

import java.util.ArrayList;
import java.util.List;

public class ClientAssembler {

    public static Client buildEntity(CreateClientBody body) {
        return Client.builder()
                .name(body.name())
                .surname(body.surname())
                .email(body.email())
                .phone(body.phone())
                .build();
    }

    public static List<ClientReturn> buildResponse(List<Client> clientList) {
        List<ClientReturn> ret = new ArrayList<>();

        clientList.forEach(c -> {
            ClientReturn clientReturn = ClientReturn.builder()
                    .id(c.getId())
                    .name(c.getName())
                    .surname(c.getSurname())
                    .email(c.getEmail())
                    .phone(c.getPhone())
                    .build();
            ret.add(clientReturn);
        });
        return ret;
    }

    public static ClientReturn buildResponseById(Client client) {
        return ClientReturn.builder()
                .id(client.getId())
                .name(client.getName())
                .surname(client.getSurname())
                .email(client.getEmail())
                .phone(client.getPhone())
                .build();
    }
}
