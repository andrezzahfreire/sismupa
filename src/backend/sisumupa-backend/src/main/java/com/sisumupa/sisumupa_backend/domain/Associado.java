package com.sisumupa.sisumupa_backend.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
public class Associado extends User{
    @Column(nullable = false, length = 100)
    Paciente dependente;
}
