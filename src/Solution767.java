public class Solution767 {
    public static void main(String[] args) {
        System.out.println(reorganizeString("aab"));
        System.out.println(reorganizeString("aaab"));
    }

    public static String reorganizeString(String S) {
        if (S.length() < 2) {
            return S;
        }
        int[] counts = new int[26];
        int maxCount = 0;
        int length = S.length();
        for (int i = 0; i < length; i++) {
            char c = S.charAt(i);
            counts[c - 'a']++;
            maxCount = Math.max(maxCount, counts[c - 'a']);
        }
        if (maxCount > (length + 1) / 2) {
            return "";
        }
        char[] reorganizeArray = new char[length];
        int evenIndex = 0, oddIndex = 1;
        int halfLength = length / 2;
        for (int i = 0; i < 26; i++) {
            char c = (char) ('a' + i);
            while (counts[i] > 0 && counts[i] <= halfLength && oddIndex < length) {
                reorganizeArray[oddIndex] = c;
                counts[i]--;
                oddIndex += 2;
            }
            while (counts[i] > 0) {
                reorganizeArray[evenIndex] = c;
                counts[i]--;
                evenIndex += 2;
            }
        }
        return new String(reorganizeArray);
//        if (S.length() < 2) {
//            return S;
//        }
//        int[] counts = new int[26];
//        int maxCount = 0;
//        int length = S.length();
//        for (int i = 0; i < length; i++) {
//            char c = S.charAt(i);
//            counts[c - 'a']++;
//            maxCount = Math.max(maxCount, counts[c - 'a']);
//        }
//        if (maxCount > (length + 1) / 2) {
//            return "";
//        }
//        PriorityQueue<Character> queue = new PriorityQueue<>((letter1, letter2) -> counts[letter2 - 'a'] - counts[letter1 - 'a']);
//        for (char c = 'a'; c <= 'z'; c++) {
//            if (counts[c - 'a'] > 0) {
//                queue.offer(c);
//            }
//        }
//        StringBuffer sb = new StringBuffer();
//        while (queue.size() > 1) {
//            char letter1 = queue.poll();
//            char letter2 = queue.poll();
//            sb.append(letter1);
//            sb.append(letter2);
//            int index1 = letter1 - 'a', index2 = letter2 - 'a';
//            counts[index1]--;
//            counts[index2]--;
//            if (counts[index1] > 0) {
//                queue.offer(letter1);
//            }
//            if (counts[index2] > 0) {
//                queue.offer(letter2);
//            }
//        }
//        if (queue.size() > 0) {
//            sb.append(queue.poll());
//        }
//        return sb.toString();
    }
}
