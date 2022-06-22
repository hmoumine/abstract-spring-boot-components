package org.example.codefox.domaintitlecrew.mapper;

import org.example.codefox.domaincommons.mapper.AbstractMapper;
import org.example.codefox.domaintitlecrew.model.TitleCrew;
import org.mapstruct.Mapper;

/**
 * Interface {@code TitleCrewMapper} provides [...]
 *
 * @author Hamza MOUMINE
 * @see <a href="h.moumine@outlook.com">h.moumine@outlook.com</a>
 * @see <a href="https://www.linkedin.com/in/hamza-moumine">LinkedIn Profile</a>
 * @see <a href="https://consort-group.com/">Employed by Consort NT Group</a>
 */
@Mapper
public interface TitleCrewMapper extends AbstractMapper<TitleCrew, TitleCrew> {

    @Override
    TitleCrew toDto(final TitleCrew entity);

}
