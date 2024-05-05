package hiru.demospringboot.useCase;

import hiru.demospringboot.dto.PostDto;
import hiru.demospringboot.dto.UserWithPostDto;
import hiru.demospringboot.entity.PostEntity;
import hiru.demospringboot.entity.UserEntity;
import hiru.demospringboot.mapper.PostMapper;
import hiru.demospringboot.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class PostUseCase {
    private final PostRepository postRepository;
    private final PostMapper postMapper;

    public PostDto create(PostDto postDto) {
        PostEntity postEntity = postMapper.toEntity(postDto);
        postEntity = postRepository.save(postEntity);
        return postMapper.toDto(postEntity);
    }

    public List<UserWithPostDto> findAll() {
        List<PostEntity> postEntityList = postRepository.findAll();
        List<UserEntity> userEntityList = postEntityList.stream()
                .map(PostEntity::getAuthor)
                .collect(Collectors.toList());

         List<UserWithPostDto> Listtoreturn = userEntityList.stream()
                .map(userEntity -> postMapper.toUserWithPostDto(postEntityList.stream()
                        .filter(postEntity -> postEntity.getAuthor().getId().equals(userEntity.getId()))
                        .collect(Collectors.toList()), userEntity))
                .collect(Collectors.toList());

        return Listtoreturn;
    }
}
