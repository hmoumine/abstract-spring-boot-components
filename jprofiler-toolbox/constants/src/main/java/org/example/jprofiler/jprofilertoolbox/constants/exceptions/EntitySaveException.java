package org.example.jprofiler.jprofilertoolbox.constants.exceptions;

/**
 * Class {@code EntitySaveException} provides [...]
 *
 * @author Hamza MOUMINE
 * @see <a href="h.moumine@outlook.com">h.moumine@outlook.com</a>
 * @see <a href="https://www.linkedin.com/in/hamza-moumine">LinkedIn Profile</a>
 * @see <a href="https://consort-group.com/">Employed by Consort NT Group</a>
 */
public class EntitySaveException extends ACustomException {

    protected static final String ENTITY_SAVE_EXCEPTION_DEFAULT_CODE = "ERR_S_0";

    public EntitySaveException(final String code, final String message, final Throwable throwable) {
        super(code, message, throwable);
    }

    public EntitySaveException(final String code, final String message) {
        super(code, message);
    }

    public EntitySaveException(final String message, final Throwable throwable) {
        super(ENTITY_SAVE_EXCEPTION_DEFAULT_CODE, message, throwable);
    }

    public EntitySaveException(final String message) {
        super(ENTITY_SAVE_EXCEPTION_DEFAULT_CODE, message);
    }
}
