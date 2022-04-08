package com.example.people.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDto {

    @NotEmpty(message = "Email is required")
    private String name;
    @NotEmpty(message = "Email is required")
    @Email
    private String email;
    @NotEmpty(message = "CPF is required")
    @CPF
    private String cpf;
    @NotEmpty(message = "Eddress is required")
    private String address;
    @NotEmpty(message = "Phone is required")
    private String phone;


}
