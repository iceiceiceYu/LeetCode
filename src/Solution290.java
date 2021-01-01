import java.util.HashMap;

public class Solution290 {
    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog cat cat dog"));
        System.out.println(wordPattern("abba", "dog cat cat fish"));
        System.out.println(wordPattern("aaaa", "dog cat cat dog"));
        System.out.println(wordPattern("abba", "dog dog dog dog"));
    }

    public static boolean wordPattern(String pattern, String s) {
        if (pattern == null || s == null) {
            return false;
        }
        String[] strings = s.split(" ");
        if (pattern.length() != strings.length) {
            return false;
        }
        HashMap<Character, String> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char tmp = pattern.charAt(i);
            if (map.containsKey(tmp)) {
                if (!map.get(tmp).equals(strings[i])) {
                    return false;
                }
            } else {
                if (map.containsValue(strings[i])) {
                    return false;
                } else {
                    map.put(tmp, strings[i]);
                }
            }
        }
        return true;
    }
}
