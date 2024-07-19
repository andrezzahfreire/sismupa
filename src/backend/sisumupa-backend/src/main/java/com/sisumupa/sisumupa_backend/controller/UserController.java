package com.sisumupa.sisumupa_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sisumupa.sisumupa_backend.domain.User;
import com.sisumupa.sisumupa_backend.service.UserService;

public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> buscarTodosUsers(){
        return userService.buscarTodosUsers();
    }

    @GetMapping("/{id}")
    public User buscartUserPorId(@PathVariable Long id){
        User User = userService.readUsuario(id);
        if (User == null) {
            return null;
        }
        return User;
    }

    @PostMapping
    public User criarUser(@RequestBody User user){
        return userService.criarusuario(user);
    }

    @PutMapping("/{id}")
    public User atualizarUser(@PathVariable Long id, @RequestBody User user                                                                                                                                     ){
        user.setId(id);
        return userService.updateUsuario(user);
    }
    
    @DeleteMapping("/{id}")
    public void excluirUser(@PathVariable long id){
        userService.deleteUsuario(id);
    }

}
