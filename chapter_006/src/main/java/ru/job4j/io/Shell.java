package ru.job4j.io;

import java.util.ArrayList;
import java.util.List;

public class Shell {

    List<String> rootPath = new ArrayList<>();

    public void cd(String path) {
        String[] paths = path.split("/");
        for (String p : paths) {
            if(rootPath.size() > 0) {
                if (p.equals("..")) {
                    rootPath.remove(rootPath.size() - 1);
                } else {
                    rootPath.add(p);
                }
            } else {
                if (!p.equals("..")) {
                    rootPath.add(p);
                }
            }
        }
    }

    public String pwd() {
        StringBuilder result = new StringBuilder();
        if(rootPath.size() > 0) {
            for (String s : rootPath) {
                result.append(String.format("/%s", s));
            }
        } else {
            result.append("/");
        }
        return result.toString();
    }
}
