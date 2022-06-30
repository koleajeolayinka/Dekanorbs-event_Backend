package africa.semicolon.eventBrite.controller;

import africa.semicolon.eventBrite.dto.requests.LoginUserRequest;
import africa.semicolon.eventBrite.dto.requests.RegisterUserRequest;
import africa.semicolon.eventBrite.dto.responses.LoginUserResponse;
import africa.semicolon.eventBrite.dto.responses.RegisterUserResponse;
import africa.semicolon.eventBrite.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userServices;

    @PostMapping("/user")
    public RegisterUserResponse register(@RequestBody RegisterUserRequest registerUserRequest) {
        return userServices.registerUser(registerUserRequest);
    }
    @PostMapping("/login/user")
    public LoginUserResponse login(@RequestBody LoginUserRequest loginUserRequest){
        return userServices.loginUser(loginUserRequest);
    }
}
