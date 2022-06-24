package org.example.codefox.domaintitlebasics.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Class {@code TitleBasics} provides [...]
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
public class TitleBasics {

    @Id
    private String id;

    private String titleType;

    private String primaryTitle;

    private String originalTitle;

    private Short startYear;

    private Short endYear;

    private Iterable<String> genres;

    private Boolean isAdult;

    private Short runtimeMinutes;

}





