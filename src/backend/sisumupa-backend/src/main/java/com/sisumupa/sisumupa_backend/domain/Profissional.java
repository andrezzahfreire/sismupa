package com.sisumupa.sisumupa_backend.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Profissional extends User{
    @Column(nullable = false, length = 100)
    private String especialidade;
}
