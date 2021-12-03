package com.example.project.model.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "roles")
public class UserRoleEntity extends BaseEntity{



    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRoleEnum role;

    public UserRoleEnum getRole() {
        return role;
    }

    public UserRoleEntity setRole(UserRoleEnum role) {
        this.role = role;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRoleEntity that = (UserRoleEntity) o;
        return role.toString().equals(that.role.toString());
    }

    @Override
    public int hashCode() {
        return Objects.hash(role);
    }
}
