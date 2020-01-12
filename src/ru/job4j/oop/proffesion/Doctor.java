package ru.job4j.oop.proffesion;

public class Doctor extends Proffesion {
    String categoria;
    String reiting;
    String rentgen;
    public Doctor(String name, String surname, String education, String birthday,String categoria,String reiting) {
        super(name, surname, education, birthday);
        this.categoria = categoria;
        this.reiting = reiting;


    }
    public class Diagnose {
        Diagnose diagnose = new Diagnose();

        public Diagnose heal(Pacient pacient) {
            return diagnose;
        }

        public class Pacient {
            Pacient pacient = new Pacient();

            public void sayIll() {
                String complaints = null;
                System.out.println("I am ill." + complaints);
            }

            public String getObsledovania(String rentgen) {


                return rentgen;

            }
        }
    }
}








