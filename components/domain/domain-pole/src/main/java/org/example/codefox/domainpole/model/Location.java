package org.example.codefox.domainpole.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * The class Location.
 *
 * @author Hamza MOUMINE
 * @see <a href="h.moumine@outlook.com">h.moumine@outlook.com</a>
 * @see <a href="https://www.linkedin.com/in/hamza-moumine?originalSubdomain=fr">LinkedIn Profile</a>
 */
@Getter
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Location extends Base {

    private String address;

    private City city;

    private ZipCode zipCode;

    private Country country;

    private Department department;
}
