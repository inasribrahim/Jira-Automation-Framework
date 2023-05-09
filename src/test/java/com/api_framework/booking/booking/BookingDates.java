package com.api_framework.booking.booking;

public class BookingDates {
    private String checkin;
    private String checkout;

    public String getCheckin() {
        return checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public String setCheckIn(String checkin) {
        this.checkin = checkin.toLowerCase();
        return getCheckin();
    }

    public String setCheckOut(String checkout) {
        this.checkout = checkout.toLowerCase();
        return getCheckout();
    }

}
