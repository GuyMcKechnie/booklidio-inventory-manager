package com.booklidio.User;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Seller {
    private SimpleIntegerProperty user_id;
    private SimpleStringProperty first_name;

    public Seller(int userId, String firstName) {
        this.user_id = new SimpleIntegerProperty(userId);
        this.first_name = new SimpleStringProperty(firstName);
    }

    public int getUser_id() {
        return user_id.get();
    }

    public void setUser_id(int userId) {
        this.user_id.set(userId);
    }

    public String getFirst_name() {
        return first_name.get();
    }

    public void setFirst_name(String firstName) {
        this.first_name.set(firstName);
    }

}
