package org.example.codefox.domaintitleratings.mapper;

import org.example.codefox.domaincommons.mapper.AbstractMapper;
import org.example.codefox.domaintitleratings.model.TitleRatings;
import org.mapstruct.Mapper;

/**
 * Class {@code TitleRatingsMapper} provides [...]
 *
 * @author Hamza MOUMINE
 * @see <a href="h.moumine@outlook.com">h.moumine@outlook.com</a>
 * @see <a href="https://www.linkedin.com/in/hamza-moumine">LinkedIn Profile</a>
 * @see <a href="https://consort-group.com/">Employed by Consort NT Group</a>
 */
@Mapper(componentModel = "spring")
public interface TitleRatingsMapper extends AbstractMapper<TitleRatings, TitleRatings> {

    @Override
    TitleRatings toDto(final TitleRatings entity);

}
