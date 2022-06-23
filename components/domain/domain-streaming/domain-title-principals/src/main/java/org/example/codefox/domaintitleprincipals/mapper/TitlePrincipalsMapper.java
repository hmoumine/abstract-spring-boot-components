package org.example.codefox.domaintitleprincipals.mapper;

import org.example.codefox.domaincommons.mapper.AbstractMapper;
import org.example.codefox.domaintitleprincipals.model.TitlePrincipals;
import org.mapstruct.Mapper;

/**
 * Class {@code TitlePrincipalsMapper} provides [...]
 *
 * @author Hamza MOUMINE
 * @see <a href="h.moumine@outlook.com">h.moumine@outlook.com</a>
 * @see <a href="https://www.linkedin.com/in/hamza-moumine">LinkedIn Profile</a>
 * @see <a href="https://consort-group.com/">Employed by Consort NT Group</a>
 */
@Mapper(componentModel = "spring")
public interface TitlePrincipalsMapper extends AbstractMapper<TitlePrincipals, TitlePrincipals> {

    @Override
    TitlePrincipals toDto(final TitlePrincipals entity);

}
