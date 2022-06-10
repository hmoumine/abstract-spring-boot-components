package org.example.codefox.springappabstractcrudstarter.config;

import org.example.codefox.adapterpersistencedatajpa.adapter.AdapterPersistenceDataJpa;
import org.example.codefox.adapterpersistencedatajpa.spi.IJpaPersistPort;
import org.example.codefox.crudrestserviceadapter.adapter.CrudRestServiceAdapter;
import org.example.codefox.crudrestserviceadapter.processing.DefaultServiceRestProcessor;
import org.example.codefox.crudrestserviceadapter.spi.IRestServiceCrudProcessor;
import org.example.codefox.domaincommons.mapper.AbstractMapper;
import org.example.codefox.jprofilestarters.springappmessagepropertystarter.messages.PropertyExceptionMessageConfiguration;
import org.example.codefox.spiserviceadapter.functional.IBiArgConsumerFunctionalInterface;
import org.example.codefox.spiserviceadapter.functional.IBiArgFunctionalInterface;
import org.example.codefox.spiserviceadapter.functional.ISingleArgFunctionalInterface;
import org.example.codefox.spiserviceadapter.spi.IDefaultCrudServicePort;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * Class {@code AApplicationConfiguration} provides [...]
 *
 * @param <A> Entity object type
 * @param <B> Entity identifier type
 * @param <C> Entity's dto type
 * @param <D> Container for multiple entities
 * @param <E> Container for a single entity
 * @author Hamza MOUMINE
 * @see <a href="h.moumine@outlook.com">h.moumine@outlook.com</a>
 * @see <a href="https://www.linkedin.com/in/hamza-moumine">LinkedIn Profile</a>
 * @see <a href="https://consort-group.com/">Employed by Consort NT Group</a>
 */
@Configuration
public abstract class AApplicationConfiguration<A, B, C, D, E> {

    public abstract E wrap(A e);

    public abstract void executeIfPresent(final A e, final E f, final AbstractMapper<A, A> mapper, final IBiArgConsumerFunctionalInterface<A, A> action);

    @Bean
    public PropertyExceptionMessageConfiguration propertyExceptionMessageConfiguration() {
        return new PropertyExceptionMessageConfiguration();
    }

    @Bean
    public IJpaPersistPort<A, B, D, E> jpaPersistPort(
            final JpaRepository<A, B> repository
    ) {
        return new <A, B, Iterable<A>, Optional<A>>AdapterPersistenceDataJpa(repository);
    }

    @Bean
    public IRestServiceCrudProcessor<A, B, C, D, E>
    crudRestServiceCrudProcessorPoleEntity(
            final IJpaPersistPort<A, B, D, E> defaultPersistPort,
            final PropertyExceptionMessageConfiguration propertyExceptionMessageConfiguration
    ) {
        return new <A, B, C, Iterable<A>, Optional<A>>DefaultServiceRestProcessor(defaultPersistPort, propertyExceptionMessageConfiguration);
    }

    @Bean
    public IDefaultCrudServicePort<A, B, C, D, A>
    defaultCrudServicePort(
            final IRestServiceCrudProcessor<A, B, C, D, C> defaultServiceRestProcessor,
            @Qualifier("ISingleArgFunctionalInterfaceCE") final ISingleArgFunctionalInterface<C, E> dtoToOptionalEntityFunc,
            @Qualifier("ISingleArgFunctionalInterfaceCSTREAM") final ISingleArgFunctionalInterface<C, Stream<A>> dtoToStreamEntityFunc,
            final IBiArgFunctionalInterface<A, E> entityToEntityFunc
    ) {
        return new <A, B, C, Iterable<A>, Optional<A>>CrudRestServiceAdapter(defaultServiceRestProcessor, dtoToOptionalEntityFunc, dtoToStreamEntityFunc, entityToEntityFunc);
    }

    @Bean
    @Qualifier("ISingleArgFunctionalInterfaceCE")
    //FIXME mapper problem
    public ISingleArgFunctionalInterface<C, E> poleOptionalIFunctionalMapper(final AbstractMapper<A, C> mapper) {
        return pole -> wrap(mapper.toEntity(pole));
    }

    @Bean
    @Qualifier("ISingleArgFunctionalInterfaceCSTREAM")
    public ISingleArgFunctionalInterface<C, Stream<A>> dtoToStreamEntityFunc(final AbstractMapper<A, C> mapper) {
        return pole -> Stream.of(mapper.toEntity(pole));
    }

    @Bean
    public IBiArgFunctionalInterface<A, E> entityToEntityFunc(final AbstractMapper<A, A> mapper) {
        return (entitySource, entityDestination) -> {
            executeIfPresent(entitySource, entityDestination, mapper, mapper::update);
            return entityDestination;
        };
    }

}
