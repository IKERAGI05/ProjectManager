package com.portfolio.pm.project_manager_api.controllers.client;

import com.portfolio.pm.project_manager_api.core.facades.client.ClientFacade;
import com.portfolio.pm.project_manager_api.core.model.dto.client.ClientReturn;
import com.portfolio.pm.project_manager_api.core.model.dto.client.CreateClientBody;
import com.portfolio.pm.project_manager_api.core.model.dto.client.CreateClientResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientFacade clientFacade;

    @GetMapping
    public ResponseEntity<List<ClientReturn>> getClients() {
        return ResponseEntity.ok(clientFacade.getClients());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientReturn> getClientById(@PathVariable Long id) {
        return ResponseEntity.ok(clientFacade.getClientById(id));
    }

    @PostMapping
    public ResponseEntity<CreateClientResponse> createClient(@RequestBody @Valid CreateClientBody body) {
        CreateClientResponse ret = clientFacade.insertClient(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(ret);
    }
}
