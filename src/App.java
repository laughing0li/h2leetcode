import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import sort.BubbleSort;
import sort.SelectSort;

public class App {
    public static void main(String[] args) throws Exception {
        SelectSort sort = new SelectSort();
        int[] nums = { 3, -1, 4, 10, -5, 22, -6 };
        int minIndex = 0;
        int min = nums[minIndex];
        for (int i = 0; i < nums.length; i++) {
            minIndex = i;
            min = nums[minIndex];
            for (int j = i; j < nums.length; j++) {
                if (min > nums[j]) {
                    minIndex = j;
                    min = nums[j];
                }
            }
            nums[minIndex] = nums[i];
            nums[i] = min;
        }

        System.out.println(Arrays.toString(nums));
    }

}
