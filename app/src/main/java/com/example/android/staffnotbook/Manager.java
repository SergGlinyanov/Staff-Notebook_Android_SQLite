package com.example.android.staffnotbook;

public class Manager {

    private String name;
    private String lastname;
    private String phone;
    private String department;
    private String year;

    public Manager(String name, String lastname, String phone, String year, String department) {
        this.name = name;
        this.lastname = lastname;
        this.phone = phone;
        this.department = department;
        this.year = year;
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", phone='" + phone + '\'' +
                ", department='" + department + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}