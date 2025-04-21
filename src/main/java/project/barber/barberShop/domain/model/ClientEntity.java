package project.barber.barberShop.domain.model;

import jakarta.persistence.*;
import lombok.*;
import project.barber.barberShop.config.security.auth.model.UserEntity;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "CLIENTES")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "usuario_id")
    private Long userId;

    @Column(name = "telefone")
    private String phone;

    @Column(name = "latitude")
    private String latitude;

    @Column(name = "longitude")
    private String longitude;

    @Column(name = "data_nascimento")
    private LocalDate birthDate;

    @Column(name = "observacao")
    private String notes;
}
