package com.thy.airport;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.security.SecuritySchemes;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@SecuritySchemes({
    @SecurityScheme(
        name = "keycloak",
        openIdConnectUrl = "http://localhost:8080/realms/thy/.well-known/openid-configuration",
        type = SecuritySchemeType.OPENIDCONNECT,
        in = SecuritySchemeIn.HEADER
    )
})
public class AirportApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirportApplication.class, args);
	}

}
