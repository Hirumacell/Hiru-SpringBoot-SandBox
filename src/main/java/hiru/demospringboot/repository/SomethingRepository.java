package hiru.demospringboot.repository;

import hiru.demospringboot.entity.SomethingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SomethingRepository extends JpaRepository<SomethingEntity, Long> {

    @Query("SELECT s FROM SomethingEntity s WHERE s.name = 'My first thing 2'")
    List<SomethingEntity> findMyFirstThing2();


}
