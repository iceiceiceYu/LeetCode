public class Solution925 {
    public static void main(String[] args) {
        System.out.println(isLongPressedName("alex", "aaleex"));
        System.out.println(isLongPressedName("saeed", "ssaaedd"));
        System.out.println(isLongPressedName("leelee", "lleeelee"));
        System.out.println(isLongPressedName("laiden", "laiden"));
    }

    public static boolean isLongPressedName(String name, String typed) {
        int i = 0, j = 0;
        int nameLength = name.length();
        int typedLength = typed.length();
        while (j < typedLength) {
            if (i < nameLength && name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
                j++;
            } else {
                return false;
            }
        }
        return i == nameLength;
    }
}
