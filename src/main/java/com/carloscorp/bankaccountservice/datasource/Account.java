package com.carloscorp.bankaccountservice.datasource;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;


@Setter
@Getter
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(updatable = false, nullable = false)
    private String accountNumber;

    @Column(updatable = false, nullable = false)
    private String accountType;

    @Column(updatable = false, nullable = false)
    private Long clientId;

    private Double funds;

    @CreatedDate
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate creationDate;
}
