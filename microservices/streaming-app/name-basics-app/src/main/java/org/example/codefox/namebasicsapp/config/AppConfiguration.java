package org.example.codefox.namebasicsapp.config;

import org.example.codefox.adapterpersistencereactivedataflux.adapter.AdapterPersistenceDataReactive;
import org.example.codefox.crudreactiveserviceadapter.adapter.ReactorServiceAdapter;
import org.example.codefox.crudreactiveserviceadapter.processing.DefaultServiceReactorProcessor;
import org.example.codefox.domainnamebasics.mapper.NameBasicsMapper;
import org.example.codefox.domainnamebasics.model.NameBasics;
import org.example.codefox.domainnamebasics.repositories.NameBasicsRepository;
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
@EnableReactiveMongoRepositories("org.example.codefox.domainnamebasics.repositories")
@EntityScan("org.example.codefox.domainnamebasics.model")
@ComponentScan({
        "org.example.codefox.domainnamebasics.mapper",
        "org.example.codefox.domaincommons.mapper"})
public class AppConfiguration
        implements AApplicationConfiguration<
        NameBasics,
        String,
        NameBasics,
        Flux<NameBasics>,
        Mono<NameBasics>,
        NameBasicsMapper,
        NameBasicsRepository> {
    /**
     * @param e NameBasics object to wrap
     * @return Mono<NameBasics>
     */
    @Override
    public Mono<NameBasics> wrap(final NameBasics e) {
        return Mono.just(e);
    }

    /**
     * @param e      source data object
     * @param f      destination data object
     * @param action Action to perform on e,f
     */
    @Override
    public void executeIfPresent(final NameBasics e, final Mono<NameBasics> f, final IBiArgConsumerFunctionalInterface<NameBasics, NameBasics> action) {
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
     * @return IDefaultPersistPort<NameBasics, String, Flux < NameBasics>, Mono<NameBasics>>
     */
    @Override
    @Bean
    public IDefaultPersistPort<NameBasics, String, Flux<NameBasics>, Mono<NameBasics>> defaultPersistPort(final NameBasicsRepository repository, final PropertyExceptionMessageConfiguration propertyExceptionMessageConfiguration) {
        return new AdapterPersistenceDataReactive<>(repository, propertyExceptionMessageConfiguration);
    }

    /**
     * @param defaultPersistPort                    defaultPersistPort bean
     * @param propertyExceptionMessageConfiguration propertyExceptionMessageConfiguration bean
     * @return IServiceCrudProcessor<NameBasics, String, NameBasics, Flux < NameBasics>, Mono<NameBasics>>
     */
    @Override
    @Bean
    public IServiceCrudProcessor<NameBasics, String, NameBasics, Flux<NameBasics>, Mono<NameBasics>> crudRestServiceCrudProcessorPoleEntity(final IDefaultPersistPort<NameBasics, String, Flux<NameBasics>, Mono<NameBasics>> defaultPersistPort, final PropertyExceptionMessageConfiguration propertyExceptionMessageConfiguration) {
        return new DefaultServiceReactorProcessor<>(defaultPersistPort, propertyExceptionMessageConfiguration);
    }

    /**
     * @param defaultServiceRestProcessor defaultServiceRestProcessor bean
     * @param dtoToOptionalEntityFunc     dtoToOptionalEntityFunc bean
     * @param dtoToStreamEntityFunc       dtoToStreamEntityFunc bean
     * @param entityToEntityFunc          entityToEntityFunc bean
     * @return IDefaultCrudServicePort<NameBasics, String, NameBasics, Flux < NameBasics>, Mono<NameBasics>>
     */
    @Override
    @Bean
    public IDefaultCrudServicePort<NameBasics, String, NameBasics, Flux<NameBasics>, Mono<NameBasics>> defaultCrudServicePort(final IServiceCrudProcessor<NameBasics, String, NameBasics, Flux<NameBasics>, Mono<NameBasics>> defaultServiceRestProcessor, final ISingleArgFunctionalInterface<NameBasics, Mono<NameBasics>> dtoToOptionalEntityFunc, final ISingleArgFunctionalInterface<NameBasics, Stream<NameBasics>> dtoToStreamEntityFunc, final IBiArgFunctionalInterface<NameBasics, Mono<NameBasics>> entityToEntityFunc) {
        return new ReactorServiceAdapter<>(defaultServiceRestProcessor, dtoToOptionalEntityFunc, dtoToStreamEntityFunc, entityToEntityFunc);
    }

    /**
     * @param mapper NameBasicsMapper bean
     * @return ISingleArgFunctionalInterface<NameBasics, Mono < NameBasics>>
     */
    @Override
    @Bean
    @Qualifier("ISingleArgFunctionalInterfaceCSTREAM")
    public ISingleArgFunctionalInterface<NameBasics, Mono<NameBasics>> optionalIFunctionalMapper(final NameBasicsMapper mapper) {
        return dto -> wrap(mapper.toEntity(dto));
    }

    /**
     * @param mapper NameBasicsMapper bean
     * @return ISingleArgFunctionalInterface<NameBasics, Stream < NameBasics>>
     */
    @Override
    @Bean
    @Qualifier("ISingleArgFunctionalInterfaceCE")
    public ISingleArgFunctionalInterface<NameBasics, Stream<NameBasics>> dtoToStreamEntityFunc(final NameBasicsMapper mapper) {
        return dto -> Stream.of(mapper.toEntity(dto));
    }

    /**
     * @param mapper NameBasicsMapper bean
     * @return IBiArgFunctionalInterface<NameBasics, Mono < NameBasics>>
     */
    @Override
    @Bean
    public IBiArgFunctionalInterface<NameBasics, Mono<NameBasics>> dtoToEntityBiArgFunc(final NameBasicsMapper mapper) {
        return (entitySource, entityDestination) -> {
            executeIfPresent(entitySource, entityDestination, mapper::update);
            return entityDestination;
        };
    }
}
