package com.sisumupa.sisumupa_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sisumupa.sisumupa_backend.domain.Profissional;

@Repository
public interface ProfissionalRepository extends JpaRepository<Profissional, Long> {
    
}
