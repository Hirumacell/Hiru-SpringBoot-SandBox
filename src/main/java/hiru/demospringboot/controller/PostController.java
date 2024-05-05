package hiru.demospringboot.controller;


import hiru.demospringboot.dto.AddPostDto;
import hiru.demospringboot.dto.PostDto;
import hiru.demospringboot.dto.UserDto;
import hiru.demospringboot.dto.UserWithPostDto;
import hiru.demospringboot.repository.PostRepository;
import hiru.demospringboot.useCase.PostUseCase;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/post")
public class PostController {

    private final PostUseCase postUseCase;

    /*
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public AddPostDto create(@RequestBody AddPostDto postDto) {
        log.info("POST /api/post/create {}", postDto);
        return postUseCase.create(postDto);
    }*/

    @ResponseStatus(HttpStatus.CREATED)
    @SecurityRequirement(name = "bearer")
    @PostMapping("/one")
    public PostDto create(@RequestBody AddPostDto body, @RequestAttribute("Utilisateur_id") String id) {
        log.info("POST /api/post/create {}", body);
        return postUseCase.createWithUserAuth(body, id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/post")
    public List<UserWithPostDto> findAll() {
        log.info("GET /api/post/get");
        return postUseCase.findAll();
    }

}
