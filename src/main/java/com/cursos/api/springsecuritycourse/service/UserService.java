package com.cursos.api.springsecuritycourse.service;

import com.cursos.api.springsecuritycourse.dto.SaveuserDto;
import com.cursos.api.springsecuritycourse.persistence.entity.User;

public interface UserService {
    User registerCustomer(SaveuserDto newUser);
}