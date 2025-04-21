package project.barber.barberShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.barber.barberShop.domain.model.BarberEntity;

@Repository
public interface BarberRepository extends JpaRepository<BarberEntity, Long> {
}
