package org.example.codefox.toolboxconstants.exceptions;

/**
 * Class {@code EntityMappingException} provides [...]
 *
 * @author Hamza MOUMINE
 * @see <a href="h.moumine@outlook.com">h.moumine@outlook.com</a>
 * @see <a href="https://www.linkedin.com/in/hamza-moumine">LinkedIn Profile</a>
 * @see <a href="https://consort-group.com/">Employed by Consort NT Group</a>
 */
public class EntityMappingException extends ACustomException {

    protected static final String ENTITY_MAPPING_EXCEPTION_DEFAULT_CODE = "ERR_NF_1";

    public EntityMappingException(final String code, final String message, final Throwable throwable) {
        super(code, message, throwable);
    }

    public EntityMappingException(final String code, final String message) {
        super(code, message);
    }

    public EntityMappingException(final String message, final Throwable throwable) {
        super(ENTITY_MAPPING_EXCEPTION_DEFAULT_CODE, message, throwable);
    }

    public EntityMappingException(final String message) {
        super(ENTITY_MAPPING_EXCEPTION_DEFAULT_CODE, message);
    }


}
