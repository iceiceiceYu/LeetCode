public class Solution1832 {
    public boolean checkIfPangram(String sentence) {
        int state = 0;
        char[] chars = sentence.toCharArray();
        for (char c : chars) {
            state |= 1 << (c - 'a');
        }
        return state == (1 << 26) - 1;
    }
}
