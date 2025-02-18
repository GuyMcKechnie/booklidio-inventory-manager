package com.booklidio.User;

public class Seller extends User {

    public Seller(int id, String firstName, String lastName, String email, String cellphone, boolean marketing) {
        super(id, firstName, lastName, email, cellphone, marketing);
    }

    public Seller(String firstName, String lastName, String email, String cellphone, boolean marketing) {
        super(firstName, lastName, email, cellphone, marketing);
    }
}
