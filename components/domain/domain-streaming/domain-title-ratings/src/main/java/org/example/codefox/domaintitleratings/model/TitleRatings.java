package org.example.codefox.domaintitleratings.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Class {@code TitleRatings} provides [...]
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
public class TitleRatings {

    private String tconst;

    private Short numVotes;

    private Float averageRating;

}
