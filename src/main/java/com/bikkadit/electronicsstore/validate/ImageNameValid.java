package com.bikkadit.electronicsstore.validate;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.PARAMETER})
@Documented
@Constraint(validatedBy =ImageNameValidator.class)

public @interface ImageNameValid {

    //error message
    String message() default "(javax.validation.constraints.NotBlank.message)";


     // represent group of information
    Class<?>[] groups () default{};


    // additional information for annotation
    Class<? extends Payload>[] payload () default {};

}
