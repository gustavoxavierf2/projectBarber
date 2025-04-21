package project.barber.barberShop.config.security.auth.model;

import lombok.Getter;

@Getter
public enum UserTypeEnum {
    ADMIN("ROLE_ADMIN"),
    CLIENTE("ROLE_CLIENTE"),
    BARBEARIA("ROLE_BARBEARIA");

    private final String type;

    UserTypeEnum(String type){
        this.type = type;
    }
}
