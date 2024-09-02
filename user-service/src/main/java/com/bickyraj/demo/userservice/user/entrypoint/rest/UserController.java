package com.bickyraj.demo.userservice.user.entrypoint.rest;

import com.bickyraj.demo.userservice.user.application.RegisterUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final RegisterUserUseCase registerUserUseCase;

    @PostMapping("/register")
    @PreAuthorize("permitAll()")
    public Boolean register(@RequestBody RegisterUserRequestBody requestBody) {
        return registerUserUseCase.execute(RegisterUserUseCase.Request.of(requestBody))
                .getSuccess();
    }
}
