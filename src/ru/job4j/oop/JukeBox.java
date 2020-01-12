package ru.job4j.oop;

public class JukeBox {
    public  static void music(int position) {
        if (position == 1) {
            System.out.println("Пусть бегут неуклюже");

        } else if (2 == position) {
            System.out.println("Спокойной ночи.");
        } else {

            System.out.println("Песня не найдена");
        }

    }

    public static void main(String[] args) {
        JukeBox petya = new JukeBox();
       // int position;
        petya.music( 1);


    }
}
