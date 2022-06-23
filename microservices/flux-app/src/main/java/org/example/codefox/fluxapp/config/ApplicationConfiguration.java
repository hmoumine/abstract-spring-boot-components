package org.example.codefox.fluxapp.config;

import org.example.codefox.adapterpersistencereactivedataflux.adapter.AdapterPersistenceDataReactive;
import org.example.codefox.crudreactiveserviceadapter.adapter.ReactorServiceAdapter;
import org.example.codefox.crudreactiveserviceadapter.processing.DefaultServiceReactorProcessor;
import org.example.codefox.domainpolereactive.entities.PoleEntity;
import org.example.codefox.domainpolereactive.mapper.PoleMapper;
import org.example.codefox.domainpolereactive.model.Pole;
import org.example.codefox.domainpolereactive.repositories.PoleRepository;
import org.example.codefox.spipersistenceport.spi.IDefaultPersistPort;
import org.example.codefox.spiserviceadapter.functional.IBiArgConsumerFunctionalInterface;
import org.example.codefox.spiserviceadapter.functional.IBiArgFunctionalInterface;
import org.example.codefox.spiserviceadapter.functional.ISingleArgFunctionalInterface;
import org.example.codefox.spiserviceadapter.processing.IServiceCrudProcessor;
import org.example.codefox.spiserviceadapter.spi.IDefaultCrudServicePort;
import org.example.codefox.springappabstractcrudstarter.config.AApplicationConfiguration;
import org.example.codefox.springappmessagepropertystarter.messages.PropertyExceptionMessageConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;
import java.util.stream.Stream;

/**
 * Class {@code ApplicationConfiguration} provides [...]
 *
 * @author Hamza MOUMINE
 * @see <a href="h.moumine@outlook.com">h.moumine@outlook.com</a>
 * @see <a href="https://www.linkedin.com/in/hamza-moumine">LinkedIn Profile</a>
 * @see <a href="https://consort-group.com/">Employed by Consort NT Group</a>
 */
@Configuration
@EnableR2dbcRepositories("org.example.codefox.domainpolereactive.repositories")
@EntityScan("org.example.codefox.domainpole.entities")
@ComponentScan({
        "org.example.codefox.domainpolereactive.mapper",
        "org.example.codefox.domaincommons.mapper"})
public class ApplicationConfiguration
        implements AApplicationConfiguration<
        PoleEntity,
        UUID,
        Pole,
        Flux<PoleEntity>,
        Mono<PoleEntity>,
        PoleMapper,
        PoleRepository> {
    /**
     * @param e Entity object
     * @return Wrapped Entity with Mono container
     */
    @Override
    public Mono<PoleEntity> wrap(final PoleEntity e) {
        return Mono.just(e);
    }

    /**
     * @param e      Pole dto object
     * @param f      Pole entity in Mono container
     * @param action Action to apply to e,f
     */
    @Override
    public void executeIfPresent(
            final Pole e,
            final Mono<PoleEntity> f,
            final IBiArgConsumerFunctionalInterface<Pole, PoleEntity> action
    ) {
        f.doOnNext(entity -> action.apply(e, entity));
    }

    /**
     * @return PropertyExceptionMessageConfiguration bean
     */
    @Override
    @Bean
    public PropertyExceptionMessageConfiguration propertyExceptionMessageConfiguration() {
        return new PropertyExceptionMessageConfiguration();
    }

    /**
     * @param repository Reactive Pole repository
     * @return IDefaultPersistPort<PoleEntity, UUID, Flux < PoleEntity>, Mono<PoleEntity>> Bean
     */
    @Override
    @Bean
    public IDefaultPersistPort<PoleEntity, UUID, Flux<PoleEntity>, Mono<PoleEntity>> defaultPersistPort(
            final PoleRepository repository, final PropertyExceptionMessageConfiguration propertyExceptionMessageConfiguration
    ) {
        return new AdapterPersistenceDataReactive<>(repository, propertyExceptionMessageConfiguration);
    }

    /**
     * @param defaultPersistPort                    defaultPersistPort bean
     * @param propertyExceptionMessageConfiguration propertyExceptionMessageConfiguration bean
     * @return IServiceCrudProcessor<PoleEntity, UUID, PoleEntity, Flux < PoleEntity>, Mono<PoleEntity>>
     */
    @Override
    @Bean
    public IServiceCrudProcessor<PoleEntity, UUID, Pole, Flux<PoleEntity>, Mono<PoleEntity>> crudRestServiceCrudProcessorPoleEntity(
            final IDefaultPersistPort<PoleEntity, UUID, Flux<PoleEntity>, Mono<PoleEntity>> defaultPersistPort,
            final PropertyExceptionMessageConfiguration propertyExceptionMessageConfiguration
    ) {
        return new DefaultServiceReactorProcessor<>(defaultPersistPort, propertyExceptionMessageConfiguration);
    }

    /**
     * @param defaultServiceRestProcessor defaultServiceRestProcessor bean
     * @param dtoToOptionalEntityFunc     dtoToOptionalEntityFunc bean
     * @param dtoToStreamEntityFunc       dtoToStreamEntityFunc bean
     * @param entityToEntityFunc          entityToEntityFunc bean
     * @return IDefaultCrudServicePort<PoleEntity, UUID, PoleEntity, Flux < PoleEntity>, Mono<PoleEntity>>
     */
    @Override
    @Bean
    public IDefaultCrudServicePort<PoleEntity, UUID, Pole, Flux<PoleEntity>, Mono<PoleEntity>> defaultCrudServicePort(
            final IServiceCrudProcessor<PoleEntity, UUID, Pole, Flux<PoleEntity>, Mono<PoleEntity>> defaultServiceRestProcessor,
            final ISingleArgFunctionalInterface<Pole, Mono<PoleEntity>> dtoToOptionalEntityFunc,
            final ISingleArgFunctionalInterface<Pole, Stream<PoleEntity>> dtoToStreamEntityFunc,
            final IBiArgFunctionalInterface<Pole, Mono<PoleEntity>> entityToEntityFunc
    ) {
        return new ReactorServiceAdapter<>(defaultServiceRestProcessor, dtoToOptionalEntityFunc, dtoToStreamEntityFunc, entityToEntityFunc);
    }

    /**
     * @param mapper PoleMapper bean
     * @return ISingleArgFunctionalInterface<Pole, Mono < PoleEntity>>
     */
    @Override
    @Bean
    public ISingleArgFunctionalInterface<Pole, Mono<PoleEntity>> optionalIFunctionalMapper(final PoleMapper mapper) {
        return dto -> wrap(mapper.toEntity(dto));
    }

    /**
     * @param mapper PoleMapper bean
     * @return ISingleArgFunctionalInterface<Pole, Stream < PoleEntity>>
     */
    @Override
    @Bean
    public ISingleArgFunctionalInterface<Pole, Stream<PoleEntity>> dtoToStreamEntityFunc(final PoleMapper mapper) {
        return dto -> Stream.of(mapper.toEntity(dto));
    }

    /**
     * @param mapper PoleMapper bean
     * @return IBiArgFunctionalInterface<Pole, Mono < PoleEntity>>
     */
    @Override
    @Bean
    public IBiArgFunctionalInterface<Pole, Mono<PoleEntity>> dtoToEntityBiArgFunc(final PoleMapper mapper) {
        return (entitySource, entityDestination) -> {
            executeIfPresent(entitySource, entityDestination, mapper::update);
            return entityDestination;
        };
    }


}
