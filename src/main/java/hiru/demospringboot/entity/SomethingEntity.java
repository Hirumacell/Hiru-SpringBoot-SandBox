package hiru.demospringboot.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@Getter
@Setter
public class SomethingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    public SomethingEntity() {
    }

    public SomethingEntity(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public SomethingEntity(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

}
