package org.example.codefox.domaintitleepisode.mapper;

import org.example.codefox.domaincommons.mapper.AbstractMapper;
import org.example.codefox.domaintitleepisode.model.TitleEpisode;
import org.mapstruct.Mapper;

/**
 * Interface {@code TitleEpisodeMapper} provides [...]
 *
 * @author Hamza MOUMINE
 * @see <a href="h.moumine@outlook.com">h.moumine@outlook.com</a>
 * @see <a href="https://www.linkedin.com/in/hamza-moumine">LinkedIn Profile</a>
 * @see <a href="https://consort-group.com/">Employed by Consort NT Group</a>
 */
@Mapper(componentModel = "spring")
public interface TitleEpisodeMapper extends AbstractMapper<TitleEpisode, TitleEpisode> {

    @Override
    TitleEpisode toDto(final TitleEpisode entity);

}
