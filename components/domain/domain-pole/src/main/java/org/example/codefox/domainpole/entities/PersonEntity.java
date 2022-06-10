package org.example.codefox.domainpole.entities;

import jakarta.persistence.Entity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity(name = "person")
@Getter
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PersonEntity extends BaseEntity {

    private String firstName;

    private String lastName;

    private String address;

    private String email;

}
