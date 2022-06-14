package org.example.codefox.springappabstractcrudstarter.config;

import org.example.codefox.domaincommons.mapper.AbstractMapper;
import org.example.codefox.jprofilestarters.springappmessagepropertystarter.messages.PropertyExceptionMessageConfiguration;
import org.example.codefox.spipersistenceport.spi.IDefaultPersistPort;
import org.example.codefox.spiserviceadapter.functional.IBiArgConsumerFunctionalInterface;
import org.example.codefox.spiserviceadapter.functional.IBiArgFunctionalInterface;
import org.example.codefox.spiserviceadapter.functional.ISingleArgFunctionalInterface;
import org.example.codefox.spiserviceadapter.processing.IServiceCrudProcessor;
import org.example.codefox.spiserviceadapter.spi.IDefaultCrudServicePort;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
public interface AApplicationConfiguration<A, B, C, D, E,
        F extends AbstractMapper<A, C>,
        G> {

    E wrap(A e);

    void executeIfPresent(final C e, final E f, final IBiArgConsumerFunctionalInterface<C, A> action);

    @Bean
    PropertyExceptionMessageConfiguration propertyExceptionMessageConfiguration();

    @Bean
    IDefaultPersistPort<A, B, D, E> defaultPersistPort(final G repository, final PropertyExceptionMessageConfiguration propertyExceptionMessageConfiguration);

    @Bean
    IServiceCrudProcessor<A, B, C, D, E>
    crudRestServiceCrudProcessorPoleEntity(final IDefaultPersistPort<A, B, D, E> defaultPersistPort,
                                           final PropertyExceptionMessageConfiguration propertyExceptionMessageConfiguration);

    @Bean
    IDefaultCrudServicePort<A, B, C, D, E>
    defaultCrudServicePort(
            final IServiceCrudProcessor<A, B, C, D, E> defaultServiceRestProcessor,
            @Qualifier("ISingleArgFunctionalInterfaceCE") final ISingleArgFunctionalInterface<C, E> dtoToOptionalEntityFunc,
            @Qualifier("ISingleArgFunctionalInterfaceCSTREAM") final ISingleArgFunctionalInterface<C, Stream<A>> dtoToStreamEntityFunc,
            @Qualifier("IBiArgFunctionalInterfaceBiArg") final IBiArgFunctionalInterface<C, E> entityToEntityFunc
    );

    @Bean
    @Qualifier("ISingleArgFunctionalInterfaceCE")
    ISingleArgFunctionalInterface<C, E> poleOptionalIFunctionalMapper(final F mapper);

    @Bean
    @Qualifier("ISingleArgFunctionalInterfaceCSTREAM")
    ISingleArgFunctionalInterface<C, Stream<A>> dtoToStreamEntityFunc(final F mapper);

    @Bean
    @Qualifier("IBiArgFunctionalInterfaceBiArg")
    IBiArgFunctionalInterface<C, E> dtoToEntityBiArgFunc(final F mapper);

}
