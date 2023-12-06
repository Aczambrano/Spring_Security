package com.cursos.api.springsecuritycourse.service.authentication;

import com.cursos.api.springsecuritycourse.dto.RegisterUserDto;
import com.cursos.api.springsecuritycourse.dto.SaveuserDto;
import com.cursos.api.springsecuritycourse.persistence.entity.User;
import com.cursos.api.springsecuritycourse.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthenticateService {
    @Autowired
    private UserService userService;
    @Autowired
    private JwtService jwtService;
    public RegisterUserDto registerCustomer(SaveuserDto newUser) {
        User user = userService.registerCustomer(newUser);
        RegisterUserDto userDto = new RegisterUserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setUsername(user.getUsername());
        userDto.setRole(user.getRole().name());

        String jwt = jwtService.generateToken(user,generateExtraClaims(user));
        userDto.setJwt(jwt);

        return userDto;
    }

    private Map<String, Object> generateExtraClaims(User user) {
        Map<String,Object> extraClaims = new HashMap<>();
        extraClaims.put("name",user.getName());
        extraClaims.put("role",user.getRole().name());
        extraClaims.put("authorities",user.getAuthorities());

        return extraClaims;

    }
}