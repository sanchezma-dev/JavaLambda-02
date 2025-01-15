# Invocar Función Lambda

Este proyecto es un ejemplo de cómo invocar una función AWS Lambda utilizando un cliente en una aplicación Spring Boot.

## Prerrequisitos

Antes de ejecutar esta aplicación, asegúrate de cumplir con los siguientes requisitos:

1. **Función Lambda**: La función debe estar desplegada en AWS Lambda.
2. **Credenciales de AWS**: Debes tener las credenciales de seguridad configuradas para acceder a AWS.

## Configuración

Debes agregar las credenciales de AWS y el ARN de la función Lambda en tu archivo `application.properties`. A continuación se muestra un ejemplo de configuración:

```properties
# Configuración de la aplicación
spring.application.name=JavaLambda02

# Credenciales de AWS
aws.accessKey=MI_KEY_SECRET
aws.secretKey=MI_PASS_SECRET
aws.region=eu-south-2

# ARN de la función Lambda
aws.lambda.functionArn=MI_CADENA_ARN_LAMBDA
```


**Explicación Aplicación:**

La aplicación está estructurada para invocar una función AWS Lambda a través de un cliente LambdaClient utilizando Spring Boot. A continuación, se detalla el flujo y componentes clave de la aplicación:

Propiedades en application.properties:
```
aws.accessKey: Define la clave de acceso de AWS.
aws.secretKey: Define la clave secreta de AWS.
aws.region: Especifica la región de AWS donde está desplegada la función Lambda.
aws.lambda.functionArn: Contiene el ARN de la función Lambda a la que se hará la invocación.
```
Carga de Propiedades con @Value:

Se utiliza @Value para inyectar las propiedades definidas en application.properties en el campo correspondiente en la clase LambdaService.
Componente de Configuración (LambdaConfig):

**En la clase LambdaConfig**, se configura un Bean que utiliza las credenciales definidas para crear el cliente LambdaClient. Este cliente será el encargado de invocar la función Lambda con los parámetros adecuados.
Invocación de Lambda en LambdaService:

***El servicio LambdaService contiene el método invokeLambda que:***   
Convierte el objeto RequestMessage a formato JSON.  
Prepara la petición a Lambda (con ARN y payload).  
Realiza la invocación utilizando el LambdaClient.  
Convierte la respuesta recibida de Lambda en un objeto ResponseMessage.  
En caso de error durante la invocación, se captura la excepción y se registra en los logs.
