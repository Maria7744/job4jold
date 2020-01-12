package ru.job4j.oop;

public class DummyDic {

    public String engToRus() {
       String eng =  "Gav";
        return eng;
    }
    public static void main(String[] args) {
        DummyDic dic = new DummyDic();
        String eng = dic.engToRus();
        System.out.println(" Неизвестное слово  " + eng);
    }
}


