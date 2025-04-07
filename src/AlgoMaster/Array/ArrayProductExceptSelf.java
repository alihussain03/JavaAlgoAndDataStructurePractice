package AlgoMaster.Array;

import util.CollectionUtil;

/* https://leetcode.com/problems/product-of-array-except-self/ */
public class ArrayProductExceptSelf {
    public static void main(String[] args) {
        int[] numArray = {1, 2, 3, 4};
        int[] result = productExceptSelf(numArray);
        CollectionUtil.printArray(result);
    }

    static int[] productExceptSelf(int[] numArray) {
        int n = numArray.length;
        int left[] = new int[n];
        left[0] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * numArray[i - 1];
        }

        int right[] = new int[n];
        right[n - 1] = 1;
        for (int i = n - 2; i > -1; i--) {
            right[i] = right[i + 1] * numArray[i + 1];
        }

        int result[] = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = left[i] * right[i];
        }

        return result;
    }
}
