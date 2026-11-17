package com.vanguard.driverservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DriverController {
    @Value("${server.port}")
    private String port;

    @GetMapping("/drivers")
    public String getDriver() {
        return "Driver Service running on port: " + port;
    }
}
