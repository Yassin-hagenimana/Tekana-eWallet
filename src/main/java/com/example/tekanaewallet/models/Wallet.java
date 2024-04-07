package com.example.tekanaewallet.models;

import com.example.tekanaewallet.audits.TimeStampAudit;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "wallets")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Wallet extends TimeStampAudit {
    @Id
    @GeneratedValue()
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name="balance")
    private int balance;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false)
    private Customer customer;
}
