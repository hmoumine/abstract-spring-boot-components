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
import org.springframework.boot.autoconfigure.domain.EntityScan;
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
@EnableReactiveMongoRepositories("org.example.codefox.domainnamebasics.repositories")
@EntityScan("org.example.codefox.domainpole.model")
@ComponentScan({
        "org.example.codefox.domainnamebasics.mapper",
        "org.example.codefox.domaincommons.mapper"})
public class AppConfiguration
        implements AApplicationConfiguration<
        NameBasics,
        UUID,
        NameBasics,
        Flux<NameBasics>,
        Mono<NameBasics>,
        NameBasicsMapper,
        NameBasicsRepository> {
    /**
     * @param e
     * @return
     */
    @Override
    public Mono<NameBasics> wrap(final NameBasics e) {
        return Mono.just(e);
    }

    /**
     * @param e
     * @param f
     * @param action
     */
    @Override
    public void executeIfPresent(final NameBasics e, final Mono<NameBasics> f, final IBiArgConsumerFunctionalInterface<NameBasics, NameBasics> action) {
        f.doOnNext(entity -> action.apply(e, entity));
    }

    /**
     * @return
     */
    @Override
    public PropertyExceptionMessageConfiguration propertyExceptionMessageConfiguration() {
        return new PropertyExceptionMessageConfiguration();
    }

    /**
     * @param repository
     * @param propertyExceptionMessageConfiguration
     * @return
     */
    @Override
    public IDefaultPersistPort<NameBasics, UUID, Flux<NameBasics>, Mono<NameBasics>> defaultPersistPort(final NameBasicsRepository repository, final PropertyExceptionMessageConfiguration propertyExceptionMessageConfiguration) {
        return new AdapterPersistenceDataReactive<>(repository, propertyExceptionMessageConfiguration);
    }

    /**
     * @param defaultPersistPort
     * @param propertyExceptionMessageConfiguration
     * @return
     */
    @Override
    public IServiceCrudProcessor<NameBasics, UUID, NameBasics, Flux<NameBasics>, Mono<NameBasics>> crudRestServiceCrudProcessorPoleEntity(final IDefaultPersistPort<NameBasics, UUID, Flux<NameBasics>, Mono<NameBasics>> defaultPersistPort, final PropertyExceptionMessageConfiguration propertyExceptionMessageConfiguration) {
        return new DefaultServiceReactorProcessor<>(defaultPersistPort, propertyExceptionMessageConfiguration);
    }

    /**
     * @param defaultServiceRestProcessor
     * @param dtoToOptionalEntityFunc
     * @param dtoToStreamEntityFunc
     * @param entityToEntityFunc
     * @return
     */
    @Override
    public IDefaultCrudServicePort<NameBasics, UUID, NameBasics, Flux<NameBasics>, Mono<NameBasics>> defaultCrudServicePort(final IServiceCrudProcessor<NameBasics, UUID, NameBasics, Flux<NameBasics>, Mono<NameBasics>> defaultServiceRestProcessor, final ISingleArgFunctionalInterface<NameBasics, Mono<NameBasics>> dtoToOptionalEntityFunc, final ISingleArgFunctionalInterface<NameBasics, Stream<NameBasics>> dtoToStreamEntityFunc, final IBiArgFunctionalInterface<NameBasics, Mono<NameBasics>> entityToEntityFunc) {
        return new ReactorServiceAdapter<>(defaultServiceRestProcessor, dtoToOptionalEntityFunc, dtoToStreamEntityFunc, entityToEntityFunc);
    }

    /**
     * @param mapper
     * @return
     */
    @Override
    public ISingleArgFunctionalInterface<NameBasics, Mono<NameBasics>> optionalIFunctionalMapper(final NameBasicsMapper mapper) {
        return dto -> wrap(mapper.toEntity(dto));
    }

    /**
     * @param mapper
     * @return
     */
    @Override
    public ISingleArgFunctionalInterface<NameBasics, Stream<NameBasics>> dtoToStreamEntityFunc(final NameBasicsMapper mapper) {
        return dto -> Stream.of(mapper.toEntity(dto));
    }

    /**
     * @param mapper
     * @return
     */
    @Override
    public IBiArgFunctionalInterface<NameBasics, Mono<NameBasics>> dtoToEntityBiArgFunc(final NameBasicsMapper mapper) {
        return (entitySource, entityDestination) -> {
            executeIfPresent(entitySource, entityDestination, mapper::update);
            return entityDestination;
        };
    }
}
