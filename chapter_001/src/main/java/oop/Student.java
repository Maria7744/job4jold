package oop;


public class Student {

    public static void main(String[] args) {
        Student petya = new Student();
        petya.music(1);
        petya.music(1);
        petya.music(1);
        petya.song();
        petya.song();
        petya.song();
    }

    public void music(int i) {
        System.out.println("Tra tra tra");
    }

    public void song() {
        System.out.println("I believe I can fly");
    }


}
