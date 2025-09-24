package br.senac.tads.dsw.dados_pessoais;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UserNameUnicoValidator.class)
public @interface UserNameUnico {

    String message() default "Username já cadastrado";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
