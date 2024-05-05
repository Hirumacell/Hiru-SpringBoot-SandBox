package hiru.demospringboot.controller;


import hiru.demospringboot.dto.PostDto;
import hiru.demospringboot.dto.UserWithPostDto;
import hiru.demospringboot.repository.PostRepository;
import hiru.demospringboot.useCase.PostUseCase;
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

    private final PostRepository postRepository;
    private final PostUseCase postUseCase;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public PostDto create(@RequestBody PostDto postDto) {
        log.info("POST /api/post/create {}", postDto);
        return postUseCase.create(postDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/post")
    public List<UserWithPostDto> findAll() {
        log.info("GET /api/post/get");
        return postUseCase.findAll();
    }
}
