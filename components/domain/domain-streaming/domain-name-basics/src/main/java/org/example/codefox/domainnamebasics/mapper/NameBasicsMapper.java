package org.example.codefox.domainnamebasics.mapper;

import org.example.codefox.domaincommons.mapper.AbstractMapper;
import org.example.codefox.domainnamebasics.model.NameBasics;
import org.mapstruct.Mapper;

/**
 * Class {@code NameBasicsMapper} provides [...]
 *
 * @author Hamza MOUMINE
 * @see <a href="h.moumine@outlook.com">h.moumine@outlook.com</a>
 * @see <a href="https://www.linkedin.com/in/hamza-moumine">LinkedIn Profile</a>
 * @see <a href="https://consort-group.com/">Employed by Consort NT Group</a>
 */
@Mapper
public interface NameBasicsMapper extends AbstractMapper<NameBasics, NameBasics> {

    @Override
    NameBasics toDto(final NameBasics entity);
}
