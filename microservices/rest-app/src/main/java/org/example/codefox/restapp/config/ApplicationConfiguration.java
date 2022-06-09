package org.example.codefox.restapp.config;

import org.example.codefox.domainpole.entities.PoleEntity;
import org.example.codefox.domainpole.model.Pole;
import org.example.codefox.springappabstractcrudstarter.config.AApplicationConfiguration;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;
import java.util.UUID;

/**
 * Class {@code AApplicationConfiguration} provides [...]
 *
 * @author Hamza MOUMINE
 * @see <a href="h.moumine@outlook.com">h.moumine@outlook.com</a>
 * @see <a href="https://www.linkedin.com/in/hamza-moumine">LinkedIn Profile</a>
 * @see <a href="https://consort-group.com/">Employed by Consort NT Group</a>
 */
@Configuration
public class ApplicationConfiguration extends AApplicationConfiguration<PoleEntity, UUID, Pole, Iterable<PoleEntity>, Optional<PoleEntity>> {
}
