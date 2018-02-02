package featureTriangle.triangle;

public class TriangleGeometry {

    /**
     * NOTE: If value 1 is more than value 2, then add one. Otherwise, minus one.
     *
     * @param part1
     * @param part2
     * @param part3
     * @param part4
     * @return integer type.
     */

    public static int GetMinusOrAddValue(int value1, int value2) {
        int value = 0;

        if (value1 >= value2) {
            value = 1;
        } else {
            value = -1;
        }

        return value;
    }

    public static int GetMinusOrAddValueTest(String point, int part1, int part2, int part3, int part4) {
        int value = 0;

        if (point.equalsIgnoreCase("A")) {
            if (part1 >= part3) {
                value = 1;
            } else {
                value = -1;
            }
        } else if (point.equalsIgnoreCase("B")) {
            if (part2 >= part4) {
                value = 1;
            } else {
                value = -1;
            }
        } else if (point.equalsIgnoreCase("C")) {
            int upper = part1 + part2;
            int lower = part3 + part4;

            if (upper >= lower) {
                value = 1;
            } else {
                value = -1;
            }
        }
        return value;
    }
}
