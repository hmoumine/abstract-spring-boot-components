package org.example.codefox.restapp.config;

import org.example.codefox.domaincommons.mapper.AbstractMapper;
import org.example.codefox.domainpole.entities.PoleEntity;
import org.example.codefox.domainpole.model.Pole;
import org.example.codefox.spiserviceadapter.functional.IBiArgConsumerFunctionalInterface;
import org.example.codefox.springappabstractcrudstarter.config.AApplicationConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

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
@EnableJpaRepositories("org.example.codefox.domainpole.repositories")
@EntityScan("org.example.codefox.domainpole.entities")
@ComponentScan({
        "org.example.codefox.domainpole.mapper",
        "org.example.codefox.domaincommons.mapper"})
public class ApplicationConfiguration extends AApplicationConfiguration<PoleEntity, UUID, Pole, Iterable<PoleEntity>, Optional<PoleEntity>> {
    /**
     * Wraps an entity into an optional
     *
     * @param poleEntity Entity to wrap
     * @return Wrapped entity into Optional container
     */
    @Override
    public Optional<PoleEntity> wrap(final PoleEntity poleEntity) {
        return Optional.of(poleEntity);
    }

    /**
     * Executes callback function if provided optional is not empty
     *
     * @param poleEntity Pole entity to provide to callback function
     * @param f          Optional entity that must me present in the container
     * @param mapper     Entity mapper to map values from first entity into the second
     * @param action     Callback function
     */
    @Override
    public void executeIfPresent(
            final PoleEntity poleEntity,
            final Optional<PoleEntity> f,
            final AbstractMapper<PoleEntity, PoleEntity> mapper,
            final IBiArgConsumerFunctionalInterface<PoleEntity, PoleEntity> action
    ) {
        f.ifPresent(entity -> action.apply(entity, poleEntity));
    }


}
