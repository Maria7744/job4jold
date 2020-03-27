package gc;
//Добиться состояния, когда виртуальная машины вызывает сборщик мусора самостоятельно. За счет ключей xmx.
public class MemoryUser {
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
     User user = new User("test");

        System.out.println(user);
        user = null;
        System.gc();
        System.out.println("finish");





    }

    public static void info() {
        int mb = 1024*1024;
        Runtime runtime = Runtime.getRuntime();
        System.out.println(String.format(" ###memory %s mB", runtime.totalMemory() / mb));
    }



}



