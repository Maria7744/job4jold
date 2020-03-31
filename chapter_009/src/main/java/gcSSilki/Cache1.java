package gcSSilki;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.ref.SoftReference;

public class Cache1 {
    private static final Logger Log = LoggerFactory.getLogger(Cache1.class);

    public static void main(String[] args) {
        User user = new User("test");

        SoftReference<User> softUser = new SoftReference<User>(user);
        user = null;
        System.gc();
        System.out.println(user);

        System.out.println(softUser.get());
    }

}

