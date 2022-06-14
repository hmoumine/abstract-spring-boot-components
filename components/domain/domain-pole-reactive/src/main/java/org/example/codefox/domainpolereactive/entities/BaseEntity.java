package org.example.codefox.domainpolereactive.entities;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

/**
 * base entity
 */
@MappedSuperclass
@NoArgsConstructor
@Getter
@SuperBuilder
public class BaseEntity {

    @Id
    protected UUID id;

}
