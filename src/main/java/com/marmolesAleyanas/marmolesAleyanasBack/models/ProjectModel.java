package com.marmolesAleyanas.marmolesAleyanasBack.models;

import java.time.LocalDate;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name="projects")
@Data
public class ProjectModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "El DNI no puede ser nulo")
    @Size(min = 9, max = 9, message="El DNI o NIF debe contener 9 caractéres")
    @Pattern(regexp = "^\\d{8}[A-Za-z]$", message="El DNI o NIF debe contener 8 números y 1 letra")
    private String dninif;

    @NotNull(message = "El nombre no puede ser nulo")
    private String name;

    @NotNull(message = "El email no puede ser nulo")
    @Email(message = "El email debe ser válido")
    private String email;

    @NotNull
    @Pattern(regexp = "^\\d{9}$", message = "El teléfono debe constar de 9 dígitos")
    private String phone;

    @Pattern(regexp = "^\\d{9}$", message = "El teléfono debe constar de 9 dígitos")
    private String altphone;

    @Column(name = "date")
    private LocalDate date = LocalDate.now();

    @FutureOrPresent(message = "La fecha de finalización no puede ser anterior a la fecha actual")
    @Column(name = "finishDate")
    private LocalDate finishDate;

    private String address;
}
