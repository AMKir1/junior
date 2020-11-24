package ru.job4j.gc.cache;
/*
 * Chapter_008. Garbage Collection [#147]
 * Task: 4.1 Реализации кеша на SoftReference [#1592] v2
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */
import java.lang.ref.SoftReference;
import java.util.Map;

public class CacheTextFiles extends Cache<String, SoftReference<Content>> {

    private Map<String, SoftReference<Content>> cache;
    CacheFileReader fr = new CacheFileReader();

    public CacheTextFiles(Map<String, SoftReference<Content>> cache) {
        super(cache);
        this.cache = super.getCache();
    }

    public boolean containsKey(String key) {
        return this.cache.containsKey(key);
    }

    public Content get(String key) {
        return this.cache.get(key).get();
    }

    public Content put(String key, Content content) {
        this.cache.put(key, new SoftReference<>(content));
        return content;
    }

    public int size() {
        return this.cache.size();
    }

    public String getDataFromCache(String filename) {
        StringBuilder builder = new StringBuilder();
        if (this.containsKey(filename) && this.get(filename) != null) {
            this.get(filename).getText().forEach(builder::append);
        } else {
            this.put(filename, new Content(fr.getFileContent(filename))).getText().forEach(builder::append);
        }
        return builder.toString();
    }
}