package org.example.JavaLambda02.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Clase marcada como componente para obtener los valores definidos en el application.properties
 **/
@Component
@ConfigurationProperties(prefix = "aws")

public class AWSProperties {
    private String accessKey;
    private String secretKey;
    private String region;

    // Necesario la definición de getter y setter
    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
