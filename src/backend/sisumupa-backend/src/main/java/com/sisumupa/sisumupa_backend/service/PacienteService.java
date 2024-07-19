package com.sisumupa.sisumupa_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sisumupa.sisumupa_backend.domain.Paciente;
import com.sisumupa.sisumupa_backend.repository.PacienteRepository;

@Service
public class PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;

    public Paciente createPaciente(Paciente paciente){
        return  pacienteRepository.save(paciente);
    }

    public Paciente readPaciente(Long id){
        Paciente pacienteex = pacienteRepository.findById(id).orElse(null);
        if (pacienteex == null) {
            throw new RuntimeException("Cliente não encontrado");
        }
        return pacienteex;
    }

    public Paciente updatePaciente(Paciente paciente){
         Paciente pacienteex = readPaciente(paciente.getId());
         pacienteex.setEmail(paciente.getEmail());
         pacienteex.setId(paciente.getId());
         pacienteex.setNome(paciente.getNome());
         pacienteex.setSenha(paciente.getSenha());
        return pacienteRepository.save(pacienteex);
    }

    public void deletePaciente(long id){
        if (readPaciente(id) == null) {
            pacienteRepository.delete(readPaciente(id));
        }
    }

    public List<Paciente> buscarTodosPacientes() {
        return pacienteRepository.findAll();
    }

}
