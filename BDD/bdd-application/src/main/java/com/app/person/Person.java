package com.app.person;

public class Person {
    private String name;
    private int age;
    private String lastName;
    private int yearOfBirth;

    public Person() {
    }

    public Person(String name, int age, String lastName, int yearOfBirth) {
        this.name = name;
        this.age = age;
        this.lastName = lastName;
        this.yearOfBirth = yearOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }
}
