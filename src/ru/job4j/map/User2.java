package src.ru.job4j.map;
import java.util.Map;
import java.util.HashMap;


public class User2 {
    private String name;
    private int children;
    private String birthday;



    public User2(String name, int children, String birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }
    public void map(){
        User2 first2 = new User2("Maria7744",2,"07ff1979");
        User2 second2 = new User2("Maria7744",2,"07ff1979");
        Map<User2,String> map = new HashMap<>();
        map.put(first2,"first");
        map.put(second2,"second");
        System.out.println(map.get(first2));


    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + children;
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        return result;
    }

}

