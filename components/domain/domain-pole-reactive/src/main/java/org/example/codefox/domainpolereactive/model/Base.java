package org.example.codefox.domainpolereactive.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

/**
 * The class Base.
 *
 * @author Hamza MOUMINE
 * @see <a href="h.moumine@outlook.com">h.moumine@outlook.com</a>
 * @see <a href="https://www.linkedin.com/in/hamza-moumine?originalSubdomain=fr">LinkedIn Profile</a>
 */
@Getter
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
public class Base {

    /**
     * The Id.
     */
    protected UUID id;

}
