package com.protfolio.pm.project_manager_api.controllers;

import com.protfolio.pm.project_manager_api.core.facades.ProjectFacade;
import com.protfolio.pm.project_manager_api.core.model.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProjectController {

    private final ProjectFacade projectFacade;

    @Autowired
    public ProjectController(ProjectFacade projectFacade) {
        this.projectFacade = projectFacade;
    }

    @GetMapping("/project")
    public ResponseEntity<List<Project>> getProjects() {
        return ResponseEntity.ok(projectFacade.getProjects());
    }
    
    @PostMapping("/project")
    public ResponseEntity<String> createProject(@RequestBody Project project) {
        Project savedProject = projectFacade.insertProject(project);
        return ResponseEntity.ok("OK");
    }
}
