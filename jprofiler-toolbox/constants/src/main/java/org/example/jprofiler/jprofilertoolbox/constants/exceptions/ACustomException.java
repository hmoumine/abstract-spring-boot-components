package org.example.jprofiler.jprofilertoolbox.constants.exceptions;

import lombok.Getter;
import lombok.Setter;


/**
 * Class {@code ACustomException} provides [...]
 *
 * @author Hamza MOUMINE
 * @see <a href="h.moumine@outlook.com">h.moumine@outlook.com</a>
 * @see <a href="https://www.linkedin.com/in/hamza-moumine">LinkedIn Profile</a>
 * @see <a href="https://consort-group.com/">Employed by Consort NT Group</a>
 */

@Getter
@Setter
public abstract class ACustomException extends RuntimeException{

    private final String code;

    private final String message;

    private final Throwable throwable;

    protected ACustomException(final String code, final String message, final Throwable throwable) {
        super();
        this.code = code;
        this.message = message;
        this.throwable = throwable;
    }

    protected ACustomException(final String code, final String message) {
        super();
        this.code = code;
        this.message = message;
        this.throwable = null;
    }

}
