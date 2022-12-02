package com.bsn.configurationproperties.withlistMapAndObject;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;
import java.util.Map;

@Configuration   // so that Spring creates a Spring bean in the application context.
@ConfigurationProperties (prefix = "mail")  // @ConfigurationProperties provides validation of properties using the JSR-303 format.
// @ConfigurationProperties supports conversion for multiple types of binding the properties to their corresponding beans.
// @ConfigurationPropertiesScan  // With scan you can delete @Configuration or delete @EnableConfigurationProperties in the spring main
@PropertySource("classpath:configprops.properties")
@Getter
@Setter
public class ConfigProperties {

    // if any of these validations fail, then the main application would fail to start with an IllegalStateException.
    // The Hibernate Validation framework uses standard Java bean getters and setters, so it's important that we declare getters and setters for each of the properties.

    @NotBlank
    private String hostName;
    private int port;
    @Pattern(regexp = "^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,6}$")
    private String from;
    private List<String> defaultRecipients;
    private Map<String, String> additionalHeaders;
    private Credentials credentials;

    // This approach may be particularly useful when we want to bind properties to a third-party component that's outside of our control.
    @Bean
    @ConfigurationProperties (prefix = "item")
    public Item item () {
        return new Item();
    }
}
