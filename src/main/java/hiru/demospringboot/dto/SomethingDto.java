package hiru.demospringboot.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SomethingDto {

    private Long id;
    private String name;
    private String description;
}
