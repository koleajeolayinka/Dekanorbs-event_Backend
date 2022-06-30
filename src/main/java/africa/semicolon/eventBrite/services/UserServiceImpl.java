package africa.semicolon.eventBrite.services;

import africa.semicolon.eventBrite.data.model.User;
import africa.semicolon.eventBrite.data.repositories.UserRepository;
import africa.semicolon.eventBrite.dto.requests.LoginUserRequest;
import africa.semicolon.eventBrite.dto.requests.RegisterUserRequest;
import africa.semicolon.eventBrite.dto.responses.LoginUserResponse;
import africa.semicolon.eventBrite.dto.responses.RegisterUserResponse;
import africa.semicolon.eventBrite.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public RegisterUserResponse registerUser(RegisterUserRequest request) {
        User user = new User();
//        user.setEmail(request.getEmail());
//        user.setFirstName(request.getFirstName());
//        user.setLastName(request.getLastName());
//        user.setPassword(request.getPassword());
        Mapper.map(request, user);
        User savedUser = userRepository.save(user);
        RegisterUserResponse response = new RegisterUserResponse();
//        response.setEmail(savedUser.getEmail());
//        response.setDateCreated(DateTimeFormatter.ofPattern("EEEE, dd/MM/yyy, hh:mm, a").format(savedUser.getDateRegistered()));
       Mapper.map(savedUser, response);
        return response;
    }

    @Override
    public LoginUserResponse loginUser(LoginUserRequest loginUserRequest) {
        var theUser = userRepository.findByEmail(loginUserRequest.getEmail()).orElseThrow(()->
                new RuntimeException("User not found"));
        LoginUserResponse response = new LoginUserResponse();

        if(theUser.getPassword().equals(loginUserRequest.getPassword())){
            response.setEmail(loginUserRequest.getEmail());
            response.setStatusMessage("login successful");
        }
        return response;
    }
}
