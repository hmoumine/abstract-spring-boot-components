package org.example.codefox.titleakasapp.config;

import org.example.codefox.adapterpersistencereactivedataflux.adapter.AdapterPersistenceDataReactive;
import org.example.codefox.crudreactiveserviceadapter.adapter.ReactorServiceAdapter;
import org.example.codefox.crudreactiveserviceadapter.processing.DefaultServiceReactorProcessor;
import org.example.codefox.domaintitleakas.mapper.AlsoKnownAsMapper;
import org.example.codefox.domaintitleakas.model.AlsoKnownAs;
import org.example.codefox.domaintitleakas.repositories.AlsoKnownAsRepository;
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
@EnableReactiveMongoRepositories("org.example.codefox.domaintitleakas.repositories")
@EntityScan("org.example.codefox.domaintitleakas.model")
@ComponentScan({
        "org.example.codefox.domaintitleakas.mapper",
        "org.example.codefox.domaincommons.mapper"})
public class AppConfiguration
        implements AApplicationConfiguration<
        AlsoKnownAs,
        UUID,
        AlsoKnownAs,
        Flux<AlsoKnownAs>,
        Mono<AlsoKnownAs>,
        AlsoKnownAsMapper,
        AlsoKnownAsRepository> {
    /**
     * @param e object to wrap
     * @return Mono<AlsoKnownAs>
     */
    @Override
    public Mono<AlsoKnownAs> wrap(final AlsoKnownAs e) {
        return Mono.just(e);
    }

    /**
     * @param e      source data object
     * @param f      destination data object
     * @param action Action to perform on e,f
     */
    @Override
    public void executeIfPresent(final AlsoKnownAs e, final Mono<AlsoKnownAs> f, final IBiArgConsumerFunctionalInterface<AlsoKnownAs, AlsoKnownAs> action) {
        f.doOnNext(entity -> action.apply(e, entity));
    }

    /**
     * @return PropertyExceptionMessageConfiguration
     */
    @Override
    @Bean
    public PropertyExceptionMessageConfiguration propertyExceptionMessageConfiguration() {
        return new PropertyExceptionMessageConfiguration();
    }

    /**
     * @param repository                            NameBasicsRepository bean
     * @param propertyExceptionMessageConfiguration propertyExceptionMessageConfiguration bean
     * @return IDefaultPersistPort<NameBasics, UUID, Flux < NameBasics>, Mono<NameBasics>>
     */
    @Override
    @Bean
    public IDefaultPersistPort<AlsoKnownAs, UUID, Flux<AlsoKnownAs>, Mono<AlsoKnownAs>> defaultPersistPort(final AlsoKnownAsRepository repository, final PropertyExceptionMessageConfiguration propertyExceptionMessageConfiguration) {
        return new AdapterPersistenceDataReactive<>(repository, propertyExceptionMessageConfiguration);
    }

    /**
     * @param defaultPersistPort                    defaultPersistPort bean
     * @param propertyExceptionMessageConfiguration propertyExceptionMessageConfiguration bean
     * @return IServiceCrudProcessor<NameBasics, UUID, NameBasics, Flux < NameBasics>, Mono<NameBasics>>
     */
    @Override
    @Bean
    public IServiceCrudProcessor<AlsoKnownAs, UUID, AlsoKnownAs, Flux<AlsoKnownAs>, Mono<AlsoKnownAs>> crudRestServiceCrudProcessorPoleEntity(final IDefaultPersistPort<AlsoKnownAs, UUID, Flux<AlsoKnownAs>, Mono<AlsoKnownAs>> defaultPersistPort, final PropertyExceptionMessageConfiguration propertyExceptionMessageConfiguration) {
        return new DefaultServiceReactorProcessor<>(defaultPersistPort, propertyExceptionMessageConfiguration);
    }

    /**
     * @param defaultServiceRestProcessor defaultServiceRestProcessor bean
     * @param dtoToOptionalEntityFunc     dtoToOptionalEntityFunc bean
     * @param dtoToStreamEntityFunc       dtoToStreamEntityFunc bean
     * @param entityToEntityFunc          entityToEntityFunc bean
     * @return IDefaultCrudServicePort<NameBasics, UUID, NameBasics, Flux < NameBasics>, Mono<NameBasics>>
     */
    @Override
    @Bean
    public IDefaultCrudServicePort<AlsoKnownAs, UUID, AlsoKnownAs, Flux<AlsoKnownAs>, Mono<AlsoKnownAs>> defaultCrudServicePort(final IServiceCrudProcessor<AlsoKnownAs, UUID, AlsoKnownAs, Flux<AlsoKnownAs>, Mono<AlsoKnownAs>> defaultServiceRestProcessor, final ISingleArgFunctionalInterface<AlsoKnownAs, Mono<AlsoKnownAs>> dtoToOptionalEntityFunc, final ISingleArgFunctionalInterface<AlsoKnownAs, Stream<AlsoKnownAs>> dtoToStreamEntityFunc, final IBiArgFunctionalInterface<AlsoKnownAs, Mono<AlsoKnownAs>> entityToEntityFunc) {
        return new ReactorServiceAdapter<>(defaultServiceRestProcessor, dtoToOptionalEntityFunc, dtoToStreamEntityFunc, entityToEntityFunc);
    }

    /**
     * @param mapper AlsoKnownAsMapper bean
     * @return ISingleArgFunctionalInterface<AlsoKnownAs, Mono < AlsoKnownAs>>
     */
    @Override
    @Bean
    @Qualifier("ISingleArgFunctionalInterfaceCSTREAM")
    public ISingleArgFunctionalInterface<AlsoKnownAs, Mono<AlsoKnownAs>> optionalIFunctionalMapper(final AlsoKnownAsMapper mapper) {
        return dto -> wrap(mapper.toEntity(dto));
    }

    /**
     * @param mapper AlsoKnownAsMapper bean
     * @return ISingleArgFunctionalInterface<AlsoKnownAs, Stream < AlsoKnownAs>>
     */
    @Override
    @Bean
    @Qualifier("ISingleArgFunctionalInterfaceCE")
    public ISingleArgFunctionalInterface<AlsoKnownAs, Stream<AlsoKnownAs>> dtoToStreamEntityFunc(final AlsoKnownAsMapper mapper) {
        return dto -> Stream.of(mapper.toEntity(dto));
    }

    /**
     * @param mapper AlsoKnownAsMapper bean
     * @return IBiArgFunctionalInterface<AlsoKnownAs, Mono < AlsoKnownAs>>
     */
    @Override
    @Bean
    public IBiArgFunctionalInterface<AlsoKnownAs, Mono<AlsoKnownAs>> dtoToEntityBiArgFunc(final AlsoKnownAsMapper mapper) {
        return (entitySource, entityDestination) -> {

            executeIfPresent(entitySource, entityDestination, mapper::update);
            return entityDestination;
        };
    }
}