package com.bsn.configurationproperties.withConversion.custom;

import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

// We will need to implement the Converter interface, then use @ConfigurationPropertiesBinding annotation to register our custom Converter
@Component
@ConfigurationPropertiesBinding
@ConstructorBinding
@PropertySource("classpath:configPropsConversions.properties")
public class EmployeeConverter implements Converter<String, Employee> {

    @Override
    public Employee convert(String source) {
        String[] data = source.split(",");
        return new Employee(data[0], Double.parseDouble(data[1]));
    }
}
