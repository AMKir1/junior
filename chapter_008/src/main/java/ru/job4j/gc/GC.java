package ru.job4j.gc;

public class GC {

    private static int[] usedMemory = new int[4];

    public static class User {
        private String name;

        User(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{"
                    + "name='" + name
                    + '\'' + '}';
        }

        @Override
        protected void finalize() throws Throwable {
            super.finalize();
            System.out.println("Start finalaze User");
        }
    }

    public static class UserEmpty {

        UserEmpty() {
        }

        @Override
        public String toString() {
            return "UserEmpty{}";
        }

        @Override
        protected void finalize() throws Throwable {
            super.finalize();
            System.out.println("Start finalaze UserEmpty");
        }
    }

    public static void main(String[] args) {
        info(0);

        User user2 = new User("test2");
        System.out.println(user2);
        info(1);
        System.out.println("Object User2 Used Memory: " + (usedMemory[1] - usedMemory[0]) + "kb" + System.lineSeparator());

        UserEmpty user1 = new UserEmpty(); // header: 12 + ref: 8 + String: 5 + 7 = 32 byte
        System.out.println(user1);
        info(2);
        System.out.println("Object UserEmpty Used Memory: " + (usedMemory[2] - usedMemory[1]) + "kb" + System.lineSeparator());

        User user3 = new User("test3");
        user3 = null;
        System.out.println(user3);
        info(3);
        System.out.println("Object User Used3 Memory: " + (usedMemory[3] - usedMemory[2]) + "kb" + System.lineSeparator());

    }

    public static void info(int i) {
        int kb = 1024;
        Runtime rt = Runtime.getRuntime();
        usedMemory[i] = (int) (rt.totalMemory() - rt.freeMemory()) / kb;
        System.out.println("####### HEAP utilization statistic [MB] #######");
        System.out.println("Used Memory: " + (rt.totalMemory() - rt.freeMemory()) / kb + "kb");
        System.out.println("Total Memory: " + rt.totalMemory() / kb + "kb");
        System.out.println("Max Memory: " + rt.maxMemory() / kb + "kb" + System.lineSeparator());
    }

}
