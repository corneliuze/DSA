package Arrays;

public class Main {
    public static void main(String[] args) {
        Array a = new Array();
        int p = a.addArray(new int[]{1, 2, 3});

        int q = a.hourGlassSum(new int[][]{{-9, -9, -9, 1, 1, 1}, {0, -9, 0, 4, 3, 2},
                {-9, -9, -9, 1, 2, 3}, {0, 0, 8, 6, 6, 0}, {0, 0, 0, -2, 0, 0}, {0, 0, 1, 2, 4, 0}});

        System.out.println("result is %s, p" + q);
    }

}
