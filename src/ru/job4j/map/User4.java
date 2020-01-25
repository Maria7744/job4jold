package src.ru.job4j.map;

import java.util.HashMap;
import java.util.Map;

public class User4 {
    private String name;
    private int children;
    private String birthday;




    public  User4(String name, int children, String birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User4 user4 = (User4) o;

        if (children != user4.children) {
            return false;
        }
        if (name != null ? !name.equals(user4.name) : user4.name != null) {
            return false;
        }



        return birthday != null ? birthday.equals(user4.birthday) : user4.birthday == null;
    }



    public void map3() {
        User3 first3 = new User3("Maria7744", 2, "07ff1979");
        User3 second3 = new User3("Maria7744", 2, "07ff1979");
        Map<User3, String> map = new HashMap<>();
        map.put(first3, "first3");
        map.put(second3, "second3");
        System.out.println(map.get(first3));


    }
    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + children;
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        return result;
    }

}




