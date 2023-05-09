package com.api_framework.booking.generate_data;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

public final class GenerateData {
private GenerateData(){}
    public static String getFirstName(){
        return String.valueOf(new Faker().name().firstName());
    }

    public static String getLastName(){
        return String.valueOf(new Faker().name().lastName());
    }

    public static Boolean getDepositPaid(){
        return (new Faker().bool()).bool();
    }

    public static Integer getTotalPrice(){
        return new Faker().number().numberBetween(1,1000);
    }
    public static String getCheckInDate(){
        return new SimpleDateFormat("YYYY-MM-dd").format(new Faker().date().past(23, TimeUnit.DAYS));
    }

    public static String getCheckOutDate(){
        return new SimpleDateFormat("YYYY-MM-dd").format(new Faker().date().future(5, TimeUnit.DAYS));
    }

    public static String getAdditionalNeeds(){
        return new Faker().food().spice();
    }
}
