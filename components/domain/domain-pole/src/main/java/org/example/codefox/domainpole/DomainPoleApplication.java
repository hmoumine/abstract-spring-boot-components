package org.example.codefox.domainpole;

import org.example.codefox.domainpole.mapper.PoleMapper;
import org.example.codefox.domainpole.model.Pole;
import org.mapstruct.factory.Mappers;

/**
 * Class {@code DomainPoleApplication} provides [...]
 *
 * @author Hamza MOUMINE
 * @see <a href="h.moumine@outlook.com">h.moumine@outlook.com</a>
 * @see <a href="https://www.linkedin.com/in/hamza-moumine">LinkedIn Profile</a>
 * @see <a href="https://consort-group.com/">Employed by Consort NT Group</a>
 */
public class DomainPoleApplication {

    public static void main(String[] args) {
        // Nothing to do

        PoleMapper poleMapper = Mappers.getMapper(PoleMapper.class);
        Pole pole = Pole.builder().name("test").build();
        System.out.println(poleMapper.toEntity(pole).getName());
    }
}
