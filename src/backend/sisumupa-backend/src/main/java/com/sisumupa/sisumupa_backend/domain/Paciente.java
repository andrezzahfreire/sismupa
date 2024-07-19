package com.sisumupa.sisumupa_backend.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Data;

@Entity
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Paciente extends User implements Serializable{
    @Column(nullable = false, length = 100)
    private String necessidade;
}
