package com.api_framework.booking.booking.credential;

public class CredentialsBuilder {
    private String username;
    private String password;

    public CredentialsBuilder setUsername(String username) {
        this.username = username;
        return this;
    }
    public CredentialsBuilder setPassword(String password) {
        this.password = password;
        return this;
    }
    public CredentialsPayload perform(){
        return  new CredentialsPayload(username,password);
    }
    public static CredentialsBuilder builder(){
        return new CredentialsBuilder();
    }
}
