package hiru.demospringboot.useCase.SomethingUseCase;

import hiru.demospringboot.dto.SomethingDto;
import hiru.demospringboot.entity.SomethingEntity;
import hiru.demospringboot.mapper.SomethingMapper;
import hiru.demospringboot.repository.SomethingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class SomethingUpdateUseCase {
    private final SomethingRepository repository;
    private final SomethingMapper mapper;

    public SomethingDto update(Long id, SomethingDto somethinDto) {
        somethinDto.setId(id);
        SomethingEntity entity = mapper.toEntity(somethinDto);
        SomethingEntity saved = repository.save(entity);
        return mapper.toDto(saved);
    }
}
