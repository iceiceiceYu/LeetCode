public class Solution2000 {
    public String reversePrefix(String word, char ch) {
        int idx = word.indexOf(ch);
        if (idx >= 0) {
            String former = word.substring(0, idx + 1);
            String latter = word.substring(idx + 1);
            String reverse = new StringBuilder(former).reverse().toString();
            return reverse + latter;
        } else {
            return word;
        }

//            char[] arr = word.toCharArray();
//            int left = 0, right = idx;
//            while (left < right) {
//                char temp = arr[left];
//                arr[left] = arr[right];
//                arr[right] = temp;
//                left++;
//                right--;
//            }
//            word = new String(arr);
//        }
//        return word;
    }
}
