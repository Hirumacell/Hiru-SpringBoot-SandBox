package hiru.demospringboot.mapper;

import hiru.demospringboot.dto.PostDto;
import hiru.demospringboot.dto.UserWithPostDto;
import hiru.demospringboot.entity.PostEntity;
import hiru.demospringboot.entity.UserEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PostMapper {

    public PostDto toDto(PostEntity entity) {
        if (entity == null) {
            return null;
        }
        PostDto dto = new PostDto();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setContent(entity.getContent());
        return dto;
    }

    public PostEntity toEntity(PostDto dto) {
        if (dto == null) {
            return null;
        }
        PostEntity entity = new PostEntity();
        entity.setId(dto.getId());
        entity.setTitle(dto.getTitle());
        entity.setContent(dto.getContent());
        return entity;
    }

    public UserWithPostDto toUserWithPostDto(List<PostEntity> postEntityList, UserEntity userEntity) {
        if (postEntityList == null || userEntity == null) {
            return null;
        }

        UserWithPostDto dto = new UserWithPostDto();
        dto.setId(userEntity.getId());
        dto.setUsername(userEntity.getUsername());

        dto.setPosts(postEntityList.stream()
                .map(this::toDto)
                .collect(Collectors.toSet()));

        return dto;
    }
}
