import java.util.ArrayList;
import java.util.List;

public class Solution1078 {
    public String[] findOcurrences(String text, String first, String second) {
        String[] words = text.split(" ");
        List<String> list = new ArrayList<>();
        for (int i = 0; i < words.length - 2; i++) {
            if (words[i].equals(first) && words[i + 1].equals(second))
                list.add(words[i + 2]);
        }
        String[] ans = new String[list.size()];
        list.toArray(ans);
        return ans;
    }
}
