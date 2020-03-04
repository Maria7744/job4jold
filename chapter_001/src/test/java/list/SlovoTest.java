package list;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SlovoTest {


    @Test
    public void whenAsc() {
        ArrayList<Slovo> slovo = new ArrayList<>();
        slovo.add(new Slovo("Mama"));
        slovo.add(new Slovo("Amam"));
        Iterator<Slovo> it = slovo.iterator();
        assertThat(it.next(), is(new Slovo("Mama")));
        assertThat(it.next(), is(new Slovo("Amam")));
    }

    @Test
    public void whenCompareMamVithAmam() {
        int rsl = new Slovo("Mama")
                .compareTo(
                        new Slovo("Amam")
                );
        assertThat(rsl, greaterThan(0));
    }
}
