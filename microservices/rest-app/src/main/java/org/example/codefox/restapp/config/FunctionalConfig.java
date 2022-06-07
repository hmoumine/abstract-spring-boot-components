package org.example.codefox.restapp.config;

import org.example.codefox.domainpole.entities.PoleEntity;
import org.example.codefox.domainpole.mapper.PoleMapper;
import org.example.codefox.domainpole.model.Pole;
import org.example.codefox.apiserviceadapter.functional.ISingleArgFunctionalInterface;
import org.example.codefox.apiserviceadapter.functional.ITupleArgFunctionalInterface;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;
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
public class FunctionalConfig {

    @Bean
    public ISingleArgFunctionalInterface<Pole, Optional<PoleEntity>> poleOptionalIFunctionalMapper(final PoleMapper poleMapper) {
        return pole -> Optional.of(poleMapper.toEntity(pole));
    }

    @Bean
    public ISingleArgFunctionalInterface<Pole, Stream<PoleEntity>> dtoToStreamEntityFunc(final PoleMapper poleMapper) {
        return pole -> Stream.of(poleMapper.toEntity(pole));
    }

    @Bean
    public ITupleArgFunctionalInterface<PoleEntity, Optional<PoleEntity>> entityToEntityFunc(final PoleMapper poleMapper) {
        return (poleEntitySource, poleEntityDestination) -> {
            if (poleEntityDestination.isPresent()) {
                poleMapper.update(poleEntityDestination.get(), poleEntitySource);
            }
            return poleEntityDestination;
        };
    }
}
