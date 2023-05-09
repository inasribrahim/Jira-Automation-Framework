package com.api_framework.booking.tests;

import com.api_framework.booking.booking.Booking;
import com.api_framework.booking.booking.BookingBuilder;
import com.api_framework.booking.booking.BookingDates;
import com.api_framework.booking.common.BaseApi;
import com.api_framework.booking.endpoints.APIEndPoint;
import com.api_framework.booking.booking.credential.Token;
import com.api_framework.booking.generate_data.GenerateData;
import com.api_framework.booking.reports.ExtentManager;
import com.api_framework.booking.reports.ExtentTestManager;
import com.api_framework.booking.utility.HttpStatus;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import io.restassured.http.ContentType;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;


public class Tests {

    private static String tokenKey ;
    @BeforeTest
    public static void setTokenKey() throws IOException {
        tokenKey = Token.getTokenKey();
        System.out.println(tokenKey);
    }

    @Test
    public void verifyThatTheUserAbleToAddNewUserInBookingThroughAPI(Method method){
        Booking booking = BookingBuilder.builder()
                                .setFirstname(GenerateData.getFirstName())
                                .setLastname(GenerateData.getLastName())
                                .and()
                                .setTotalprice(GenerateData.getTotalPrice())
                                .and()
                                .setCheckIn(new BookingDates().setCheckIn(GenerateData.getCheckInDate()))
                                .setCheckOut(new BookingDates().setCheckOut(GenerateData.getCheckOutDate()))
                                .and()
                                .setDepositpaid(true)
                                .and()
                                .setAdditionalneeds(GenerateData.getAdditionalNeeds())
                                .with()
                                .perform();

        BaseApi.init()
                .path(APIEndPoint.BOOKING)
                .contentType(ContentType.JSON)
                .body(booking)
                .expectedStatusCode(HttpStatus.OK)
                .expectedResponseContentType(ContentType.JSON)
                .post();
    }

    @Test
    public void verifyThatTheUserNotAddCheckInDateInBookingThroughAPI(Method method){
//        ExtentTestManager.startTest(method.getName(),insertSpaceAfterUpperCaseAndThenConvertItToLowerCase(method.getName()) );

        Booking booking = BookingBuilder.builder()
                .setFirstname(GenerateData.getFirstName())
                .setLastname(GenerateData.getLastName())
                .and()
                .setTotalprice(GenerateData.getTotalPrice())
                .and()
                .setCheckOut(new BookingDates().setCheckOut(GenerateData.getCheckOutDate()))
                .and()
                .setDepositpaid(true)
                .and()
                .setAdditionalneeds(GenerateData.getAdditionalNeeds())
                .with()
                .perform();

        BaseApi.init()
                .path(APIEndPoint.BOOKING)
                .contentType(ContentType.JSON)
                .body(booking)
                .expectedStatusCode(HttpStatus.INTERNAL_SERVER_ERROR)
                .expectedResponseContentType(ContentType.JSON)
                .post();
    }

    @Test
    public void verifyThatTheUserNotAddCheckOutDateInBookingThroughAPI(Method method){
//        ExtentTestManager.startTest(method.getName(),insertSpaceAfterUpperCaseAndThenConvertItToLowerCase(method.getName()) );

        Booking booking = BookingBuilder.builder()
                .setFirstname(GenerateData.getFirstName())
                .setLastname(GenerateData.getLastName())
                .and()
                .setTotalprice(GenerateData.getTotalPrice())
                .and()
                .setCheckIn(new BookingDates().setCheckIn(GenerateData.getCheckInDate()))
                .and()
                .setDepositpaid(true)
                .and()
                .setAdditionalneeds(GenerateData.getAdditionalNeeds())
                .with()
                .perform();

        BaseApi.init()
                .path(APIEndPoint.BOOKING)
                .contentType(ContentType.JSON)
                .body(booking)
                .expectedStatusCode(HttpStatus.INTERNAL_SERVER_ERROR)
                .expectedResponseContentType(ContentType.JSON)
                .post();
    }

