package org.example.codefox.titleratingsapp.config;

import org.example.codefox.adapterpersistencereactivedataflux.adapter.AdapterPersistenceDataReactive;
import org.example.codefox.crudreactiveserviceadapter.adapter.ReactorServiceAdapter;
import org.example.codefox.crudreactiveserviceadapter.processing.DefaultServiceReactorProcessor;
import org.example.codefox.domaintitleratings.mapper.TitleRatingsMapper;
import org.example.codefox.domaintitleratings.model.TitleRatings;
import org.example.codefox.domaintitleratings.repositories.TitleRatingsRepository;
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
@EnableReactiveMongoRepositories("org.example.codefox.domaintitleratings.repositories")
@EntityScan("org.example.codefox.domaintitleratings.model")
@ComponentScan({
        "org.example.codefox.domaintitleratings.mapper",
        "org.example.codefox.domaincommons.mapper"})
public class AppConfiguration
        implements AApplicationConfiguration<
        TitleRatings,
        UUID,
        TitleRatings,
        Flux<TitleRatings>,
        Mono<TitleRatings>,
        TitleRatingsMapper,
        TitleRatingsRepository> {
    /**
     * @param e object to wrap
     * @return Mono<TitleRatings>
     */
    @Override
    public Mono<TitleRatings> wrap(final TitleRatings e) {
        return Mono.just(e);
    }

    /**
     * @param e      TitleRatings object source data
     * @param f      Mono of TitleRatings destination data entity
     * @param action Action to apply to e,f
     */
    @Override
    public void executeIfPresent(final TitleRatings e, final Mono<TitleRatings> f, final IBiArgConsumerFunctionalInterface<TitleRatings, TitleRatings> action) {
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
     * @param repository                            TitleRatingsRepository bean
     * @param propertyExceptionMessageConfiguration propertyExceptionMessageConfiguration bean
     * @return IDefaultPersistPort<TitleRatings, UUID, Flux < TitleRatings>, Mono<TitleRatings>>
     */
    @Override
    @Bean
    public IDefaultPersistPort<TitleRatings, UUID, Flux<TitleRatings>, Mono<TitleRatings>> defaultPersistPort(final TitleRatingsRepository repository, final PropertyExceptionMessageConfiguration propertyExceptionMessageConfiguration) {
        return new AdapterPersistenceDataReactive<>(repository, propertyExceptionMessageConfiguration);
    }

    /**
     * @param defaultPersistPort                    defaultPersistPort bean
     * @param propertyExceptionMessageConfiguration propertyExceptionMessageConfiguration bean
     * @return IServiceCrudProcessor<TitleRatings, UUID, TitleRatings, Flux < TitleRatings>, Mono<TitleRatings>>
     */
    @Override
    @Bean
    public IServiceCrudProcessor<TitleRatings, UUID, TitleRatings, Flux<TitleRatings>, Mono<TitleRatings>> crudRestServiceCrudProcessorPoleEntity(final IDefaultPersistPort<TitleRatings, UUID, Flux<TitleRatings>, Mono<TitleRatings>> defaultPersistPort, final PropertyExceptionMessageConfiguration propertyExceptionMessageConfiguration) {
        return new DefaultServiceReactorProcessor<>(defaultPersistPort, propertyExceptionMessageConfiguration);
    }

    /**
     * @param defaultServiceRestProcessor defaultServiceRestProcessor bean
     * @param dtoToOptionalEntityFunc     dtoToOptionalEntityFunc bean
     * @param dtoToStreamEntityFunc       dtoToStreamEntityFunc bean
     * @param entityToEntityFunc          entityToEntityFunc bean
     * @return IDefaultCrudServicePort<TitleRatings, UUID, TitleRatings, Flux < TitleRatings>, Mono<TitleRatings>>
     */
    @Override
    @Bean
    public IDefaultCrudServicePort<TitleRatings, UUID, TitleRatings, Flux<TitleRatings>, Mono<TitleRatings>> defaultCrudServicePort(final IServiceCrudProcessor<TitleRatings, UUID, TitleRatings, Flux<TitleRatings>, Mono<TitleRatings>> defaultServiceRestProcessor, final ISingleArgFunctionalInterface<TitleRatings, Mono<TitleRatings>> dtoToOptionalEntityFunc, final ISingleArgFunctionalInterface<TitleRatings, Stream<TitleRatings>> dtoToStreamEntityFunc, final IBiArgFunctionalInterface<TitleRatings, Mono<TitleRatings>> entityToEntityFunc) {
        return new ReactorServiceAdapter<>(defaultServiceRestProcessor, dtoToOptionalEntityFunc, dtoToStreamEntityFunc, entityToEntityFunc);
    }

    /**
     * @param mapper TitleRatingsMapper bean
     * @return ISingleArgFunctionalInterface<TitleRatings, Mono < TitleRatings>>
     */
    @Override
    @Bean
    @Qualifier("ISingleArgFunctionalInterfaceCSTREAM")
    public ISingleArgFunctionalInterface<TitleRatings, Mono<TitleRatings>> optionalIFunctionalMapper(final TitleRatingsMapper mapper) {
        return dto -> wrap(mapper.toEntity(dto));
    }

    /**
     * @param mapper TitleRatingsMapper bean
     * @return ISingleArgFunctionalInterface<TitleRatings, Stream < TitleRatings>>
     */
    @Override
    @Bean
    @Qualifier("ISingleArgFunctionalInterfaceCE")
    public ISingleArgFunctionalInterface<TitleRatings, Stream<TitleRatings>> dtoToStreamEntityFunc(final TitleRatingsMapper mapper) {
        return dto -> Stream.of(mapper.toEntity(dto));
    }

    /**
     * @param mapper TitleRatingsMapper bean
     * @return IBiArgFunctionalInterface<TitleRatings, Mono < TitleRatings>>
     */
    @Override
    @Bean
    public IBiArgFunctionalInterface<TitleRatings, Mono<TitleRatings>> dtoToEntityBiArgFunc(final TitleRatingsMapper mapper) {
        return (entitySource, entityDestination) -> {

            executeIfPresent(entitySource, entityDestination, mapper::update);
            return entityDestination;
        };
    }
}