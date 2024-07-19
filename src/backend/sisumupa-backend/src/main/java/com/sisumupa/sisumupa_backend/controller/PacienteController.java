package com.sisumupa.sisumupa_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sisumupa.sisumupa_backend.domain.Paciente;
import com.sisumupa.sisumupa_backend.service.PacienteService;

public class PacienteController {
        @Autowired
    private PacienteService pacienteService;
   
    @GetMapping
    public List<Paciente> buscarTodospacientes(){
        return pacienteService.buscarTodosPacientes();
    }

    @GetMapping("/{id}")
    public Paciente buscartPacientePorId(@PathVariable Long id){
        Paciente paciente = pacienteService.readPaciente(id);
        if (paciente == null) {
            return null;
        }
        return paciente;
    }

    @PostMapping
    public Paciente criarPaciente(@RequestBody Paciente paciente){
        return pacienteService.createPaciente(paciente);
    }

    @PutMapping("/{id}")
    public Paciente atualizarPaciente(@PathVariable Long id, @RequestBody Paciente paciente                                                                                                                                     ){
        paciente.setId(id);
        return pacienteService.updatePaciente(paciente);
    }
    
    @DeleteMapping("/{id}")
    public void excluirPaciente(@PathVariable long id){
        pacienteService.deletePaciente(id);
    }

}
