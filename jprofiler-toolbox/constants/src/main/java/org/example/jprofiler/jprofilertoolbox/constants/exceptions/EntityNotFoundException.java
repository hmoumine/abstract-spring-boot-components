package org.example.jprofiler.jprofilertoolbox.constants.exceptions;

/**
 * Class {@code EntityNotFoundException} provides [...]
 *
 * @author Hamza MOUMINE
 * @see <a href="h.moumine@outlook.com">h.moumine@outlook.com</a>
 * @see <a href="https://www.linkedin.com/in/hamza-moumine">LinkedIn Profile</a>
 * @see <a href="https://consort-group.com/">Employed by Consort NT Group</a>
 */
public class EntityNotFoundException extends ACustomException{

    protected static final String ENTITY_NOT_FOUND_EXCEPTION_DEFAULT_CODE = "ERR_NF_1";

    public EntityNotFoundException(final String code, final String message, final Throwable throwable) {
        super(code, message, throwable);
    }

    public EntityNotFoundException(final String code, final String message) {
        super(code, message);
    }

    public EntityNotFoundException(final String message) {
        super(ENTITY_NOT_FOUND_EXCEPTION_DEFAULT_CODE, message);
    }

    public EntityNotFoundException(final String message, final Throwable throwable) {
        super(ENTITY_NOT_FOUND_EXCEPTION_DEFAULT_CODE, message, throwable);
    }

}
