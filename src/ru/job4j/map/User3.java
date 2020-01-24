package src.ru.job4j.map;

import java.util.HashMap;
import java.util.Map;

public class User3 {
    private String name;
    private int children;
    private String birthday;




    public  User3(String name, int children, String birthday) {
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

        User3 user3 = (User3) o;

        if (children != user3.children) {
            return false;
        }
        if (name != null ? !name.equals(user3.name) : user3.name != null) {
            return false;
        }
        return birthday != null ? birthday.equals(user3.birthday) : user3.birthday == null;
    }

}

    public void map3() {
        User3 first3 = new User3("Maria7744", 2, "07ff1979");
        User3 second3 = new User3("Maria7744", 2, "07ff1979");
        Map<User3, String> map = new HashMap<>();
        map.put(first3, "first3");
        map.put(second3, "second3");
        System.out.println(map.get(first3));


    }
}