    @Test
    public void verifyThatTheUserMakeABookingWithXMLHeaderInBookingThroughAPI(Method method){
//        ExtentTestManager.startTest(method.getName(),insertSpaceAfterUpperCaseAndThenConvertItToLowerCase(method.getName()) );

        Booking booking = BookingBuilder.builder()
                .setFirstname(GenerateData.getFirstName())
                .setLastname(GenerateData.getLastName())
                .and()
                .setTotalprice(GenerateData.getTotalPrice())
                .and()
                .setCheckIn(new BookingDates().setCheckIn(GenerateData.getCheckInDate()))
                .setCheckOut(new BookingDates().setCheckOut(GenerateData.getCheckOutDate()))
                .and()
                .setDepositpaid(true)
                .and()
                .setAdditionalneeds(GenerateData.getAdditionalNeeds())
                .with()
                .perform();

        BaseApi.init()
                .path(APIEndPoint.BOOKING)
                .contentType(ContentType.XML)
                .body(booking)
                .expectedStatusCode(HttpStatus.OK)
                .expectedResponseContentType(ContentType.JSON)
                .post();
    }

    @Test
    public void verifyThatTheUserCanModifyYourFirstNameInBookingThroughAPI(Method method){
//        ExtentTestManager.startTest("Happy Scenario",insertSpaceAfterUpperCaseAndThenConvertItToLowerCase(method.getName()) );

        Booking booking = BookingBuilder.builder()
                .setFirstname("ibrahimTest")
                .setLastname("NasrTest")
                .and()
                .setTotalprice(GenerateData.getTotalPrice())
                .and()
                .setCheckIn(new BookingDates().setCheckIn(GenerateData.getCheckInDate()))
                .setCheckOut(new BookingDates().setCheckOut(GenerateData.getCheckOutDate()))
                .and()
                .setDepositpaid(true)
                .and()
                .setAdditionalneeds(GenerateData.getAdditionalNeeds())
                .with()
                .perform();

        String userId = "1";
        BaseApi restInstance =
                BaseApi.init()
                        .path(APIEndPoint.BOOKING_ID+userId)
                        .contentType(ContentType.JSON)
                        .header("Cookie", "token=" +tokenKey)
                        .body(booking)
                        .expectedStatusCode(HttpStatus.OK)
                        .expectedResponseContentType(ContentType.JSON)
                        .put();
    }

    @Test
    public void verifyThatTheUserCanNotDeleteUserNotFoundByUserByIDInBookingThroughAPI(Method method){
//        ExtentTestManager.startTest(method.getName(), insertSpaceAfterUpperCaseAndThenConvertItToLowerCase(method.getName()) );

        String userId = "1";
        BaseApi restInstance =
                BaseApi.init()
                        .path(APIEndPoint.BOOKING_ID+userId)
                        .contentType(ContentType.JSON)
                        .header("Cookie", "token=" +tokenKey)
                        .expectedStatusCode(HttpStatus.METHOD_NOT_ALLOWED)
                        .expectedResponseContentType(ContentType.TEXT)
                        .delete();
    }

    @Test
    public void verifyThatTheUserCanDeleteUserExistedByUserByIDInBookingThroughAPI(Method method){
//        ExtentTestManager.startTest(method.getName(),insertSpaceAfterUpperCaseAndThenConvertItToLowerCase(method.getName()) );
        String userId = "1";
        BaseApi restInstance =
                BaseApi.init()
                        .path(APIEndPoint.BOOKING_ID+userId)
                        .contentType(ContentType.JSON)
                        .header("Cookie", "token=" +tokenKey)
                        .expectedStatusCode(HttpStatus.CREATED)
                        .expectedResponseContentType(ContentType.JSON)
                        .delete();
    }

    private String insertSpaceAfterUpperCaseAndThenConvertItToLowerCase(String str){
        return str.replaceAll("(\\p{Ll})(\\p{Lu})","$1 $2").toLowerCase();
    }

    @AfterSuite
    public void flushReport(){
        ExtentManager.getInstance().flush();
    }

    @AfterMethod
    public void getResult(ITestResult result){
        if(result.getStatus() ==ITestResult.SUCCESS){
            ExtentTestManager.getTest().log(Status.PASS, MarkupHelper.createLabel(result.getTestName(), ExtentColor.GREEN));
        } else if (result.getStatus() ==ITestResult.FAILURE) {
            ExtentTestManager.getTest().log(Status.FAIL, MarkupHelper.createLabel(result.getTestName(), ExtentColor.RED));
        } else if (result.getStatus() ==ITestResult.SKIP) {
            ExtentTestManager.getTest().log(Status.SKIP, MarkupHelper.createLabel(result.getTestName(), ExtentColor.INDIGO));
        }
    }
    @BeforeMethod
    public void beforeTest(Method method){
        ExtentTestManager.startTest(method.getName(),insertSpaceAfterUpperCaseAndThenConvertItToLowerCase(method.getName()) );
    }
}
