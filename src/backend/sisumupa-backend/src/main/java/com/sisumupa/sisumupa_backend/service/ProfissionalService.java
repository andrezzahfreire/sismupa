package com.sisumupa.sisumupa_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisumupa.sisumupa_backend.domain.Profissional;
import com.sisumupa.sisumupa_backend.repository.ProfissionalRepository;

@Service
public class ProfissionalService {
    @Autowired
    private ProfissionalRepository profissionalRepository;
    // implementar crud

    public Profissional createProfissional(Profissional profissional){
        return  profissionalRepository.save(profissional);

    }

    public Profissional readProfissional(Long id){
        Profissional profissionalex = profissionalRepository.findById(id).orElse(null);
        if (profissionalex == null) {
            throw new RuntimeException("Cliente não encontrado");
        }
       
        return profissionalex;
    }

    public Profissional updateProfissional(Profissional profissional){
         Profissional profissionalex = readProfissional(profissional.getId());
         profissionalex.setEmail(profissional.getEmail());
         profissionalex.setId(profissional.getId());
         profissionalex.setNome(profissional.getNome());
         profissionalex.setSenha(profissional.getSenha());
         profissionalex.setSenha(profissional.getSenha());
        return profissionalRepository.save(profissionalex);
    }

    public void deleteProfissional(long id){
        if (readProfissional(id) != null) {
            profissionalRepository.delete(readProfissional(id));
        }
    }

    public List<Profissional> buscarTodosProfissionals() {
        return profissionalRepository.findAll();
    }
}
