package hiru.demospringboot.useCase.SomethingUseCase;

import hiru.demospringboot.dto.SomethingDto;
import hiru.demospringboot.dto.SomethingWithoutIdDto;
import hiru.demospringboot.entity.SomethingEntity;
import hiru.demospringboot.mapper.SomethingMapper;
import hiru.demospringboot.repository.SomethingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Component
public class SomethingFindAllUseCase {
    private final SomethingRepository repository;
    private final SomethingMapper mapper;

    public List<SomethingDto> findAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    public List<SomethingWithoutIdDto> findNameAndDescription(){
        List<SomethingEntity> entities = repository.findAll();
        List<SomethingWithoutIdDto> dtos = new ArrayList<>();

        for (SomethingEntity entity : entities) {
            SomethingWithoutIdDto dto = new SomethingWithoutIdDto();
            dto.setName(entity.getName());
            dto.setDescription(entity.getDescription());

            dtos.add(dto);
        }

        return dtos;
    }
}

