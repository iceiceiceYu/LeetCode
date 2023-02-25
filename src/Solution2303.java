public class Solution2303 {
    public double calculateTax(int[][] brackets, int income) {
        double totalTax = 0;
        int lower = 0;
        for (int[] bracket : brackets) {
            int upper = bracket[0], percent = bracket[1];
            int tax = (Math.min(income, upper) - lower) * percent;
            totalTax += tax;
            if (income <= upper) {
                break;
            }
            lower = upper;
        }
        return (double) totalTax / 100.0;
    }
}
