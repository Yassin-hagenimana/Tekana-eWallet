package com.example.tekanaewallet.models;

import com.example.tekanaewallet.audits.TimeStampAudit;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "customers")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Customer extends TimeStampAudit{
    @Id
    @GeneratedValue()
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "names", nullable = false)
    private String names;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "country")
    private String country;

    @Column(name = "national_id")
    private String nationalId;

}
