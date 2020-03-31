package gcSSilki;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class User {
    private static final Logger Log = LoggerFactory.getLogger(User.class);
    public String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize");
    }

    public String toString() {
        return "User{" + "name ='" + name + '\'' + '}';
    }
}
