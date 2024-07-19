package com.sisumupa.sisumupa_backend.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Profissional extends User implements Serializable{
    @Column(nullable = false, length = 100)
    private String especialidade;
}
