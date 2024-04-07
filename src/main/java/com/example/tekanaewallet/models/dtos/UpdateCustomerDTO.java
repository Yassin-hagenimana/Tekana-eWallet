package com.example.tekanaewallet.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UpdateCustomerDTO {
    private String names;
    private String email;
    private String phoneNumber;
    private String country;
    private String nationalId;
}
