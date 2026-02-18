package com.protfolio.pm.project_manager_api.controllers.project;

import com.protfolio.pm.project_manager_api.core.facades.project.ProjectFacade;
import com.protfolio.pm.project_manager_api.core.model.dto.project.CreateProjectBody;
import com.protfolio.pm.project_manager_api.core.model.dto.project.CreateProjectResponse;
import com.protfolio.pm.project_manager_api.core.model.dto.project.ProjectsReturn;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/project")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectFacade projectFacade;

    @GetMapping
    public ResponseEntity<List<ProjectsReturn>> getProjects() {
        return ResponseEntity.ok(projectFacade.getProjects());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectsReturn> getProjectById(@PathVariable Long id) {
        return ResponseEntity.ok(projectFacade.getProjectById(id));
    }

    @PostMapping
    public ResponseEntity<CreateProjectResponse> createProject(@RequestBody @Valid CreateProjectBody body) {
        CreateProjectResponse ret = projectFacade.insertProject(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(ret);
    }
}
