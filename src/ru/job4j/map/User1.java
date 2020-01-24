package src.ru.job4j.map;
import org.junit.Test;

import java.util.Map;
import java.util.HashMap;

public class User1 {
    private String name;
    private int children;
    private String birthday;



    public User1(String name, int children, String birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }
   @Test
    public void map(){
        User1 first = new User1("Maria7744",2,"07ff1979");
        User1 second = new User1("Maria7744",2,"07ff1979");
        Map <User1,String>map = new HashMap<>();
        map.put(first,"first");
        map.put(second,"second");
        System.out.println(map.get(first));


    }




}
