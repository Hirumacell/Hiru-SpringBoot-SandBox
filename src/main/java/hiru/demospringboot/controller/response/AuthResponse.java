package hiru.demospringboot.controller.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthResponse {
    public String token;

    public AuthResponse() {}

    public AuthResponse(String token) {
        this.token = token;
    }
}
