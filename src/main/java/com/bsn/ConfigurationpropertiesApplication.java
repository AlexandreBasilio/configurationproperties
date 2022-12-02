package com.bsn;

import com.bsn.configurationproperties.withConversion.PropertyConversion;
import com.bsn.configurationproperties.withConversion.custom.EmployeeConverter;
import com.bsn.configurationproperties.withlistMapAndObject.ConfigProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
// @EnableConfigurationProperties(ConfigProperties.class) // use here if you dont use @Configuration em ConfigProperties.java
public class ConfigurationpropertiesApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(ConfigurationpropertiesApplication.class, args);

        PropertyConversion propertyConversionBean = run.getBean(PropertyConversion.class);
        System.out.println("PropertyConversion bean=" + propertyConversionBean.getSizeInDefaultUnit() +
                "  " + propertyConversionBean.getTimeInDefaultUnit());

        ConfigProperties configPropertiesBean = run.getBean(ConfigProperties.class);
        System.out.println("configPropertiesBean bean=" + configPropertiesBean.getHostName() +
                " map=" + configPropertiesBean.getAdditionalHeaders().get("redelivery") +
                " obj=" + configPropertiesBean.getCredentials().getAuthMethod() +
                " litt=" + configPropertiesBean.getDefaultRecipients().get(1));

        EmployeeConverter bean = run.getBean(EmployeeConverter.class);
        System.out.println("EmployeeConverter bean=" + bean);

    }

}
