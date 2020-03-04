package list;

import java.util.Objects;

public class Slovo implements Comparable<Slovo> {
    //  private String mama;
    // private String amam;
    private String slovo1;

    public Slovo(String slovo1) {
        this.slovo1 = slovo1;
        //  this.mama = mama;
        //  this.amam = amam;
    }

    /*  public int  compareTo(Slovo o) {
          //boolean rslStr;
          //   mama = "Mama";
          //  amam = "Amam";
  //    }
          int rsl = new Slovo("Mama")
                  .compareTo(
                          new Slovo("Amam")
                  );
          return rsl;
      }
      //    System.out.println(rslStr);
    //  }*/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Slovo slovo = (Slovo) o;
        return
                Objects.equals(slovo1, slovo.slovo1);
    }

    @Override
    public int hashCode() {
        return Objects.hash(slovo1);
    }

    @Override
    public int compareTo(Slovo o) {
        return 0;
    }
}

