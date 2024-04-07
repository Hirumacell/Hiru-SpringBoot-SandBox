package hiru.demospringboot.useCase;

import hiru.demospringboot.controller.response.AuthResponse;
import hiru.demospringboot.dto.UserDto;
import hiru.demospringboot.dto.UserLoginDto;
import hiru.demospringboot.entity.UserEntity;
import hiru.demospringboot.mapper.UserMapper;
import hiru.demospringboot.repository.UserRepository;
import hiru.demospringboot.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.server.ResponseStatusException;


@RequiredArgsConstructor
@Component
public class UserLoginUseCase {
    private final UserRepository repository;
    private final UserMapper mapper;

    /*
    public boolean login(String username, String password) {
        UserEntity User = repository.findByUsername(username).get();
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        return User.getUsername().equals(username) && passwordEncoder.matches(password, User.getPassword());
    }

     */

    public AuthResponse loginToken(UserLoginDto user) {

        UserEntity User = repository.findByUsername(user.getUsername()).get();
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if (User.getUsername().equals(user.getUsername()) && passwordEncoder.matches(user.getUsername(), User.getPassword())) {
            JwtUtil jwtUtil = new JwtUtil();

            String token = jwtUtil.createToken();

            AuthResponse authResponse = new AuthResponse();
            authResponse.setToken(token);

            return authResponse;
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "mauvais combo");

    }


    public String HashPassword(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }


    public UserDto register(UserDto dto) {
        dto.setPassword(HashPassword(dto.getPassword()));
        UserEntity entity = mapper.toEntity(dto);
        UserEntity saved = repository.save(entity);
        return mapper.toDto(saved);
    }

    public boolean checkToken(String token) {
        JwtUtil jwtUtil = new JwtUtil();
        return jwtUtil.checkToken(token);
    }
}
