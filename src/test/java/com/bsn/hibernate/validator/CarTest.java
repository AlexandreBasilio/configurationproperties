package com.bsn.hibernate.validator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private static Validator validator;

    @BeforeAll
    public static void setup () {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void manufacteurIsNull() {
        Car car = new Car(null, "DD-AB-123", 4);

        Set<ConstraintViolation<Car>> constraintViolations = validator.validate(car);

        assertThat(2).isEqualTo(constraintViolations.size());
        assertThat("ne peut pas être nul").isEqualTo(constraintViolations.iterator().next().getMessage());
    }

    @Test
    public void licensePlateTooShort() {
        Car car = new Car( "Morris", "D", 4 );

        Set<ConstraintViolation<Car>> constraintViolations = validator.validate( car );

        assertThat( 1).isEqualTo(constraintViolations.size());
        assertThat("la taille doit être comprise entre 2 et 14").isEqualTo(constraintViolations.iterator().next().getMessage());
    }

    @Test
    public void seatCountTooLow() {
        Car car = new Car( "Morris", "DD-AB-123", 1 );

        Set<ConstraintViolation<Car>> constraintViolations = validator.validate( car );

        assertThat( 1).isEqualTo(constraintViolations.size());
        assertThat("doit être au minimum égal à 2").isEqualTo(constraintViolations.iterator().next().getMessage());
    }

    @Test
    public void carIsValid() {
        Car car = new Car( "Morris", "DD-AB-123", 2 );

        Set<ConstraintViolation<Car>> constraintViolations = validator.validate( car );

        assertThat( 0).isEqualTo(constraintViolations.size() );
    }

}