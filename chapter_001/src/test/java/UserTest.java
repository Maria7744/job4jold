import map.User;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class UserTest {


   /* private String name;
    private int children;
    private String birthday;


    public UserTest(String name, int children, String birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }*/

    @Test
    public void map() {
        User first = new User("Maria77", 2, "07ff19ХХ");
        User second = new User("Maria77", 2, "07ff19ХХ");
        Map<User, String> map = new HashMap<>();
        map.put(first, "first");
        map.put(second, "second");
        System.out.println(map.get(first));


    }
   /* @Override
    public int hashCode() {

        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + children;
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        return result;
    }*/

}





