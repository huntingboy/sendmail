package com.nomad.domain;

public class User {
    private static int id = 1;
    private String username;
    private char sex;
    private int age;

    public User() {
    }

    public User(String username, char sex, int age) {
        this.username = username;
        this.sex = sex;
        this.age = age;
        id++;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
