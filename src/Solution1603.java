public class Solution1603 {
    class ParkingSystem {
        int big, medium, small;

        public ParkingSystem(int big, int medium, int small) {
            this.big = big;
            this.medium = medium;
            this.small = small;
        }

        public boolean addCar(int carType) {
            if (carType == 1) {
                if (big > 0) {
                    big--;
                    return true;
                }
            } else if (carType == 2) {
                if (medium > 0) {
                    medium--;
                    return true;
                }
            } else if (carType == 3) {
                if (small > 0) {
                    small--;
                    return true;
                }
            }
            return false;
        }
    }

//    class ParkingSystem {
//        int counts;
//
//        public ParkingSystem(int big, int medium, int small) {
//            counts = (small << 20) | (medium << 10) | big;
//        }
//
//        public boolean addCar(int carType) {
//            int bit = ((carType - 1) * 10);
//            if (((counts >> bit) & 0b1111111111) <= 0) {
//                return false;
//            } else {
//                counts -= 1 << bit;
//                return true;
//            }
//        }
//    }

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */
}
