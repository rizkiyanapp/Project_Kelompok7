/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RideUp;

/**
 *
 * @author asus pc
 */
public abstract class Person {
    private String name;
    private String email;
    private String noIdentity;
    private int birt;
    private char gender;
    private String address;
    private String number;

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNoIdentity(String noIdentity) {
        this.noIdentity = noIdentity;
    }

    public void setBirt(int birt) {
        this.birt = birt;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getNoIdentity() {
        return noIdentity;
    }

    public int getBirt() {
        return birt;
    }

    public char getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public String getNumber() {
        return number;
    }
}
