package com.protfolio.pm.project_manager_api.core.services;

import com.protfolio.pm.project_manager_api.core.model.dto.project.CreateProjectBody;
import com.protfolio.pm.project_manager_api.core.model.dto.project.CreateProjectResponse;
import com.protfolio.pm.project_manager_api.core.model.dto.project.ProjectsReturn;
import com.protfolio.pm.project_manager_api.core.model.exception.ProjectNotFoundException;
import com.protfolio.pm.project_manager_api.core.model.exception.ProjectRepositoryException;
import com.protfolio.pm.project_manager_api.core.model.utils.assembler.ProjectAssembler;
import com.protfolio.pm.project_manager_api.core.repositories.ClientRepository;
import com.protfolio.pm.project_manager_api.core.repositories.ProjectRepository;
import com.protfolio.pm.project_manager_api.infrastructure.entity.Client;
import com.protfolio.pm.project_manager_api.infrastructure.entity.Project;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {
    //TODO REVISAR LA SALIDA AL OBTENER PROYECTOS Y PENSAR COMO SACAR LOS CLIENTES.
    private final ProjectRepository projectRepository;
    private final ClientRepository clientRepository;

    @Override
    public List<ProjectsReturn> getAllProjects() {
        try {
            List<Project> listProjects = projectRepository.findAll();
            return ProjectAssembler.buildResponse(listProjects);
        } catch (Exception ex) {
            throw new ProjectRepositoryException("ProjectServiceImpl.getAllProjects -> Database error while retrieving projects", ex);
        }
    }

    @Override
    public ProjectsReturn getProjectById(Long id) {
        if (!projectRepository.existsById(id)) {
            throw new ProjectNotFoundException("ProjectServiceImpl.getProjectById -> Error Project does not exist " + id);
        }
        try {
            Project project = projectRepository.findById(id)
                    .orElseThrow(() -> new ProjectNotFoundException("Project not found with ID: " + id));
            return ProjectAssembler.buildResponseById(project);
        } catch (Exception ex) {
            throw new ProjectRepositoryException("ProjectServiceImpl.getProjectById -> Database error while retrieving project by ID", ex);
        }
    }

    @Override
    public CreateProjectResponse insertProject(CreateProjectBody body) {
        try {
            Client client = clientRepository.findById(body.clientId())
                    .orElseThrow(() -> new ProjectNotFoundException("ProjectServiceImpl.insertProject -> Client not found with ID: " + body.clientId()));
            Project project = ProjectAssembler.buildEntity(body, client);
            Project savedProject = projectRepository.save(project);
            return CreateProjectResponse.builder()
                    .id(savedProject.getId())
                    .name(savedProject.getName())
                    .build();
        } catch (Exception ex) {
            throw new ProjectRepositoryException("ProjectServiceImpl.insertProject -> Database error while saving project", ex);
        }
    }
}
