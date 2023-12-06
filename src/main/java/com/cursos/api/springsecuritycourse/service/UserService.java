package com.cursos.api.springsecuritycourse.service;

import com.cursos.api.springsecuritycourse.dto.SaveuserDto;
import com.cursos.api.springsecuritycourse.persistence.entity.User;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface UserService {
    User registerCustomer(SaveuserDto newUser);

    Optional<User> findByUsername(String username);
}
