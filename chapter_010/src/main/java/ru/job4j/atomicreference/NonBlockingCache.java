package ru.job4j.atomicreference;
/*
 * Chapter_010. 1. Multithreading[171#453877].
 * Task: 1. Неблокирующий кеш[4741#453912].
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com).
 * @version 2.
 */
import java.util.concurrent.ConcurrentHashMap;

public class NonBlockingCache {

    private final ConcurrentHashMap<Integer, Base> cache = new ConcurrentHashMap<>();

    public void add(Base model) {
        cache.putIfAbsent(model.getId(), model);
    }

    public boolean update(Base model) {
        if (this.cache.get(model.getId()).getVersion() == model.getVersion()) {
            model.setVersion(model.getVersion() + 1);
            return this.cache.computeIfPresent(model.getId(), (key, val) -> val = model) != null;
        }
        throw new OptimisticException("Failed to update data for : " + model.toString());
    }

    public boolean delete(Base model) {
        return this.cache.remove(model.getId(), model);
    }

    @Override
    public String toString() {
        return "NonBlockingCache{"
                + "cache=" + cache
                + '}';
    }

    static class Base {
        private int id;
        private int version;

        public Base(int id, int version) {
            this.id = id;
            this.version = version;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public void setVersion(int version) {
            this.version = version;
        }

        public int getVersion() {
            return version;
        }

        @Override
        public String toString() {
            return "Base{"
                    + "id=" + id
                    + ", version=" + version
                    + '}';
        }
    }
}
