package org.example.codefox.titleepisodeapp.config;

import org.example.codefox.adapterpersistencereactivedataflux.adapter.AdapterPersistenceDataReactive;
import org.example.codefox.crudreactiveserviceadapter.adapter.ReactorServiceAdapter;
import org.example.codefox.crudreactiveserviceadapter.processing.DefaultServiceReactorProcessor;
import org.example.codefox.domaintitleepisode.mapper.TitleEpisodeMapper;
import org.example.codefox.domaintitleepisode.model.TitleEpisode;
import org.example.codefox.domaintitleepisode.repositories.TitleEpisodeRepository;
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
@EnableReactiveMongoRepositories("org.example.codefox.domaintitleepisode.repositories")
@EntityScan("org.example.codefox.domaintitleepisode.model")
@ComponentScan({
        "org.example.codefox.domaintitleepisode.mapper",
        "org.example.codefox.domaincommons.mapper"})
public class AppConfiguration
        implements AApplicationConfiguration<
        TitleEpisode,
        UUID,
        TitleEpisode,
        Flux<TitleEpisode>,
        Mono<TitleEpisode>,
        TitleEpisodeMapper,
        TitleEpisodeRepository> {
    /**
     * @param e object to wrap
     * @return Mono<TitleEpisode>
     */
    @Override
    public Mono<TitleEpisode> wrap(final TitleEpisode e) {
        return Mono.just(e);
    }

    /**
     * @param e      TitleEpisode object source data
     * @param f      Mono of TitleEpisode destination data entity
     * @param action Action to apply to e,f
     */
    @Override
    public void executeIfPresent(final TitleEpisode e, final Mono<TitleEpisode> f, final IBiArgConsumerFunctionalInterface<TitleEpisode, TitleEpisode> action) {
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
     * @param repository                            TitleEpisodeRepository bean
     * @param propertyExceptionMessageConfiguration propertyExceptionMessageConfiguration bean
     * @return IDefaultPersistPort<TitleEpisode, UUID, Flux < TitleEpisode>, Mono<TitleEpisode>>
     */
    @Override
    @Bean
    public IDefaultPersistPort<TitleEpisode, UUID, Flux<TitleEpisode>, Mono<TitleEpisode>> defaultPersistPort(final TitleEpisodeRepository repository, final PropertyExceptionMessageConfiguration propertyExceptionMessageConfiguration) {
        return new AdapterPersistenceDataReactive<>(repository, propertyExceptionMessageConfiguration);
    }

    /**
     * @param defaultPersistPort                    defaultPersistPort bean
     * @param propertyExceptionMessageConfiguration propertyExceptionMessageConfiguration bean
     * @return IServiceCrudProcessor<TitleEpisode, UUID, TitleEpisode, Flux < TitleEpisode>, Mono<TitleEpisode>>
     */
    @Override
    @Bean
    public IServiceCrudProcessor<TitleEpisode, UUID, TitleEpisode, Flux<TitleEpisode>, Mono<TitleEpisode>> crudRestServiceCrudProcessorPoleEntity(final IDefaultPersistPort<TitleEpisode, UUID, Flux<TitleEpisode>, Mono<TitleEpisode>> defaultPersistPort, final PropertyExceptionMessageConfiguration propertyExceptionMessageConfiguration) {
        return new DefaultServiceReactorProcessor<>(defaultPersistPort, propertyExceptionMessageConfiguration);
    }

    /**
     * @param defaultServiceRestProcessor defaultServiceRestProcessor bean
     * @param dtoToOptionalEntityFunc     dtoToOptionalEntityFunc bean
     * @param dtoToStreamEntityFunc       dtoToStreamEntityFunc bean
     * @param entityToEntityFunc          entityToEntityFunc bean
     * @return IDefaultCrudServicePort<TitleEpisode, UUID, TitleEpisode, Flux < TitleEpisode>, Mono<TitleEpisode>>
     */
    @Override
    @Bean
    public IDefaultCrudServicePort<TitleEpisode, UUID, TitleEpisode, Flux<TitleEpisode>, Mono<TitleEpisode>> defaultCrudServicePort(final IServiceCrudProcessor<TitleEpisode, UUID, TitleEpisode, Flux<TitleEpisode>, Mono<TitleEpisode>> defaultServiceRestProcessor, final ISingleArgFunctionalInterface<TitleEpisode, Mono<TitleEpisode>> dtoToOptionalEntityFunc, final ISingleArgFunctionalInterface<TitleEpisode, Stream<TitleEpisode>> dtoToStreamEntityFunc, final IBiArgFunctionalInterface<TitleEpisode, Mono<TitleEpisode>> entityToEntityFunc) {
        return new ReactorServiceAdapter<>(defaultServiceRestProcessor, dtoToOptionalEntityFunc, dtoToStreamEntityFunc, entityToEntityFunc);
    }

    /**
     * @param mapper TitleEpisodeMapper bean
     * @return ISingleArgFunctionalInterface<TitleEpisode, Mono < TitleEpisode>>
     */
    @Override
    @Bean
    @Qualifier("ISingleArgFunctionalInterfaceCSTREAM")
    public ISingleArgFunctionalInterface<TitleEpisode, Mono<TitleEpisode>> optionalIFunctionalMapper(final TitleEpisodeMapper mapper) {
        return dto -> wrap(mapper.toEntity(dto));
    }

    /**
     * @param mapper TitleEpisodeMapper bean
     * @return ISingleArgFunctionalInterface<TitleEpisode, Stream < TitleEpisode>>
     */
    @Override
    @Bean
    @Qualifier("ISingleArgFunctionalInterfaceCE")
    public ISingleArgFunctionalInterface<TitleEpisode, Stream<TitleEpisode>> dtoToStreamEntityFunc(final TitleEpisodeMapper mapper) {
        return dto -> Stream.of(mapper.toEntity(dto));
    }

    /**
     * @param mapper TitleEpisodeMapper bean
     * @return IBiArgFunctionalInterface<TitleEpisode, Mono < TitleEpisode>>
     */
    @Override
    @Bean
    public IBiArgFunctionalInterface<TitleEpisode, Mono<TitleEpisode>> dtoToEntityBiArgFunc(final TitleEpisodeMapper mapper) {
        return (entitySource, entityDestination) -> {
            executeIfPresent(entitySource, entityDestination, mapper::update);
            return entityDestination;
        };
    }
}