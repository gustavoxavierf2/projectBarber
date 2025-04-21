package project.barber.barberShop.config.security.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.barber.barberShop.config.security.auth.model.UserEntity;

import java.util.UUID;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{
    UserEntity findByEmail(String email);
}
