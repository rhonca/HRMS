package com.honca.hrms.models.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.Objects;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String password;

    @ManyToOne
    @JoinColumn(name = "departament_id")
    Department department;

    @ManyToMany
    @JoinTable(name = "employee_project", joinColumns = @JoinColumn(name = "employee_id"), inverseJoinColumns = @JoinColumn(name = "project_id"))
    private Set<Project> projects;

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname);
    }

}
