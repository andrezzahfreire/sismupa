package com.sisumupa.sisumupa_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisumupa.sisumupa_backend.domain.Associado;
import com.sisumupa.sisumupa_backend.repository.AssociadoRepository;

@Service
public class AssociadoService {
    @Autowired
    private AssociadoRepository associadoRepository;

    public Associado createAssociado(Associado associado){
       return  associadoRepository.save(associado);
    }

    public Associado readAssociado(Long id){
        Associado associadoex = associadoRepository.findById(id).orElse(null);
        if (associadoex == null) {
            throw new RuntimeException("Cliente não encontrado");
        }
       
        return associadoex;
    }

    public Associado updateAssociado(Associado associado){
         Associado associadoex = readAssociado(associado.getId());
         associadoex.setDependente(associado.getDependente());
         associadoex.setEmail(associado.getEmail());
         associadoex.setId(associado.getId());
         associadoex.setNome(associado.getNome());
         associadoex.setSenha(associado.getSenha());
        return associadoRepository.save(associadoex);
    }

    public void deleteAssociado(long id){
        if (readAssociado(id) != null) {
            associadoRepository.delete(readAssociado(id));
        }
       
    }

    public List<Associado> buscarTodosAssociados() {
        return associadoRepository.findAll();
    }

}
