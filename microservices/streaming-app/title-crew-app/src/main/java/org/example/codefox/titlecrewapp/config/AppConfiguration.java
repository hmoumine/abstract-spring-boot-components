package org.example.codefox.titlecrewapp.config;

import org.example.codefox.adapterpersistencereactivedataflux.adapter.AdapterPersistenceDataReactive;
import org.example.codefox.crudreactiveserviceadapter.adapter.ReactorServiceAdapter;
import org.example.codefox.crudreactiveserviceadapter.processing.DefaultServiceReactorProcessor;
import org.example.codefox.domaintitlecrew.mapper.TitleCrewMapper;
import org.example.codefox.domaintitlecrew.model.TitleCrew;
import org.example.codefox.domaintitlecrew.repositories.TitleCrewRepository;
import org.example.codefox.spipersistenceport.spi.IDefaultPersistPort;
import org.example.codefox.spiserviceadapter.functional.IBiArgConsumerFunctionalInterface;
import org.example.codefox.spiserviceadapter.functional.IBiArgFunctionalInterface;
import org.example.codefox.spiserviceadapter.functional.ISingleArgFunctionalInterface;
import org.example.codefox.spiserviceadapter.processing.IServiceCrudProcessor;
import org.example.codefox.spiserviceadapter.spi.IDefaultCrudServicePort;
import org.example.codefox.springappabstractcrudstarter.config.AApplicationConfiguration;
import org.example.codefox.springappmessagepropertystarter.messages.PropertyExceptionMessageConfiguration;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;
import java.util.stream.Stream;

/**
 * Class {@code AppConfiguration} provides [...]
 *
 * @author Hamza MOUMINE
 * @see <a href="h.moumine@outlook.com">h.moumine@outlook.com</a>
 * @see <a href="https://www.linkedin.com/in/hamza-moumine">LinkedIn Profile</a>
 * @see <a href="https://consort-group.com/">Employed by Consort NT Group</a>
 */
@Configuration
@EnableReactiveMongoRepositories("org.example.codefox.domaintitlecrew.repositories")
@EntityScan("org.example.codefox.domaintitlecrew.model")
@ComponentScan({
        "org.example.codefox.domaintitlecrew.mapper",
        "org.example.codefox.domaincommons.mapper"})
public class AppConfiguration
        implements AApplicationConfiguration<
        TitleCrew,
        UUID,
        TitleCrew,
        Flux<TitleCrew>,
        Mono<TitleCrew>,
        TitleCrewMapper,
        TitleCrewRepository> {
    /**
     * @param e titleCrew object
     * @return Mono<TitleCrew>
     */
    @Override
    public Mono<TitleCrew> wrap(final TitleCrew e) {
        return Mono.just(e);
    }

    /**
     * @param e      TitleCrew object source data
     * @param f      Mono of TitleCrew destination data entity
     * @param action Action to apply to e,f
     */
    @Override
    public void executeIfPresent(final TitleCrew e, final Mono<TitleCrew> f, final IBiArgConsumerFunctionalInterface<TitleCrew, TitleCrew> action) {
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
     * @param repository                            TitleCrewRepository bean
     * @param propertyExceptionMessageConfiguration propertyExceptionMessageConfiguration bean
     * @return IDefaultPersistPort<TitleCrew, UUID, Flux < TitleCrew>, Mono<TitleCrew>>
     */
    @Override
    @Bean
    public IDefaultPersistPort<TitleCrew, UUID, Flux<TitleCrew>, Mono<TitleCrew>> defaultPersistPort(final TitleCrewRepository repository, final PropertyExceptionMessageConfiguration propertyExceptionMessageConfiguration) {
        return new AdapterPersistenceDataReactive<>(repository, propertyExceptionMessageConfiguration);
    }

    /**
     * @param defaultPersistPort                    defaultPersistPort bean
     * @param propertyExceptionMessageConfiguration propertyExceptionMessageConfiguration bean
     * @return IServiceCrudProcessor<TitleCrew, UUID, TitleCrew, Flux < TitleCrew>, Mono<TitleCrew>>
     */
    @Override
    @Bean
    public IServiceCrudProcessor<TitleCrew, UUID, TitleCrew, Flux<TitleCrew>, Mono<TitleCrew>> crudRestServiceCrudProcessorPoleEntity(final IDefaultPersistPort<TitleCrew, UUID, Flux<TitleCrew>, Mono<TitleCrew>> defaultPersistPort, final PropertyExceptionMessageConfiguration propertyExceptionMessageConfiguration) {
        return new DefaultServiceReactorProcessor<>(defaultPersistPort, propertyExceptionMessageConfiguration);
    }

    /**
     * @param defaultServiceRestProcessor defaultServiceRestProcessor bean
     * @param dtoToOptionalEntityFunc     dtoToOptionalEntityFunc bean
     * @param dtoToStreamEntityFunc       dtoToStreamEntityFunc bean
     * @param entityToEntityFunc          entityToEntityFunc bean
     * @return IDefaultCrudServicePort<TitleCrew, UUID, TitleCrew, Flux < TitleCrew>, Mono<TitleCrew>>
     */
    @Override
    @Bean
    public IDefaultCrudServicePort<TitleCrew, UUID, TitleCrew, Flux<TitleCrew>, Mono<TitleCrew>> defaultCrudServicePort(final IServiceCrudProcessor<TitleCrew, UUID, TitleCrew, Flux<TitleCrew>, Mono<TitleCrew>> defaultServiceRestProcessor, final ISingleArgFunctionalInterface<TitleCrew, Mono<TitleCrew>> dtoToOptionalEntityFunc, final ISingleArgFunctionalInterface<TitleCrew, Stream<TitleCrew>> dtoToStreamEntityFunc, final IBiArgFunctionalInterface<TitleCrew, Mono<TitleCrew>> entityToEntityFunc) {
        return new ReactorServiceAdapter<>(defaultServiceRestProcessor, dtoToOptionalEntityFunc, dtoToStreamEntityFunc, entityToEntityFunc);
    }

    /**
     * @param mapper TitleCrewMapper bean
     * @return ISingleArgFunctionalInterface<TitleCrew, Mono < TitleCrew>>
     */
    @Override
    @Bean
    @Qualifier("ISingleArgFunctionalInterfaceCSTREAM")
    public ISingleArgFunctionalInterface<TitleCrew, Mono<TitleCrew>> optionalIFunctionalMapper(final TitleCrewMapper mapper) {
        return dto -> wrap(mapper.toEntity(dto));
    }

    /**
     * @param mapper TitleCrewMapper bean
     * @return ISingleArgFunctionalInterface<TitleCrew, Stream < TitleCrew>>
     */
    @Override
    @Bean
    @Qualifier("ISingleArgFunctionalInterfaceCE")
    public ISingleArgFunctionalInterface<TitleCrew, Stream<TitleCrew>> dtoToStreamEntityFunc(final TitleCrewMapper mapper) {
        return dto -> Stream.of(mapper.toEntity(dto));
    }

    /**
     * @param mapper TitleCrewMapper bean
     * @return IBiArgFunctionalInterface<TitleCrew, Mono < TitleCrew>>
     */
    @Override
    @Bean
    public IBiArgFunctionalInterface<TitleCrew, Mono<TitleCrew>> dtoToEntityBiArgFunc(final TitleCrewMapper mapper) {
        return (entitySource, entityDestination) -> {
            executeIfPresent(entitySource, entityDestination, mapper::update);
            return entityDestination;
        };
    }
}