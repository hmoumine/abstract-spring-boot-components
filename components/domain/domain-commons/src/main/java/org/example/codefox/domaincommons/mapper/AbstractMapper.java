package org.example.codefox.domaincommons.mapper;

import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

/**
 * Class {@code AbstractMapper} provides [...]
 *
 * @author Hamza MOUMINE
 * @see <a href="h.moumine@outlook.com">h.moumine@outlook.com</a>
 * @see <a href="https://www.linkedin.com/in/hamza-moumine">LinkedIn Profile</a>
 * @see <a href="https://consort-group.com/">Employed by Consort NT Group</a>
 */

public interface AbstractMapper<E, F> {

    E toEntity(final F dto);

    @Mapping(target = "id", source = "id")
    F toDto(final E entity);

    void update(F dto, @MappingTarget E updateEntity);

}
