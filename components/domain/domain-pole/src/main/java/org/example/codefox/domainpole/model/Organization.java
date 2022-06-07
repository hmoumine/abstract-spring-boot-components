package org.example.codefox.domainpole.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Collection;
import java.util.HashSet;

/**
 * The class Organization.
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
public class Organization extends Base {

    private String name;

    private Collection<Group> groups = new HashSet<>();

    private Service service;

}
