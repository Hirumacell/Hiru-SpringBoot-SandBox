package hiru.demospringboot.controller;

import hiru.demospringboot.controller.response.AuthResponse;
import hiru.demospringboot.dto.UserDto;
import hiru.demospringboot.dto.UserLoginDto;
import hiru.demospringboot.repository.UserRepository;
import hiru.demospringboot.useCase.UserLoginUseCase;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserRepository userRepository;

    private final UserLoginUseCase userLoginUseCase;
/*
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/login")
    public Boolean login(@RequestParam String username, @RequestParam String password) {
        log.info("GET /api/user/login");
        return userLoginUseCase.login(username, password);
    }

 */

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/loginToken")
    public AuthResponse loginToken(@RequestBody UserLoginDto userLoginDto) {
        log.info("GET /api/user/loginToken");
        return userLoginUseCase.loginToken(userLoginDto);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/register")
    public UserDto register(@RequestBody UserDto userDto) {
        log.info("POST /api/user/register");
        return userLoginUseCase.register(userDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @SecurityRequirement(name = "bearer")
    @GetMapping("/checkToken")
    public boolean CheckUserToken() {
        log.info("GET /api/user/checkToken");
        return true;
    }


    // Get Header of the request
    @ResponseStatus(HttpStatus.OK)
    @SecurityRequirement(name = "bearer")
    @GetMapping("/me")
    public UserDto GetUserInfo(@RequestAttribute("Utilisateur_id") String id) {
        log.info("GET /api/user/me");
        return userLoginUseCase.getUser(id);
    }
    
    /*
    @ResponseStatus(HttpStatus.OK)
    @SecurityRequirement(name = "bearer")
    @GetMapping("/getToken")
    public String Gettoken() {
        log.info("GET /api/user/getToken");
        return userLoginUseCase.getToken();
    }
    */

}
