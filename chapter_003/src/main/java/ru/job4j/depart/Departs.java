package ru.job4j.depart;
import java.util.*;
/**
 * Chapter_003. Departs.
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */
public class Departs {
    /**
     * Воостановление Департаментов
     * @param departs - перепутанные и неполные каталоги департаментов
     * @return result - восстановленные департаменты
     */
    private String[] recoveryDep(String[] departs) {
        Set<String> depSet = new TreeSet<>();
        depSet.addAll((Arrays.asList(departs)));
        for (String depart : departs) {
            ArrayList<Integer> posns = new ArrayList<>();
            for (int pos = 0; pos < depart.length(); pos++) {
                if (depart.charAt(pos) == '\\') {
                    posns.add(pos);
                }
            }
            for (Integer pos : posns) {
                char[] departchar = depart.toCharArray();
                String str = new String(departchar, 0, pos);
                depSet.add(str);
            }
        }
        return depSet.toArray(new String[depSet.size()]);
    }
    /**
     * Сортировка по возрастанию
     * @param departs - восстановленные департаменты
     * @return result - Отсортерованные восстановленные департаменты
     */
    public String[] sortUp(String[] departs) {
        String[] sort = this.recoveryDep(departs);
        Set<String> sortSet = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        sortSet.addAll(Arrays.asList(sort));
        String[] result = new String[sortSet.size()];
        return sortSet.toArray(result);
    }
    /**
     * Сортировка по убыванию
     * @param departs - восстановленные департаменты
     * @return result - Отсортерованные восстановленные департаменты
     */
    public String[] sortDown(String[] departs) {
        String[] sort = this.recoveryDep(departs);
        Set<String> sortSet = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int min = Math.min(o1.length(), o2.length());
                for (int i = 0; i < min; i++) {
                    Character left = o1.charAt(i);
                    Character right = o2.charAt(i);
                    if (right.compareTo(left) != 0) {
                        return right - left;
                    }
                }
                return o1.length() - o2.length();
            }
        });
        sortSet.addAll(Arrays.asList(sort));
        String[] result = new String[sortSet.size()];
        return sortSet.toArray(result);
    }
}

