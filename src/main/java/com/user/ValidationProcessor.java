package com.user;

import java.lang.reflect.Field;

import com.user.Annotations.NotBlank;
import com.user.Annotations.Positive;

public class ValidationProcessor {
    public static void validate(Object obj){
        Field[] fields=obj.getClass().getDeclaredFields();

        for(Field field:fields){
            if(field.isAnnotationPresent(NotBlank.class)){
                validateNotBlankField(obj,field);
            }

            if(field.isAnnotationPresent(Positive.class)){
                validatePositiveField(obj,field);
            }
        }
    }

    public static void validateNotBlankField(Object obj,Field field){
        try {
            field.setAccessible(true);
            String value=(String) field.get(obj);
            if(value==null || value.trim().isEmpty()){
                throw new ValidationException(field.getName()+" field can not be BLANK");
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void validatePositiveField(Object obj,Field field){
        try {
            field.setAccessible(true);
            int value=field.getInt(obj);
            if(value<0){
                throw new ValidationException(field.getName()+" field can not be NEGATIVE");
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    
}
