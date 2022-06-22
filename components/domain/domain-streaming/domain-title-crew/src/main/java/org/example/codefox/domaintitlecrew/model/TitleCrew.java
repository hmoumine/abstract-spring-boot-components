package org.example.codefox.domaintitlecrew.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Class {@code TitleCrew} provides [...]
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
@AllArgsConstructor
public class TitleCrew {

    private String tconst;

    private Iterable<String> directors;

    private Iterable<String> writers;
}
