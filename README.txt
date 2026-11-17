ROUND ROBIN LOAD BALANCING - CODE FILES

Contents:
- driver-service: DriverServiceApplication.java, DriverController.java,
  and application.properties.
- api-gateway: ApiGatewayApplication.java and application.yml.

Use these files in your existing STS projects. This ZIP contains source and
configuration files, not complete Maven projects or dependency POM files.

Driver Service:
- Keep server.port=8081 in application.properties for the first instance.
- Run two additional instances from Run Configurations > Arguments using:
  --server.port=8082
  --server.port=8083
- Required dependencies: Spring Web and Eureka Discovery Client.

API Gateway:
- The YAML preserves the four insurance routes and adds:
  /drivers/** -> lb://DRIVER-SERVICE
- Required dependencies: Spring Cloud Gateway, Eureka Discovery Client,
  and Spring Cloud LoadBalancer.

Start Eureka, then all three Driver Service instances, then API Gateway.

Test in a browser:
http://localhost:8080/drivers

PowerShell test:
1..9 | ForEach-Object {
    Invoke-RestMethod http://localhost:8080/drivers
}

Make sure your Spring Boot and Spring Cloud dependency versions are compatible.
