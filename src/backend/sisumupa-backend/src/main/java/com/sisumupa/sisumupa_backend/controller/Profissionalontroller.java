package com.sisumupa.sisumupa_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sisumupa.sisumupa_backend.domain.Profissional;
import com.sisumupa.sisumupa_backend.service.ProfissionalService;

public class Profissionalontroller {
        @Autowired
    private ProfissionalService profissionalService;

    //implementar os principais métodos HTTP: GET, POST, PUT, DELETE, PATCH
   
    @GetMapping
    public List<Profissional> buscarTodosProfissionals(){
        return profissionalService.buscarTodosProfissionals();
    }

    @GetMapping("/{id}")
    public Profissional buscartProfissionalPorId(@PathVariable Long id){
        Profissional profissional = profissionalService.readProfissional(id);
        if (profissional == null) {
            return null;
        }
        return profissional;
    }

    @PostMapping
    public Profissional criarProfissional(@RequestBody Profissional profissional){
        return profissionalService.createProfissional(profissional);
    }

    @PutMapping("/{id}")
    public Profissional atualizarProfissional(@PathVariable Long id, @RequestBody Profissional Profissional                                                                                                                                     ){
        Profissional.setId(id);
        return profissionalService.updateProfissional(Profissional);
    }
    
    @DeleteMapping("/{id}")
    public void excluirProfissional(@PathVariable long id){
        profissionalService.deleteProfissional(id);
    }

}
