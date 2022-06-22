package org.example.codefox.domaintitleepisode.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Class {@code TitleEpisode} provides [...]
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
public class TitleEpisode {

    private String tconst;

    private String parentTconst;

    private Short seasonNumber;

    private Short episodeNumber;
}
