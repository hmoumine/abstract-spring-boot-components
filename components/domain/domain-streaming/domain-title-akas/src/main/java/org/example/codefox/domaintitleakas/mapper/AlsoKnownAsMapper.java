package org.example.codefox.domaintitleakas.mapper;

import org.example.codefox.domaincommons.mapper.AbstractMapper;
import org.example.codefox.domaintitleakas.model.AlsoKnownAs;
import org.mapstruct.Mapper;

/**
 * Class {@code AlsoKnownAsMapper} provides [...]
 *
 * @author Hamza MOUMINE
 * @see <a href="h.moumine@outlook.com">h.moumine@outlook.com</a>
 * @see <a href="https://www.linkedin.com/in/hamza-moumine">LinkedIn Profile</a>
 * @see <a href="https://consort-group.com/">Employed by Consort NT Group</a>
 */
@Mapper(componentModel = "spring")
public interface AlsoKnownAsMapper extends AbstractMapper<AlsoKnownAs, AlsoKnownAs> {

    @Override
    AlsoKnownAs toDto(final AlsoKnownAs entity);

}
