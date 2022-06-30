package africa.semicolon.eventBrite.services;

import africa.semicolon.eventBrite.dto.requests.LoginUserRequest;
import africa.semicolon.eventBrite.dto.requests.RegisterUserRequest;
import africa.semicolon.eventBrite.dto.responses.LoginUserResponse;
import africa.semicolon.eventBrite.dto.responses.RegisterUserResponse;

public interface UserService {
    RegisterUserResponse registerUser(RegisterUserRequest request);

    LoginUserResponse loginUser(LoginUserRequest loginUserRequest);
}
