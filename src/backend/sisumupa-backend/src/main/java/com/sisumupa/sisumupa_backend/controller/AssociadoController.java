package com.sisumupa.sisumupa_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sisumupa.sisumupa_backend.service.AssociadoService;
import com.sisumupa.sisumupa_backend.domain.Associado;
@RestController
@RequestMapping("/api/v1/associados")

public class AssociadoController {

    @Autowired
    private AssociadoService associadoService;

    //implementar os principais métodos HTTP: GET, POST, PUT, DELETE, PATCH
   
    @GetMapping
    public List<Associado> buscarTodosAssociados(){
        return associadoService.buscarTodosAssociados();
    }

    @GetMapping("/{id}")
    public Associado buscartAssociadoPorId(@PathVariable Long id){
        Associado associado = associadoService.readAssociado(id);
        if (associado == null) {
            return null;
        }
        return associado;
    }

    @PostMapping
    public Associado criarAssociado(@RequestBody Associado associado){
        return associadoService.createAssociado(associado);
    }

    @PutMapping("/{id}")
    public Associado atualizarAssociado(@PathVariable Long id, @RequestBody Associado associado                                                                                                                                     ){
        associado.setId(id);
        return associadoService.updateAssociado(associado);
    }
    
    @DeleteMapping("/{id}")
    public void excluirAssociado(@PathVariable long id){
        associadoService.deleteAssociado(id);
    }

}
