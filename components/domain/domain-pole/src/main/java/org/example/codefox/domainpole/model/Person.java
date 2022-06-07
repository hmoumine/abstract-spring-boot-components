package org.example.codefox.domainpole.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * The class Person.
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
public class Person extends Base {

    private String firstName;

    private String lastName;

    private String email;

    private String address;
}
