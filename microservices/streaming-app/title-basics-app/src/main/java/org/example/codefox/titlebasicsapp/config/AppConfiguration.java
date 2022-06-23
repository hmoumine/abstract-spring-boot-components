package org.example.codefox.titlebasicsapp.config;

import org.example.codefox.adapterpersistencereactivedataflux.adapter.AdapterPersistenceDataReactive;
import org.example.codefox.crudreactiveserviceadapter.adapter.ReactorServiceAdapter;
import org.example.codefox.crudreactiveserviceadapter.processing.DefaultServiceReactorProcessor;
import org.example.codefox.domaintitlebasics.mapper.TitleBasicsMapper;
import org.example.codefox.domaintitlebasics.model.TitleBasics;
import org.example.codefox.domaintitlebasics.repositories.TitleBasicsRepository;
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
@EnableReactiveMongoRepositories("org.example.codefox.domaintitlebasics.repositories")
@EntityScan("org.example.codefox.domaintitlebasics.model")
@ComponentScan({
        "org.example.codefox.domaintitlebasics.mapper",
        "org.example.codefox.domaincommons.mapper"})
public class AppConfiguration
        implements AApplicationConfiguration<
        TitleBasics,
        UUID,
        TitleBasics,
        Flux<TitleBasics>,
        Mono<TitleBasics>,
        TitleBasicsMapper,
        TitleBasicsRepository> {
    /**
     * @param e object to wrap
     * @return Mono<TitleBasics>
     */
    @Override
    public Mono<TitleBasics> wrap(final TitleBasics e) {
        return Mono.just(e);
    }

    /**
     * @param e      Pole dto object
     * @param f      Pole entity in Mono container
     * @param action Action to apply to e,f
     */
    @Override
    public void executeIfPresent(final TitleBasics e, final Mono<TitleBasics> f, final IBiArgConsumerFunctionalInterface<TitleBasics, TitleBasics> action) {
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
     * @param repository                            TitleBasicsRepository bean
     * @param propertyExceptionMessageConfiguration propertyExceptionMessageConfiguration bean
     * @return IDefaultPersistPort<NameBasics, UUID, Flux < NameBasics>, Mono<NameBasics>>
     */
    @Override
    @Bean
    public IDefaultPersistPort<TitleBasics, UUID, Flux<TitleBasics>, Mono<TitleBasics>> defaultPersistPort(final TitleBasicsRepository repository, final PropertyExceptionMessageConfiguration propertyExceptionMessageConfiguration) {
        return new AdapterPersistenceDataReactive<>(repository, propertyExceptionMessageConfiguration);
    }

    /**
     * @param defaultPersistPort                    defaultPersistPort bean
     * @param propertyExceptionMessageConfiguration propertyExceptionMessageConfiguration bean
     * @return IServiceCrudProcessor<TitleBasics, UUID, TitleBasics, Flux < TitleBasics>, Mono<TitleBasics>>
     */
    @Override
    @Bean
    public IServiceCrudProcessor<TitleBasics, UUID, TitleBasics, Flux<TitleBasics>, Mono<TitleBasics>> crudRestServiceCrudProcessorPoleEntity(final IDefaultPersistPort<TitleBasics, UUID, Flux<TitleBasics>, Mono<TitleBasics>> defaultPersistPort, final PropertyExceptionMessageConfiguration propertyExceptionMessageConfiguration) {
        return new DefaultServiceReactorProcessor<>(defaultPersistPort, propertyExceptionMessageConfiguration);
    }

    /**
     * @param defaultServiceRestProcessor defaultServiceRestProcessor bean
     * @param dtoToOptionalEntityFunc     dtoToOptionalEntityFunc bean
     * @param dtoToStreamEntityFunc       dtoToStreamEntityFunc bean
     * @param entityToEntityFunc          entityToEntityFunc bean
     * @return IDefaultCrudServicePort<TitleBasics, UUID, TitleBasics, Flux < TitleBasics>, Mono<TitleBasics>>
     */
    @Override
    @Bean
    public IDefaultCrudServicePort<TitleBasics, UUID, TitleBasics, Flux<TitleBasics>, Mono<TitleBasics>> defaultCrudServicePort(final IServiceCrudProcessor<TitleBasics, UUID, TitleBasics, Flux<TitleBasics>, Mono<TitleBasics>> defaultServiceRestProcessor, final ISingleArgFunctionalInterface<TitleBasics, Mono<TitleBasics>> dtoToOptionalEntityFunc, final ISingleArgFunctionalInterface<TitleBasics, Stream<TitleBasics>> dtoToStreamEntityFunc, final IBiArgFunctionalInterface<TitleBasics, Mono<TitleBasics>> entityToEntityFunc) {
        return new ReactorServiceAdapter<>(defaultServiceRestProcessor, dtoToOptionalEntityFunc, dtoToStreamEntityFunc, entityToEntityFunc);
    }

    /**
     * @param mapper TitleBasicsMapper bean
     * @return ISingleArgFunctionalInterface<TitleBasics, Mono < TitleBasics>>
     */
    @Override
    @Bean
    @Qualifier("ISingleArgFunctionalInterfaceCSTREAM")
    public ISingleArgFunctionalInterface<TitleBasics, Mono<TitleBasics>> optionalIFunctionalMapper(final TitleBasicsMapper mapper) {
        return dto -> wrap(mapper.toEntity(dto));
    }

    /**
     * @param mapper TitleBasicsMapper bean
     * @return ISingleArgFunctionalInterface<TitleBasics, Stream < TitleBasics>>
     */
    @Override
    @Bean
    @Qualifier("ISingleArgFunctionalInterfaceCE")
    public ISingleArgFunctionalInterface<TitleBasics, Stream<TitleBasics>> dtoToStreamEntityFunc(final TitleBasicsMapper mapper) {
        return dto -> Stream.of(mapper.toEntity(dto));
    }

    /**
     * @param mapper TitleBasicsMapper bean
     * @return IBiArgFunctionalInterface<TitleBasics, Mono < TitleBasics>>
     */
    @Override
    @Bean
    public IBiArgFunctionalInterface<TitleBasics, Mono<TitleBasics>> dtoToEntityBiArgFunc(final TitleBasicsMapper mapper) {
        return (entitySource, entityDestination) -> {

            executeIfPresent(entitySource, entityDestination, mapper::update);
            return entityDestination;
        };
    }
}