package com.sisumupa.sisumupa_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sisumupa.sisumupa_backend.domain.User;
import com.sisumupa.sisumupa_backend.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User criarusuario(User user){
        return userRepository.save(user);
    }

    public User readUsuario(Long id){
        User userex = userRepository.findById(id).orElse(null);
        if (userex == null) {
            throw new RuntimeException("Usuario não encontrado");
        }
       
        return userex;
    }

    public User updateUsuario(User user){
        User userex = readUsuario(user.getId());
         userex.setEmail(user.getEmail());
         userex.setId(user.getId());
         userex.setNome(user.getNome());
         userex.setSenha(user.getSenha());
         userex.setSenha(user.getSenha());
        return userRepository.save(userex);
    }

    public void deleteUsuario(long id){
        if (readUsuario(id) != null) {
            userRepository.delete(readUsuario(id));
        }
    }

    public List<User> buscarTodosUsers() {
        return userRepository.findAll();
    }

}
