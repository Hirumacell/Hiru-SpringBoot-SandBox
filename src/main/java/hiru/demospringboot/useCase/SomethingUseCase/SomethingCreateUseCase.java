package hiru.demospringboot.useCase.SomethingUseCase;

import hiru.demospringboot.dto.SomethingDto;
import hiru.demospringboot.entity.SomethingEntity;
import hiru.demospringboot.mapper.SomethingMapper;
import hiru.demospringboot.repository.SomethingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class SomethingCreateUseCase {
    private final SomethingRepository repository;
    private final SomethingMapper mapper;

    public SomethingDto create(SomethingDto dto) {
        SomethingEntity entity = mapper.toEntity(dto);
        entity = repository.save(entity);
        return mapper.toDto(entity);
    }
}
