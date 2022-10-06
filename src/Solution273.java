public class Solution273 {
    String[] singles = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    String[] teens = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] thousands = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 3, unit = 1000000000; i >= 0; i--, unit /= 1000) {
            int curNum = num / unit;
            if (curNum != 0) {
                num -= curNum * unit;
                sb.append(toEnglish(curNum)).append(thousands[i]).append(" ");
            }
        }
        return sb.toString().trim();
    }

    private String toEnglish(int num) {
        StringBuilder curr = new StringBuilder();
        int hundred = num / 100;
        num %= 100;
        if (hundred != 0) {
            curr.append(singles[hundred]).append(" Hundred ");
        }
        int ten = num / 10;
        if (ten >= 2) {
            curr.append(tens[ten]).append(" ");
            num %= 10;
        }
        if (num > 0 && num < 10) {
            curr.append(singles[num]).append(" ");
        } else if (num >= 10) {
            curr.append(teens[num - 10]).append(" ");
        }
        return curr.toString();
    }
}
