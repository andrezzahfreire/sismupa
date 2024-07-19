package com.sisumupa.sisumupa_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sisumupa.sisumupa_backend.domain.Consulta;
import com.sisumupa.sisumupa_backend.service.ConsultaService;

public class ConsultaController { 

    @Autowired
    private ConsultaService consultaService;

    
    @GetMapping
    public List<Consulta> buscarTodosConsultas(){
        return consultaService.buscarTodosconsultas();
    }

    @GetMapping("/{id}")
    public Consulta buscartconsultaPorId(@PathVariable Long id){
        Consulta consulta = consultaService.readConsulta(id);
        if (consulta == null) {
            return null;
        }
        return consulta;
    }

    @PostMapping
    public Consulta criarconsulta(@RequestBody Consulta consulta){
        return consultaService.createConsulta(consulta);
    }

    @PutMapping("/{id}")
    public Consulta atualizarconsulta(@PathVariable Long id, @RequestBody Consulta consulta                                                                                                                                     ){
        consulta.setId(id);
        return consultaService.updateConsulta(consulta);
    }
    
    @DeleteMapping("/{id}")
    public void excluirconsulta(@PathVariable long id){
        consultaService.deleteConsulta(id);
    }

}
