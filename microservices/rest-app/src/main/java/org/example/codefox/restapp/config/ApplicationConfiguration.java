package org.example.codefox.restapp.config;

import org.example.codefox.adapterpersistencedatajpa.adapter.AdapterPersistenceDataJpa;
import org.example.codefox.adapterpersistencedatajpa.spi.IJpaPersistPort;
import org.example.codefox.crudrestserviceadapter.adapter.CrudRestServiceAdapter;
import org.example.codefox.crudrestserviceadapter.processing.DefaultServiceRestProcessor;
import org.example.codefox.crudrestserviceadapter.spi.IRestServiceCrudProcessor;
import org.example.codefox.domainpole.entities.PoleEntity;
import org.example.codefox.domainpole.mapper.PoleMapper;
import org.example.codefox.domainpole.model.Pole;
import org.example.codefox.domainpole.repositories.PoleRepository;
import org.example.codefox.jprofilestarters.springappmessagepropertystarter.messages.PropertyExceptionMessageConfiguration;
import org.example.codefox.spiserviceadapter.functional.IBiArgConsumerFunctionalInterface;
import org.example.codefox.spiserviceadapter.functional.IBiArgFunctionalInterface;
import org.example.codefox.spiserviceadapter.functional.ISingleArgFunctionalInterface;
import org.example.codefox.spiserviceadapter.spi.IDefaultCrudServicePort;
import org.example.codefox.springappabstractcrudstarter.config.AApplicationConfiguration;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;


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
public class ApplicationConfiguration
        implements AApplicationConfiguration<
        PoleEntity,
        UUID,
        Pole,
        Iterable<PoleEntity>,
        Optional<PoleEntity>,
        PoleMapper,
        PoleRepository> {

    /**
     * Wraps an entity into an optional
     *
     * @param poleEntity Entity to wrap
     * @return Wrapped entity into Optional container
     */
    public Optional<PoleEntity> wrap(final PoleEntity poleEntity) {
        return Optional.of(poleEntity);
    }

    /**
     * Executes callback function if provided optional is not empty
     *
     * @param pole   Pole entity to provide to callback function
     * @param f      Optional entity that must me present in the container
     * @param action Callback function
     */
    public void executeIfPresent(
            final Pole pole,
            final Optional<PoleEntity> f,
            final IBiArgConsumerFunctionalInterface<Pole, PoleEntity> action
    ) {
        f.ifPresent(entity -> action.apply(pole, entity));
    }

    @Bean
    public PropertyExceptionMessageConfiguration propertyExceptionMessageConfiguration() {
        return new PropertyExceptionMessageConfiguration();
    }

    @Bean
    public IJpaPersistPort<PoleEntity, UUID, Iterable<PoleEntity>, Optional<PoleEntity>> jpaPersistPort(
            final PoleRepository pol
    ) {
        return new AdapterPersistenceDataJpa<>(pol);
    }

    @Bean
    public IRestServiceCrudProcessor<PoleEntity, UUID, Pole>
    crudRestServiceCrudProcessorPoleEntity(
            final IJpaPersistPort<PoleEntity, UUID, Iterable<PoleEntity>, Optional<PoleEntity>> defaultPersistPort,
            final PropertyExceptionMessageConfiguration propertyExceptionMessageConfiguration
    ) {
        return new DefaultServiceRestProcessor<>(defaultPersistPort, propertyExceptionMessageConfiguration);
    }

    @Bean
    public IDefaultCrudServicePort<PoleEntity, UUID, Pole, Iterable<PoleEntity>, PoleEntity>
    defaultCrudServicePort(
            final IRestServiceCrudProcessor<PoleEntity, UUID, Pole> defaultServiceRestProcessor,
            @Qualifier("ISingleArgFunctionalInterfaceCE") final ISingleArgFunctionalInterface<Pole, Optional<PoleEntity>> dtoToOptionalEntityFunc,
            @Qualifier("ISingleArgFunctionalInterfaceCSTREAM") final ISingleArgFunctionalInterface<Pole, Stream<PoleEntity>> dtoToStreamEntityFunc,
            final IBiArgFunctionalInterface<Pole, Optional<PoleEntity>> entityToEntityFunc
    ) {
        return new <PoleEntity, UUID, Pole, Iterable<PoleEntity>, Optional<PoleEntity>>CrudRestServiceAdapter(defaultServiceRestProcessor, dtoToOptionalEntityFunc, dtoToStreamEntityFunc, entityToEntityFunc);
    }

    @Bean
    @Qualifier("ISingleArgFunctionalInterfaceCE")
    public ISingleArgFunctionalInterface<Pole, Optional<PoleEntity>> poleOptionalIFunctionalMapper(final PoleMapper mapper) {
        return dto -> wrap(mapper.toEntity(dto));
    }

    @Bean
    @Qualifier("ISingleArgFunctionalInterfaceCSTREAM")
    public ISingleArgFunctionalInterface<Pole, Stream<PoleEntity>> dtoToStreamEntityFunc(final PoleMapper mapper) {
        return dto -> Stream.of(mapper.toEntity(dto));
    }

    @Bean
    public IBiArgFunctionalInterface<Pole, Optional<PoleEntity>> entityToEntityFunc(final PoleMapper mapper) {
        return (entitySource, entityDestination) -> {
            executeIfPresent(entitySource, entityDestination, mapper::update);
            return entityDestination;
        };
    }


}
