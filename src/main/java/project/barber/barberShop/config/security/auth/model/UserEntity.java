package project.barber.barberShop.config.security.auth.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import project.barber.barberShop.domain.model.BarberEntity;

@Builder
@Entity
@Table(name = "USUARIOS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String name;

    @Column(name = "email")
    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column( name = "senha")
    private String userPassword;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo")
    private UserTypeEnum typeEnum;

    @Column(name = "ativo")
    private Boolean active;

    @CreationTimestamp
    @Column(name = "criado_em", updatable = false)
    private LocalDateTime creationTimestamp;

    @UpdateTimestamp
    @Column(name = "atualizado_em")
    private LocalDateTime updateTimestamp;

    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("userId")
    private List<BarberEntity> barber = new ArrayList<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (typeEnum == UserTypeEnum.ADMIN) {
           return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_CLIENTE"),
                   new SimpleGrantedAuthority("ROLE_BARBEARIA"));
        } else if (typeEnum == UserTypeEnum.BARBEARIA){
            return List.of(new SimpleGrantedAuthority("ROLE_BARBEARIA"));
        } else {
            return List.of(new SimpleGrantedAuthority("ROLE_CLIENTE"));
        }
    }
    @Override
    public String getPassword() {
        return getUserPassword();
    }
    @Override
    public String getUsername() {
        return getEmail();
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() { return true; }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() { return true; }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() { return true; }

    @JsonIgnore
    @Override
    public boolean isEnabled() { return active != null && active; }

}
