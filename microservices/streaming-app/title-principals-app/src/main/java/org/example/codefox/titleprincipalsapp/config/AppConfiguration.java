package org.example.codefox.titleprincipalsapp.config;

import org.example.codefox.adapterpersistencereactivedataflux.adapter.AdapterPersistenceDataReactive;
import org.example.codefox.crudreactiveserviceadapter.adapter.ReactorServiceAdapter;
import org.example.codefox.crudreactiveserviceadapter.processing.DefaultServiceReactorProcessor;
import org.example.codefox.domaintitleprincipals.mapper.TitlePrincipalsMapper;
import org.example.codefox.domaintitleprincipals.model.TitlePrincipals;
import org.example.codefox.domaintitleprincipals.repositories.TitlePrincipalsRepository;
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
@EnableReactiveMongoRepositories("org.example.codefox.domaintitleprincipals.repositories")
@EntityScan("org.example.codefox.domaintitleprincipals.model")
@ComponentScan({
        "org.example.codefox.domaintitleprincipals.mapper",
        "org.example.codefox.domaincommons.mapper"})
public class AppConfiguration
        implements AApplicationConfiguration<
        TitlePrincipals,
        UUID,
        TitlePrincipals,
        Flux<TitlePrincipals>,
        Mono<TitlePrincipals>,
        TitlePrincipalsMapper,
        TitlePrincipalsRepository> {
    /**
     * @param e object to wrap
     * @return Mono<TitlePrincipals>
     */
    @Override
    public Mono<TitlePrincipals> wrap(final TitlePrincipals e) {
        return Mono.just(e);
    }

    /**
     * @param e      TitlePrincipals object source data
     * @param f      Mono of TitlePrincipals destination data entity
     * @param action Action to apply to e,f
     */
    @Override
    public void executeIfPresent(final TitlePrincipals e, final Mono<TitlePrincipals> f, final IBiArgConsumerFunctionalInterface<TitlePrincipals, TitlePrincipals> action) {
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
     * @param repository                            TitlePrincipalsRepository bean
     * @param propertyExceptionMessageConfiguration propertyExceptionMessageConfiguration bean
     * @return IDefaultPersistPort<TitlePrincipals, UUID, Flux < TitlePrincipals>, Mono<TitlePrincipals>>
     */
    @Override
    @Bean
    public IDefaultPersistPort<TitlePrincipals, UUID, Flux<TitlePrincipals>, Mono<TitlePrincipals>> defaultPersistPort(final TitlePrincipalsRepository repository, final PropertyExceptionMessageConfiguration propertyExceptionMessageConfiguration) {
        return new AdapterPersistenceDataReactive<>(repository, propertyExceptionMessageConfiguration);
    }

    /**
     * @param defaultPersistPort                    defaultPersistPort bean
     * @param propertyExceptionMessageConfiguration propertyExceptionMessageConfiguration bean
     * @return IServiceCrudProcessor<TitlePrincipals, UUID, TitlePrincipals, Flux < TitlePrincipals>, Mono<TitlePrincipals>>
     */
    @Override
    @Bean
    public IServiceCrudProcessor<TitlePrincipals, UUID, TitlePrincipals, Flux<TitlePrincipals>, Mono<TitlePrincipals>> crudRestServiceCrudProcessorPoleEntity(final IDefaultPersistPort<TitlePrincipals, UUID, Flux<TitlePrincipals>, Mono<TitlePrincipals>> defaultPersistPort, final PropertyExceptionMessageConfiguration propertyExceptionMessageConfiguration) {
        return new DefaultServiceReactorProcessor<>(defaultPersistPort, propertyExceptionMessageConfiguration);
    }

    /**
     * @param defaultServiceRestProcessor defaultServiceRestProcessor bean
     * @param dtoToOptionalEntityFunc     dtoToOptionalEntityFunc bean
     * @param dtoToStreamEntityFunc       dtoToStreamEntityFunc bean
     * @param entityToEntityFunc          entityToEntityFunc bean
     * @return IDefaultCrudServicePort<TitlePrincipals, UUID, TitlePrincipals, Flux < TitlePrincipals>, Mono<TitlePrincipals>>
     */
    @Override
    @Bean
    public IDefaultCrudServicePort<TitlePrincipals, UUID, TitlePrincipals, Flux<TitlePrincipals>, Mono<TitlePrincipals>> defaultCrudServicePort(final IServiceCrudProcessor<TitlePrincipals, UUID, TitlePrincipals, Flux<TitlePrincipals>, Mono<TitlePrincipals>> defaultServiceRestProcessor, final ISingleArgFunctionalInterface<TitlePrincipals, Mono<TitlePrincipals>> dtoToOptionalEntityFunc, final ISingleArgFunctionalInterface<TitlePrincipals, Stream<TitlePrincipals>> dtoToStreamEntityFunc, final IBiArgFunctionalInterface<TitlePrincipals, Mono<TitlePrincipals>> entityToEntityFunc) {
        return new ReactorServiceAdapter<>(defaultServiceRestProcessor, dtoToOptionalEntityFunc, dtoToStreamEntityFunc, entityToEntityFunc);
    }

    /**
     * @param mapper TitlePrincipalsMapper bean
     * @return ISingleArgFunctionalInterface<TitlePrincipals, Mono < TitlePrincipals>>
     */
    @Override
    @Bean
    @Qualifier("ISingleArgFunctionalInterfaceCSTREAM")
    public ISingleArgFunctionalInterface<TitlePrincipals, Mono<TitlePrincipals>> optionalIFunctionalMapper(final TitlePrincipalsMapper mapper) {
        return dto -> wrap(mapper.toEntity(dto));
    }

    /**
     * @param mapper TitlePrincipalsMapper bean
     * @return ISingleArgFunctionalInterface<TitlePrincipals, Stream < TitlePrincipals>>
     */
    @Override
    @Bean
    @Qualifier("ISingleArgFunctionalInterfaceCE")
    public ISingleArgFunctionalInterface<TitlePrincipals, Stream<TitlePrincipals>> dtoToStreamEntityFunc(final TitlePrincipalsMapper mapper) {
        return dto -> Stream.of(mapper.toEntity(dto));
    }

    /**
     * @param mapper TitlePrincipalsMapper bean
     * @return IBiArgFunctionalInterface<TitlePrincipals, Mono < TitlePrincipals>>
     */
    @Override
    @Bean
    public IBiArgFunctionalInterface<TitlePrincipals, Mono<TitlePrincipals>> dtoToEntityBiArgFunc(final TitlePrincipalsMapper mapper) {
        return (entitySource, entityDestination) -> {

            executeIfPresent(entitySource, entityDestination, mapper::update);
            return entityDestination;
        };
    }
}