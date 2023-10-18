import java.util.ArrayList;
import java.util.List;

public class Solution1333 {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        int n = restaurants.length;
        List<int[]> filtered = new ArrayList<>();
        for (int[] restaurant : restaurants) {
            if (restaurant[3] <= maxPrice && restaurant[4] <= maxDistance && !(veganFriendly == 1 && restaurant[2] == 0)) {
                filtered.add(restaurant);
            }
        }
        filtered.sort((a, b) -> {
            if (a[1] != b[1]) {
                return b[1] - a[1];
            } else {
                return b[0] - a[0];
            }
        });
        List<Integer> res = new ArrayList<>();
        for (int[] v : filtered) {
            res.add(v[0]);
        }
        return res;
    }
}
