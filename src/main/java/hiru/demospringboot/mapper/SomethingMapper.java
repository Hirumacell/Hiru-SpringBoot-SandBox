package hiru.demospringboot.mapper;

import hiru.demospringboot.dto.SomethingDto;
import hiru.demospringboot.entity.SomethingEntity;
import org.springframework.stereotype.Component;

@Component
public class SomethingMapper {

    public SomethingDto toDto(SomethingEntity entity) {
        if (entity == null) {
            return null;
        }
        SomethingDto dto = new SomethingDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        return dto;
    }

    public SomethingEntity toEntity(SomethingDto dto) {
        if (dto == null) {
            return null;
        }
        SomethingEntity entity = new SomethingEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        return entity;
    }

}
