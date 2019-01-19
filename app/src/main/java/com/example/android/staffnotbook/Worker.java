package com.example.android.staffnotbook;

public class Worker {
    private String name;
    private String lastname;
    private String phone;
    private String manager;
    private String year;

    public Worker(String name, String lastname, String phone, String year, String manager) {
        this.name = name;
        this.lastname = lastname;
        this.phone = phone;
        this.manager = manager;
        this.year = year;
    }

    public Worker() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", phone='" + phone + '\'' +
                ", manager='" + manager + '\'' +
                ", year=" + year +
                '}';
    }
}
