package org.example.codefox.toolboxconstants.messages;

/**
 * The class Jpa exception constants.
 *
 * @author Hamza MOUMINE
 * @see <a href="h.moumine@outlook.com">h.moumine@outlook.com</a>
 * @see <a href="https://www.linkedin.com/in/hamza-moumine?originalSubdomain=fr">LinkedIn Profile</a>
 */
public final class RepositoryExceptionConstants {
    private RepositoryExceptionConstants() {
    }

    /**
     * The constant ENTITY_ID_NOT_FOUND.
     */
    public static final String ENTITY_ID_NOT_FOUND = "Entity with id '%s' not found";

    public static final String ENTITY_SAVING_EXCEPTION = "Error while saving entity defined as '%s'";

    public static final String ENTITY_MAPPING_EXCEPTION = "Error while mapping entity.";
}
