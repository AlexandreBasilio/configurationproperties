package com.bsn.configurationproperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

//@Configuration
@ConfigurationProperties(prefix = "mail.credentials")
@PropertySource("classpath:configProps.properties")
@Getter
@ConstructorBinding  // This essentially means that @ConfigurationProperties-annotated classes may now be immutable.
@AllArgsConstructor
public class ImmutableCredentials {

    private final String authMethod;
    private final String username;
    private final String password;
}
