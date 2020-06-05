package ru.job4j.collectioin;
/*
 * Chapter_005. Collections. Pro.[#146]
 * Task: 2. Статистику по коллекции. [#45889]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 4
 */
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Analize {
    public Info diff(List<User> previous, List<User> current) {

        Map<Integer, String> previoustMap = previous.stream().collect(Collectors.toMap(u -> u.id, u -> u.name));

        Info info = new Info(0, 0, 0);

        for (User u : current) {
            String res = previoustMap.remove(u.id);
            if (res == null) {
                info.added++;
            }

            if ( res != null && res != u.name) {
                info.changed++;
            }
        }

        info.deleted = previoustMap.size();

        return info;
    }

    /*   public Info diff(List<User> previous, List<User> current) {

        Map<Integer, String> currentMap = current.stream().collect(Collectors.toMap(u -> u.id, u -> u.name));

        Info info = new Info(0, 0, 0);
        int diffSize = previous.size() - current.size();
        int noAddDel = 0;
        info.added = diffSize < 0 ? Math.abs(diffSize) : 0;
        info.deleted = diffSize > 0 ? diffSize : 0;


        //        for (User up : previous) {
        //            for (User uc : current) {
        //                if (up.equals(uc)) {
        //                    noAddDel++;
        //                } else {
        //                    if (up.id == uc.id && !up.name.equals(uc.name)) {
        //                        noAddDel++;
        //                        info.changed++;
        //                    }
        //                }
        //            }
        //        }


        for (User up : previous) {
            if (currentMap.containsKey(up.id)) {
                if (!currentMap.get(up.id).equals(up.name)) {
                    info.changed++;
                }
                noAddDel++;
            }
        }

        if (noAddDel < previous.size()) {
            info.deleted = Math.abs(noAddDel - previous.size());
            if (diffSize == 0 || info.added != 0) {
                info.added += info.deleted;
            }
        }

        return info;
    }*/

    public static class User {
        int id;
        String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{"
                    + "id=" + id
                    + ", name='" + name + '\''
                    + '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            User user = (User) o;
            return id == user.id
                    && Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }
    }

    public static class Info {

        int added;
        int changed;

        int deleted;

        public Info(int added, int changed, int deleted) {
            this.added = added;
            this.changed = changed;
            this.deleted = deleted;
        }

        @Override
        public String toString() {
            return "Info{"
                    + "added=" + added
                    + ", changed=" + changed
                    + ", deleted=" + deleted
                    + '}';
        }
    }
}
