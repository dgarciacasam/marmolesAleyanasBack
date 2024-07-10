package com.marmolesAleyanas.marmolesAleyanasBack.models;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProjectDTO {
    @Size(min = 9, max = 9, message="El DNI o NIF debe contener 8 números y 1 letra")
    @Pattern(regexp = "^\\d{8}[A-Za-z]$")
    private String dninif;

    private String address;

    private String name;

    @Email(message = "El email debe ser válido")
    private String email;

    @Pattern(regexp = "^\\d{9}$", message = "El teléfono debe constar de 9 dígitos")
    private String phone;

    @Pattern(regexp = "^\\d{9}$",message = "El teléfono debe constar de 9 dígitos")
    private String altphone;

    @FutureOrPresent(message = "La fecha de finalización no puede ser anterior a la fecha actual")
    private LocalDate finishDate;
}
