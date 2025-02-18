package com.booklidio.User;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class User {
    private SimpleIntegerProperty userId;
    private SimpleStringProperty firstName;
    private SimpleStringProperty lastName;
    private SimpleStringProperty email;
    private SimpleStringProperty cellphone;
    private SimpleIntegerProperty marketing;

    public User(int id, String firstName, String lastName, String email, String cellphone, boolean marketing) {
        this.userId = new SimpleIntegerProperty(id);
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.email = new SimpleStringProperty(email);
        this.cellphone = new SimpleStringProperty(cellphone);
        this.marketing = new SimpleIntegerProperty(getMarketing(marketing));
    }

    public User(String firstName, String lastName, String email, String cellphone, boolean marketing) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.email = new SimpleStringProperty(email);
        this.cellphone = new SimpleStringProperty(cellphone);
        this.marketing = new SimpleIntegerProperty(getMarketing(marketing));
    }

    public int getUserId() {
        return userId.get();
    }

    public void setUserId(int userId) {
        this.userId.set(userId);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public String getEmail() {
        return email.get();
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getCellphone() {
        return cellphone.get();
    }

    public void setCellphone(String cellphone) {
        this.cellphone.set(cellphone);
    }

    public int getMarketing() {
        return marketing.get();
    }

    public void setMarketing(int marketing) {
        this.marketing.set(marketing);
    }

    private int getMarketing(boolean input) {
        if (input == true) {
            return 1;
        } else {
            return 0;
        }
    }
}
