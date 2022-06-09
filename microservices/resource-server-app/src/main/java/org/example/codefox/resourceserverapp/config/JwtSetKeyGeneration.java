package org.example.codefox.resourceserverapp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

/**
 * Class {@code JwtSetKeyGeneration} provides [...]
 *
 * @author Hamza MOUMINE
 * @see <a href="h.moumine@outlook.com">h.moumine@outlook.com</a>
 * @see <a href="https://www.linkedin.com/in/hamza-moumine">LinkedIn Profile</a>
 * @see <a href="https://consort-group.com/">Employed by Consort NT Group</a>
 */
@Configuration
public class JwtSetKeyGeneration {

    @Value("jwt.keygen.keysize:2048")
    private int keySize;

    @Value("jwt.keygen.algorithm:RSA")
    private String algorithm;

    @Bean
    public KeyPair keyPairBean() throws NoSuchAlgorithmException {
        final KeyPairGenerator gen = KeyPairGenerator.getInstance(algorithm);
        gen.initialize(keySize);
        return gen.generateKeyPair();
    }

}
