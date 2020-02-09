package map;


import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

class User4Test {
    //User first = new  User();
    private String name;
    private int children;
    private String birthday;


    public User4Test(String name, int children, String birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }


  /*  @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User user = (User) o;

        if (children != user.children) {
            return false;
        }
        if (name. != null ? !name.equals(user4.name) : user4.name != null) {
            return false;
        }


        return birthday != null ? birthday.equals(user4.birthday) : user4.birthday == null;
    }*/


   @Test
    public void map() {
        User first = new User("Maria7744", 2, "07ff1979");
        User second = new User("Maria7744", 2, "07ff1979");
        Map<User, String> map = new HashMap<>();
        map.put(first, "first");
        map.put(second, "second");
        System.out.println(map.get(first));


    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + children;
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        return result;
    }

}




