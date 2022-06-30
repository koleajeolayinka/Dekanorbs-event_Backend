package africa.semicolon.eventBrite.services;

import africa.semicolon.eventBrite.data.repositories.UserRepository;
import africa.semicolon.eventBrite.dto.requests.RegisterUserRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;


    @Test
    public void registerUserTest(){
        RegisterUserRequest request = new RegisterUserRequest();
        request.setEmail("kole@kk");
        request.setFirstName("tob");
        request.setLastName("kol");
        request.setPassword("code");
        userService.registerUser(request);

        assertEquals(1, userRepository.count());
    }

}