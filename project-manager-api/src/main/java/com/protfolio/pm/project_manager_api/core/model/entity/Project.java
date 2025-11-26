package com.protfolio.pm.project_manager_api.core.model.entity;

import com.protfolio.pm.project_manager_api.core.model.ProjectStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private LocalDate startDate;

    private LocalDate deadlineDate;

//    @ManyToOne
//    @JoinColumn(name="client_id", nullable= false)
//    private Client client;

    @Enumerated(EnumType.STRING)
    private ProjectStatus status;
}
