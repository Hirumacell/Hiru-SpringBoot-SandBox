package hiru.demospringboot.useCase.SomethingUseCase;


import hiru.demospringboot.repository.SomethingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class SomethingDeleteUseCase {
    private final SomethingRepository repository;

    public void delete(Long id) {
        repository.deleteById(id);
    }

}