package com.booklidio.UserDir;

public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String cellphone;
    private int marketing;

    public User(int id, String firstName, String lastName, String email, String password, String cellphone,
            int marketing) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.cellphone = cellphone;
        this.marketing = marketing;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
                + ", password=" + password + ", cellphone=" + cellphone + ", marketing=" + marketing + "]";
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public void setMarketing(int marketing) {
        this.marketing = marketing;
    }

}
