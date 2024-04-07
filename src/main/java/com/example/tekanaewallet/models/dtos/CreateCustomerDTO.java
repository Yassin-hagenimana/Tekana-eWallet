package com.example.tekanaewallet.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateCustomerDTO {
    private String names;
    private String email;
    private String phoneNumber;
    private String country;
    private String nationalId;


}
