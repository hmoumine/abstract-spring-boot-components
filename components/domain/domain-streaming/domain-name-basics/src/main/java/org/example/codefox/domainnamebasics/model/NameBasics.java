package org.example.codefox.domainnamebasics.model;

import lombok.*;
import lombok.extern.jackson.Jacksonized;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Class {@code NameBasics} provides [...]
 *
 * @author Hamza MOUMINE
 * @see <a href="h.moumine@outlook.com">h.moumine@outlook.com</a>
 * @see <a href="https://www.linkedin.com/in/hamza-moumine">LinkedIn Profile</a>
 * @see <a href="https://consort-group.com/">Employed by Consort NT Group</a>
 */
@Data
@Document
@Getter
@Setter
@Builder
@Jacksonized
@AllArgsConstructor
public class NameBasics {

    @Id
    private String id;

    private String primaryName;

    private Short birthYear;

    private Short deathYear;

    private Iterable<String> primaryProfession;

    private Iterable<String> knownForTitles;

}
