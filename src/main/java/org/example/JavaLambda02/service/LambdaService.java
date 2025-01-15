package org.example.JavaLambda02.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.example.JavaLambda02.dto.RequestMessage;
import org.example.JavaLambda02.dto.ResponseMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.core.SdkBytes;
import software.amazon.awssdk.services.lambda.LambdaClient;
import software.amazon.awssdk.services.lambda.model.InvokeRequest;
import software.amazon.awssdk.services.lambda.model.InvokeResponse;

@Service
@Slf4j
public class LambdaService {

    private final LambdaClient lambdaClient;
    private final ObjectMapper objectMapper;

    public LambdaService(ObjectMapper objectMapper, LambdaClient lambdaClient) {
        this.objectMapper = objectMapper;
        this.lambdaClient = lambdaClient;
    }

    // Properties
    @Value("${aws.lambda.functionArn}")
    private String functionArn;

    public ResponseMessage invokeLambda(RequestMessage request) {
        log.info("Service, invokeLambda: {}, {}", request.getName(), request.getFeeling());
        try {
            // Convertir el RequestMessage a JSON
            String requestJson = objectMapper.writeValueAsString(request);

            // Preparar la petición a Lambda
            InvokeRequest invokeRequest = InvokeRequest.builder()
                    .functionName(functionArn)
                    .payload(SdkBytes.fromUtf8String(requestJson))
                    .build();

            // Invocar Lambda y obtener respuesta
            InvokeResponse response = lambdaClient.invoke(invokeRequest);

            // Convertir la respuesta de Lambda a ResponseMessage
            return objectMapper.readValue(response.payload().asUtf8String(), ResponseMessage.class);

        } catch (Exception e) {
            log.error("Error: {}", e.getMessage());
            throw new RuntimeException("Error invoking Lambda function", e);
        }
    }
}
