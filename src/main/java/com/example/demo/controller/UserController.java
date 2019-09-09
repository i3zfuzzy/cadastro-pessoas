package com.example.demo.controller;

import com.example.demo.repository.UserRepository;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RequestMapping("/api/usuarios")
@RestController
public class UserController {


    @Autowired
    private UserService userService;

    @GetMapping("/signup")
    public void showSignUpForm(User user) {
        String test = "add-user";
    }

    @PostMapping
    public void addUser(@RequestBody @Valid User user) {
        userService.saveUser(user);
    }

    @DeleteMapping("delete/{id}")
    public void deletePost(@PathVariable Long id) {
        userService.deleteUser(id);
    }


    @GetMapping
    public List<User> recuperarUsuarios() {
        return userService.recuperarUsuarios();
    }

    @GetMapping("/{id}")
    public Optional<User> recuperarUsuariosporID(@PathVariable Long id) {
        return userService.recuperarUsuariosId(id);
    }

    @GetMapping("filter/{filtro}")
    public List<User> filtrandoUsuarios(@PathVariable(name = "filtro") String filtro) {
        return userService.filterUserByName(filtro);
    }

    @GetMapping("filter-by-email/{email}")
    public List<User> filtrandoPorEmail(@PathVariable(name = "email") String email) {
        return userService.filterUserByEmail(email);
    }
    @GetMapping("/names")
    public List<User> recuperaNomes() {
        return null;
    }
}

