package com.api_framework.booking.booking;


public class BookingBuilder {
    private String firstname;
    private String lastname;
    private int totalprice;
    private boolean depositpaid;
    private BookingDates bookingdates = new BookingDates();
    private String additionalneeds;

    public static BookingBuilder builder(){
        return new BookingBuilder();
    }

    public BookingBuilder and(){
        return this;
    }

    public BookingBuilder with(){
        return this;
    }
    public BookingBuilder setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public BookingBuilder setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public BookingBuilder setTotalprice(int totalprice) {
        this.totalprice = totalprice;
        return this;
    }

    public BookingBuilder setDepositpaid(boolean depositpaid) {
        this.depositpaid = depositpaid;
        return this;
    }

    public BookingBuilder setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
        return this;
    }

    public BookingBuilder setCheckIn(String checkin){
        bookingdates.setCheckIn(checkin);
        return this;
    }

    public BookingBuilder setCheckOut(String checkout){
        bookingdates.setCheckOut(checkout);
        return this;
    }

    public Booking perform(){
        return new Booking(firstname, lastname, totalprice, depositpaid, bookingdates, additionalneeds);
    }

}
