package org.example.JavaLambda02.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.lambda.LambdaClient;

@Configuration
@AllArgsConstructor //Para inyección de dependencia
public class LambdaConfig {

    private final AWSProperties awsProperties;


    // Retorna cliente propio de aws, el cual carga los valores de credenciales
    @Bean
    public LambdaClient lambdaClient() {
        AwsBasicCredentials awsCredentials = AwsBasicCredentials.create(
                awsProperties.getAccessKey(),
                awsProperties.getSecretKey()
        );

        return LambdaClient.builder()
                .region(Region.of(awsProperties.getRegion()))
                .credentialsProvider(StaticCredentialsProvider.create(awsCredentials))
                .build();
    }
}
