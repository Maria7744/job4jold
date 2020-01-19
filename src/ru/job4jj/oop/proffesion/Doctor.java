package ru.job4jj.oop.proffesion;

public class Doctor extends Proffesion {

    String rentgen;
    public Doctor(String name, String surname, String education, String birthday) {
        super(name, surname, education, birthday);



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








