import java.util.*;

public class Solution49 {
    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] counts = new int[26];
            int length = str.length();
            for (int i = 0; i < length; i++) {
                counts[str.charAt(i) - 'a']++;
            }
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < 26; i++) {
                if (counts[i] != 0) {
                    sb.append((char) ('a' + i));
                    sb.append(counts[i]);
                }
            }
            String key = sb.toString();
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
//        Map<String, List<String>> map = new HashMap<>();
//        for (String str : strs) {
//            char[] array = str.toCharArray();
//            Arrays.sort(array);
//            String key = new String(array);
//            List<String> list = map.getOrDefault(key, new ArrayList<>());
//            list.add(str);
//            map.put(key, list);
//        }
//        return new ArrayList<>(map.values());
    }
}
