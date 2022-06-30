package africa.semicolon.eventBrite.dto.requests;

import lombok.Data;

@Data
public class LoginUserRequest {
    private String email;
    private String password;
}

