package com.booklidio.User;

public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String cellphone;
    private int marketing;

    public User(int id, String firstName, String lastName, String email, String cellphone, boolean marketing) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.cellphone = cellphone;
        this.marketing = getMarketing(marketing);
    }

    public User(String firstName, String lastName, String email, String cellphone, boolean marketing) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.cellphone = cellphone;
        this.marketing = getMarketing(marketing);
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
                + ", cellphone=" + cellphone + ", marketing=" + marketing + "]";
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public int getMarketing() {
        return marketing;
    }

    private int getMarketing(boolean input) {
        if (input == true) {
            return 1;
        } else {
            return 0;
        }
    }

    public void setMarketing(int marketing) {
        this.marketing = marketing;
    }

    public String getFullName() {
        return getFirstName() + " " + getLastName();
    }

}
