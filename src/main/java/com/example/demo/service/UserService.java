package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository; // Instancia Classe

    public void saveUser(User user) {                       //metodo
        userRepository.save(user);
    }

    public void deleteUser(Long id) {                   //metodo
        userRepository.deleteById(id);
    }

    public List<User> recuperarUsuarios() {                         //metodo
        return userRepository.findAll();
    }

    public Optional<User> recuperarUsuariosId(Long id) {                //metodo
       return userRepository.findById(id);
    }

    public List<User> filterUserByName(String filtro){              //metodo
        return userRepository.findUsersByFiltro(filtro);
    }

    public List<User> filterUserByEmail(String email) {              //metodo
        return userRepository.findUsersByEmail(email);
    }
}

