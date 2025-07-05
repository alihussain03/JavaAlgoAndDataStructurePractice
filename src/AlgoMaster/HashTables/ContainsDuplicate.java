package AlgoMaster.HashTables;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/* https://leetcode.com/problems/contains-duplicate-ii/description/ */
public class ContainsDuplicate {

  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 1, 2, 3};
    System.out.println(containsNearbyDuplicate(arr, 2));
  }

  static boolean containsNearbyDuplicate(int[] nums, int k) {
    Set<Integer> window = new HashSet<>();

    for (int i = 0; i < nums.length; i++) {
      // If the current number is already in the set, we found a duplicate within range
      if (window.contains(nums[i])) {
        return true;
      }

      // Add the current number to the set
      window.add(nums[i]);

      // Maintain the window size to be at most k
      if (window.size() > k) {
        window.remove(nums[i - k]); // Remove the element that is out of the window
      }
    }

    return false; // No duplicates found within k distance
  }

  static boolean containsNearbyDuplicate2(int[] nums, int k) {
    HashMap<Integer, Integer> mapST = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];
      if (mapST.containsKey(num) && (i - mapST.get(num) <= k)) {
        return true;
      }
      mapST.put(num, i); // always update latest index
    }
    return false;
  }
}