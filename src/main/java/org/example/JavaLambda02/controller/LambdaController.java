package org.example.JavaLambda02.controller;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.JavaLambda02.dto.RequestMessage;
import org.example.JavaLambda02.dto.ResponseMessage;
import org.example.JavaLambda02.service.LambdaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Slf4j
public class LambdaController {

    private final LambdaService lambdaService;

    @PostMapping("/invoke-lambda")
    public ResponseMessage invokeLambda(@RequestBody RequestMessage request) {
        log.info("InvokeLambda en controller, con valores: {}, {}", request.getName(), request.getFeeling());
        return lambdaService.invokeLambda(request);
    }
}
