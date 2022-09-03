import java.util.ArrayList;
import java.util.List;

public class Solution1656 {
    static class OrderedStream {
        private final String[] stream;
        private int ptr;

        public OrderedStream(int n) {
            stream = new String[n + 1];
            ptr = 1;
        }

        public List<String> insert(int idKey, String value) {
            stream[idKey] = value;
            List<String> res = new ArrayList<>();
            while (ptr < stream.length && stream[ptr] != null) {
                res.add(stream[ptr]);
                ptr++;
            }
            return res;
        }
    }
}
