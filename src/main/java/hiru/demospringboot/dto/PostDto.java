package hiru.demospringboot.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PostDto {
    private Long id;
    private String title;
    private String content;
}
