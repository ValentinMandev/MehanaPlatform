package org.mehana.user.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UuidGenerator;
import org.mehana.common.model.entity.BaseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.hibernate.type.SqlTypes.VARCHAR;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {

    @UuidGenerator
    @JdbcTypeCode(VARCHAR)
    private UUID uuid;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

}
