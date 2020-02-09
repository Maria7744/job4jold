package oop;

public class DummyDic {

    public static void main(String[] args) {
        DummyDic dic = new DummyDic();
        String eng = dic.engToRus();
        System.out.println(" Неизвестное слово  " + eng);
    }

    public String engToRus() {
        String eng = "Gav";
        return eng;
    }
}


