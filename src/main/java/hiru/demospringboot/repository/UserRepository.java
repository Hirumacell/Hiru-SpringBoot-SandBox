package hiru.demospringboot.repository;

import hiru.demospringboot.dto.UserDto;
import hiru.demospringboot.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

     @Query("SELECT u FROM UserEntity u WHERE u.username = ?1 AND u.password = ?2")
    Optional<UserEntity> findByUsernameAndPassword(String username, String password);

     //findByUsername
    @Query("SELECT u FROM UserEntity u WHERE u.username = ?1")
    Optional<UserEntity> findByUsername(String username);

    //findByPassword
    @Query("SELECT u FROM UserEntity u WHERE u.password = ?1")
    Optional<UserEntity> findByPassword(String password);

    @Query("SELECT u.id FROM UserEntity u WHERE u.username = ?1")
    Optional<Long> findId(String username);

    @Query("SELECT u.username FROM UserEntity u WHERE u.id = ?1")
    Optional<String> findUsername(Long id);
}
