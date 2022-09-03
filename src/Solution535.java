import java.util.HashMap;
import java.util.Map;

public class Solution535 {
    static class Codec {
        private final Map<Integer, String> database = new HashMap<>();
        private int id;

        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            id++;
            database.put(id, longUrl);
            return "http://tinyurl.com/" + id;
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            int p = shortUrl.lastIndexOf('/') + 1;
            int key = Integer.parseInt(shortUrl.substring(p));
            return database.get(key);
        }
    }
}
