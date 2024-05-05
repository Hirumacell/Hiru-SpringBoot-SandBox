package hiru.demospringboot.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Getter
@Setter
@ToString
public class UserWithPostDto {
    private Long id;
    private String username;
    private Set<PostDto> posts;
}
