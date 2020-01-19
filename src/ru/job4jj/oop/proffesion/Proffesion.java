package ru.job4jj.oop.proffesion;

public class Proffesion {

    String surname;
    String education;
    String birthday;
     String name;

    public Proffesion(String name,String surname,String education,String birthday) {
        this.name = name;
        this.surname = surname;
        this.education = education;
        this.birthday = birthday;
    }
    public String getName(){


        return name;

}}
