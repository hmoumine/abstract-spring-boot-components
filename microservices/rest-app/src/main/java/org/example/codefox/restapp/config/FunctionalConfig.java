package org.example.codefox.restapp.config;

import org.example.codefox.domainpole.entities.PoleEntity;
import org.example.codefox.domainpole.mapper.PoleMapper;
import org.example.codefox.domainpole.model.Pole;
import org.example.codefox.spiserviceadapter.functional.IBiArgFunctionalInterface;
import org.example.codefox.spiserviceadapter.functional.ISingleArgFunctionalInterface;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
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
@ComponentScan({"org.example.codefox.domainpole.mapper"})
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
    public IBiArgFunctionalInterface<PoleEntity, Optional<PoleEntity>> entityToEntityFunc(final PoleMapper poleMapper) {
        return (poleEntitySource, poleEntityDestination) -> {
            poleEntityDestination.ifPresent(poleEntity -> poleMapper.update(poleEntity, poleEntitySource));
            return poleEntityDestination;
        };
    }
}
