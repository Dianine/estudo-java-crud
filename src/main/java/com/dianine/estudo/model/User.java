package com.dianine.estudo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

@Entity(name = "usuarios")
@Table(name = "usuarios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O campo não informado")
    private String name;

    @Email(message = "E-mail inválido")
    @NotBlank(message = "O campo não informado")
    private String email;

    @NotBlank(message = "O campo não informado")
    @Min(value = 7, message = "Deve ter no minimo 7 caracteres")
    private String password;

    @CPF(message = "Campo inválido")
    @NotBlank(message = "O campo não informado")
    private String cpf;
}
