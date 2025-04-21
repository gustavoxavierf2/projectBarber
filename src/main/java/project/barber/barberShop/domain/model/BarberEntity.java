package project.barber.barberShop.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import project.barber.barberShop.config.security.auth.model.UserEntity;

import java.time.LocalDateTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "barbearias")
public class BarberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id")
    private UserEntity userId;

    @Column(name = "nome_fantasia")
    private String fantasyName;

    @Column(name = "endereco")
    private String address;

    @Column(name = "complemento")
    private String complement;

    @Column(name = "cidade")
    private String city;

    @Column(name = "estado")
    private String state;

    @Column(name = "cep")
    private String postalCode;

    @Column(name = "latitude")
    private String latitude;

    @Column(name = "longitude")
    private String longitude;

    @Column(name = "telefone")
    private String phone;

    @Column(name = "celular")
    private String mobile;

    @Column(name = "foto_capa")
    private String coverPhoto;

    @Column(name = "instagram")
    private String instagram;

    @Column(name = "descricao")
    private String description;

    @Column(name = "horario_funcionamento")
    private String openingHours;

    @CreationTimestamp
    @Column(name = "criado_em", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "atualizado_em")
    private LocalDateTime updatedAt;
    
}
