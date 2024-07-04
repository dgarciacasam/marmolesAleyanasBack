package com.marmolesAleyanas.marmolesAleyanasBack.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="projects")
@Data
public class ProjectModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String dninif;

    private String name;

    private String email;

    private String phone;

    private String altphone;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "finishDate")
    private LocalDate finishDate;

    private String address;
}
