package org.example.codefox.domainpolereactive;

import org.example.codefox.domainpolereactive.mapper.PoleMapper;
import org.example.codefox.domainpolereactive.model.Pole;
import org.mapstruct.factory.Mappers;

/**
 * Class {@code DomainPoleReactiveApplication} provides [...]
 *
 * @author Hamza MOUMINE
 * @see <a href="h.moumine@outlook.com">h.moumine@outlook.com</a>
 * @see <a href="https://www.linkedin.com/in/hamza-moumine">LinkedIn Profile</a>
 * @see <a href="https://consort-group.com/">Employed by Consort NT Group</a>
 */
public class DomainPoleReactiveApplication {

    public static void main(final String[] args) {
        // Nothing to do

        final PoleMapper poleMapper = Mappers.getMapper(PoleMapper.class);
        final Pole pole = Pole.builder().name("test").build();
        System.out.println(poleMapper.toEntity(pole).getName());
    }
}
