package Grokking.Arrray;

public class LargestAlltitude {

  public static void main(String[] args) {
    int[] nums = {7, 1, 4};
    System.out.println("----------\nLargest Altitude is : " + largestAltitude(nums));
  }


  static int largestAltitude(int[] gain) {
    int currentAltitude = 0; // To store the current altitude during iteration
    int maxAltitude = 0; // To store the maximum altitude encountered

    // Iterate through the gain array, updating the current and max altitudes
    for (int i : gain) {
      currentAltitude += i;
      maxAltitude = Math.max(currentAltitude, maxAltitude);
    }
    return maxAltitude;
  }
}
