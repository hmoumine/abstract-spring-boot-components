package org.example.codefox.domaintitlebasics.mapper;

import org.example.codefox.domaincommons.mapper.AbstractMapper;
import org.example.codefox.domaintitlebasics.model.TitleBasics;
import org.mapstruct.Mapper;

/**
 * Interface {@code TitleBasicsMapper} provides [...]
 *
 * @author Hamza MOUMINE
 * @see <a href="h.moumine@outlook.com">h.moumine@outlook.com</a>
 * @see <a href="https://www.linkedin.com/in/hamza-moumine">LinkedIn Profile</a>
 * @see <a href="https://consort-group.com/">Employed by Consort NT Group</a>
 */
@Mapper(componentModel = "spring")
public interface TitleBasicsMapper extends AbstractMapper<TitleBasics, TitleBasics> {

    @Override
    TitleBasics toDto(final TitleBasics entity);

}
