package org.example.jprofiler.domain.pole.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Collection;
import java.util.HashSet;

/**
 * The class Pole.
 *
 * @author Hamza MOUMINE
 * @see <a href="h.moumine@outlook.com">h.moumine@outlook.com</a>
 * @see <a href="https://www.linkedin.com/in/hamza-moumine?originalSubdomain=fr">LinkedIn Profile</a>
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Pole extends Base {

    private String name;

    private Location location;

    private Collection<Organization> organizations = new HashSet<>();

}
