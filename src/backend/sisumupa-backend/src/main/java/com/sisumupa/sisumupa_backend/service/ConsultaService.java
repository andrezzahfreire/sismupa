package com.sisumupa.sisumupa_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sisumupa.sisumupa_backend.domain.Consulta;
import com.sisumupa.sisumupa_backend.repository.ConsultaRepository;

@Service
public class ConsultaService {
    @Autowired
    private ConsultaRepository consultaRepository;
    // implementar crud

    public Consulta createConsulta(Consulta consulta){
        return consultaRepository.save(consulta);
    }

    public Consulta readConsulta(Long id){
        Consulta consultaex = consultaRepository.findById(id).orElse(null);
        if (consultaex == null) {
            throw new RuntimeException("Cliente não encontrado");
        }
       
        return consultaex;
    }

    public Consulta updateConsulta(Consulta consulta){
        Consulta consultaex = readConsulta(consulta.getId());
         consultaex.setPaciente(consulta.getPaciente());
         consultaex.setProfissional(consulta.getProfissional());
        return consultaRepository.save(consultaex);
    }

    public void deleteConsulta(long id){
        if (readConsulta(id) == null) {
            consultaRepository.delete(readConsulta(id));
        }
    }

    public List<Consulta> buscarTodosconsultas() {
        return consultaRepository.findAll();
    }
}
