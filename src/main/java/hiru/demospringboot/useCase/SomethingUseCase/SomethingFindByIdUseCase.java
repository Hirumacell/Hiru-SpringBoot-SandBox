package hiru.demospringboot.useCase.SomethingUseCase;

import hiru.demospringboot.dto.SomethingDto;
import hiru.demospringboot.mapper.SomethingMapper;
import hiru.demospringboot.repository.SomethingRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@Component
public class SomethingFindByIdUseCase {
    private final SomethingRepository repository;
    private final SomethingMapper mapper;

    public SomethingDto findById(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(EntityNotFoundException::new);
    }

    public SomethingDto findSpecificName() {
        return repository.findMyFirstThing2()
                .stream()
                .map(mapper::toDto)
                .findFirst()
                .orElseThrow(EntityNotFoundException::new);
    }
}