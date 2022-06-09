package org.example.codefox.springappcustomannotations.processor;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.data.repository.config.AnnotationRepositoryConfigurationSource;
import org.springframework.data.util.Streamable;
import org.springframework.lang.Nullable;
import org.springframework.util.StringUtils;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Class {@code AnnotationRepositoryConfigurationSource} provides [...]
 *
 * @author <a href="https://stackoverflow.com/questions/47635650/spring-data-jpa-how-to-programmatically-set-jparepository-base-packages/51629110#51629110">StackOverflow: User ( Roman Puchkovskiy, </a>
 * @see <a href="h.moumine@outlook.com">h.moumine@outlook.com</a>
 * @see <a href="https://www.linkedin.com/in/hamza-moumine">LinkedIn Profile</a>
 * @see <a href="https://consort-group.com/">Employed by Consort NT Group</a>
 */
public class AbdAnnotationRepositoryConfigurationSource extends AnnotationRepositoryConfigurationSource {

    private final Environment environment;

    public AbdAnnotationRepositoryConfigurationSource(
            final AnnotationMetadata metadata,
            final Class<? extends Annotation> annotation,
            final ResourceLoader resourceLoader,
            final Environment environment,
            final BeanDefinitionRegistry registry
    ) {
        super(metadata, annotation, resourceLoader, environment, registry);
        this.environment = environment;
    }

    @Override
    public Streamable<String> getBasePackages() {
        final Streamable<String> rawPackages = super.getBasePackages();
        return Streamable.of(() -> rawPackages.stream()
                .flatMap(raw -> parsePackagesSpel(raw).stream())
        );
    }

    private List<String> parsePackagesSpel(@Nullable String rawPackage) {
        Objects.requireNonNull(rawPackage, "Package specification cannot be null");

        if (!rawPackage.trim().startsWith("$")) {
            return Collections.singletonList(rawPackage);
        }

        rawPackage = rawPackage.trim();
        final String propertyName = rawPackage.substring("${".length(), rawPackage.length() - "}".length());
        final String packages = this.environment.getProperty(propertyName);

        if (!StringUtils.hasText(packages)) {
            throw new IllegalStateException(
                    String.format("Could not resolve the following packages definition: %s", rawPackage));
        }

        return Arrays.stream(packages.split(","))
                .map(String::trim)
                .filter(StringUtils::hasText)
                .toList();
    }
}
