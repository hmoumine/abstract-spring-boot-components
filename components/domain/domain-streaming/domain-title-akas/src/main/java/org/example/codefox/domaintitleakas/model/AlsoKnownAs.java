package org.example.codefox.domaintitleakas.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Class {@code AlsoKnownAs} provides [...]
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
public class AlsoKnownAs {

    private String titleId;

    private Byte ordering;

    private String title;

    private String region;

    private String language;

    private String types;

    private String attributes;

    private Boolean isOriginalTitle;

}
