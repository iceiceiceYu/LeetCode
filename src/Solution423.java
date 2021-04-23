public class Solution423 {
    public String originalDigits(String s) {
        char[] count = new char[26 + (int) 'a'];
        for (char letter : s.toCharArray()) {
            count[letter]++;
        }

        int[] out = new int[10];
        out[0] = count['z']; // letter "z" is present only in "zero"
        out[2] = count['w']; // letter "w" is present only in "two"
        out[4] = count['u']; // letter "u" is present only in "four"
        out[6] = count['x']; // letter "x" is present only in "six"
        out[8] = count['g']; // letter "g" is present only in "eight"
        out[3] = count['h'] - out[8]; // letter "h" is present only in "three" and "eight"
        out[5] = count['f'] - out[4]; // letter "f" is present only in "five" and "four"
        out[7] = count['s'] - out[6]; // letter "s" is present only in "seven" and "six"
        out[9] = count['i'] - out[5] - out[6] - out[8]; // letter "i" is present in "nine", "five", "six", and "eight"
        out[1] = count['n'] - out[7] - 2 * out[9]; // letter "n" is present in "one", "nine", and "seven"

        StringBuilder output = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < out[i]; j++) {
                output.append(i);
            }
        }
        return output.toString();
    }
}
