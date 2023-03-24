package com.mycode.personmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO {

    @NotNull
    private Long id;
    private String nume = "";
    private double inaltime = 0;
    private String email = "";
    private double greutate = 0;
}
