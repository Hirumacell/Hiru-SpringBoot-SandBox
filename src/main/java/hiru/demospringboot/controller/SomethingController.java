package hiru.demospringboot.controller;


import hiru.demospringboot.dto.SomethingWithoutIdDto;
import hiru.demospringboot.useCase.SomethingUseCase.SomethingFindAllUseCase;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/something")
public class SomethingController {
    /*
    private final SomethingCreateUseCase somethingCreateUseCase;
    private final SomethingFindByIdUseCase somethingFindByIdUseCase;
    private final SomethingUpdateUseCase somethingUpdateUseCase;
    private final SomethingDeleteUseCase somethingDeleteUseCase;
    */

    private final SomethingFindAllUseCase somethingFindAllUseCase;

    /*
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public SomethingDto create(@RequestBody SomethingDto somethingDto) {
        log.info("POST /api/something {}", somethingDto);
        return somethingCreateUseCase.create(somethingDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<SomethingDto> findAll() {
        log.info("GET /api/something");
        return somethingFindAllUseCase.findAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/GetSpecificName")
    public SomethingDto findSpecificName() {
        log.info("GET /api/something/GetSpecificName");
        return somethingFindByIdUseCase.findSpecificName();
    }
    */
    @ResponseStatus(HttpStatus.OK)
    @SecurityRequirement(name = "bearer")
    @GetMapping("/GetNameAndDescription")
    public List<SomethingWithoutIdDto> findNameAndDescription() {
        log.info("GET /api/something/GetNameAndDescription");
        return somethingFindAllUseCase.findNameAndDescription();
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/findNameAndDescriptionUnsecure")
    public List<SomethingWithoutIdDto> findNameAndDescriptionUnsecure() {
        log.info("GET /api/something/GetNameAndDescription");
        return somethingFindAllUseCase.findNameAndDescription();
    }

    /*
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public SomethingDto findById(@PathVariable Long id) {
        log.info("GET /api/something/{}", id);
        return somethingFindByIdUseCase.findById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public SomethingDto update(@PathVariable Long id, @RequestBody SomethingDto somethingDto) {
        log.info("PUT /api/something/{} {}", id, somethingDto);
        return somethingUpdateUseCase.update(id, somethingDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        log.info("DELETE /api/something/{}", id);
        somethingDeleteUseCase.delete(id);
    }

     */
}
