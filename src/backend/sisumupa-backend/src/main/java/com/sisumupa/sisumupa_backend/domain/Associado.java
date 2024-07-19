package com.sisumupa.sisumupa_backend.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
public class Associado extends User implements Serializable{
    public Associado(long l, String string, String string2) {
        //TODO Auto-generated constructor stub
    }

    @Column(nullable = false, length = 100)
    Paciente dependente;
}
