package com.user;

public class Main {
    public static void main(String[] args) {
        User user=new User();
        user.setUsername("   ");
        user.setPassword("Password123");
        user.setPin(123);
        System.out.println("============ validating for user 1 ==========");
        try {
            ValidationProcessor.validate(user);
            System.out.println("Validation passed");
        } catch (ValidationException e) {
            System.out.println("Validation failed "+e.getMessage());
        }

        User user2=new User();
        user2.setUsername("Ritika");
        user2.setPassword("Password123");
        user2.setPin(-123);
        System.out.println("=========== validating for user 2 ===========");
        try {
            ValidationProcessor.validate(user2);
            System.out.println("Validation passed");
        } catch (ValidationException e) {
            System.out.println("Validation failed "+e.getMessage());
        }

        User user3=new User();
        user3.setUsername("Ritika");
        user3.setPassword("Password123");
        user3.setPin(123);
        System.out.println("================= validating for user 3 ===============");
        try {
            ValidationProcessor.validate(user3);
            System.out.println("Validation passed");
        } catch (ValidationException e) {
            System.out.println("Validation failed "+e.getMessage());
        }
    }
}