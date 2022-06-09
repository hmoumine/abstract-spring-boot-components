package org.example.codefox.springappabstractcrudstarter.config;

import org.example.codefox.domaincommons.mapper.AbstractMapper;
import org.example.codefox.spiserviceadapter.functional.IBiArgConsumerFunctionalInterface;
import org.example.codefox.spiserviceadapter.functional.IBiArgFunctionalInterface;
import org.example.codefox.spiserviceadapter.functional.ISingleArgFunctionalInterface;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.stream.Stream;

/**
 * Class {@code FunctionalConfig} provides [...]
 *
 * @author Hamza MOUMINE
 * @see <a href="h.moumine@outlook.com">h.moumine@outlook.com</a>
 * @see <a href="https://www.linkedin.com/in/hamza-moumine">LinkedIn Profile</a>
 * @see <a href="https://consort-group.com/">Employed by Consort NT Group</a>
 */

@Configuration
public abstract class FunctionalConfig<E, F, C> {

    public abstract C wrap(E e);

    public abstract void executeIfPresent(final E e, final C f, final AbstractMapper<E, E> mapper, final IBiArgConsumerFunctionalInterface<E, E> action);

    @Bean
    public ISingleArgFunctionalInterface<F, C> poleOptionalIFunctionalMapper(final AbstractMapper<E, F> mapper) {
        return pole -> wrap(mapper.toEntity(pole));
    }

    @Bean
    public ISingleArgFunctionalInterface<F, Stream<E>> dtoToStreamEntityFunc(final AbstractMapper<E, F> mapper) {
        return pole -> Stream.of(mapper.toEntity(pole));
    }

    @Bean
    public IBiArgFunctionalInterface<E, C> entityToEntityFunc(final AbstractMapper<E, E> mapper) {
        return (entitySource, entityDestination) -> {
            executeIfPresent(entitySource, entityDestination, mapper, mapper::update);
            return entityDestination;
        };
    }
}
