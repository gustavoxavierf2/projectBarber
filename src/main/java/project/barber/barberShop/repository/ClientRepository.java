package project.barber.barberShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.barber.barberShop.domain.model.ClientEntity;

import java.util.UUID;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {
}
