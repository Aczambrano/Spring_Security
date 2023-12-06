package com.cursos.api.springsecuritycourse.service.impl;

import com.cursos.api.springsecuritycourse.dto.SaveuserDto;
import com.cursos.api.springsecuritycourse.exception.InvalidPasswordException;
import com.cursos.api.springsecuritycourse.persistence.entity.User;
import com.cursos.api.springsecuritycourse.persistence.repository.UserRepository;
import com.cursos.api.springsecuritycourse.persistence.util.Role;
import com.cursos.api.springsecuritycourse.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public User registerCustomer(SaveuserDto newUser) {
        //validamos las contraseñas
        validatePassword(newUser);

        User user = new User();
        user.setName(newUser.getName());
        user.setUsername(newUser.getUsername());
        //seteamos el password con el codificador
        user.setPassword(passwordEncoder.encode(newUser.getPassword()));
        user.setRole(Role.ROLE_CUSTOMER);
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    private void validatePassword(SaveuserDto dto) {
        //Verifica que las contraseñas no estén vacías
        if(!StringUtils.hasText(dto.getPassword()) || !StringUtils.hasText(dto.getRepeatedPassword())){
            throw new InvalidPasswordException("Passwords don't match");
        }
        //Verifica que las contraseñas sean iguales
        if(!dto.getPassword().equals(dto.getRepeatedPassword())){
            throw new InvalidPasswordException("Passwords don't match");
        }

    }
}
