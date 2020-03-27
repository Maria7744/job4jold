package gc;

//считает память
import java.lang.ref.SoftReference;

public class MemoryUsercount {

        public static class User {
            private final String name;

            public User(String name) {
                this.name = name;
            }

            @Override
            protected void finalize()throws Throwable {
                super.finalize();
                System.out.println(String.format("destory object user", this.name));
            }
        }


        public static void main(String[] args) {
            System.out.println("Start");
            info();
            SoftReference<User> user=new SoftReference<>(new User("test"));
            System.out.println(user.get().name);
            System.gc();
            System.out.println("finish");
            info();




        }

        public static void info() {
            int mb = 1024*1024;
            Runtime runtime = Runtime.getRuntime();
            System.out.println(String.format(" ###memory %s mB", runtime.totalMemory() / mb));
        }



    }

