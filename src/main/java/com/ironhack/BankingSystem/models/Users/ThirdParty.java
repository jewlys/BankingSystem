package com.ironhack.BankingSystem.models.Users;
import com.ironhack.BankingSystem.models.Role;
import com.ironhack.BankingSystem.models.User;
import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class ThirdParty extends User {
    /* - name: String;
- hashedKey: Integer; */
    private String name;
    private Integer hashedKey;

    public ThirdParty(String username, String password, Collection<Role> roles) {
        super(username, password, roles);
    }

    public ThirdParty() {
    }

    public ThirdParty(String username, String password, Collection<Role> roles, String name, Integer hashedKey) {
        super(username, password, roles);
        this.name = name;
        this.hashedKey = hashedKey;
    }

    public ThirdParty(String name, Integer hashedKey) {
        this.name = name;
        this.hashedKey = hashedKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHashedKey() {
        return hashedKey;
    }

    public void setHashedKey(Integer hashedKey) {
        this.hashedKey = hashedKey;
    }
}
