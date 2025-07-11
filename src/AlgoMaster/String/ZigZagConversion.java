package AlgoMaster.String;

/* https://leetcode.com/problems/zigzag-conversion/description/ */
public class ZigZagConversion {

  /* https://leetcode.com/problems/zigzag-conversion/description/ */
  public static void main(String[] args) {
    System.out.println(convertZigzag("PAYPALISHIRING", 3));
  }

  public static String convertZigzag(String s, int numRows) {
    if (numRows == 1 || s.length() <= numRows) {
      return s;
    }

    StringBuilder[] rows = new StringBuilder[numRows];
    for (int i = 0; i < numRows; i++) {
      rows[i] = new StringBuilder();
    }

    int currentRow = 0;
    boolean goingDown = false;

    for (char c : s.toCharArray()) {
      rows[currentRow].append(c);
      // Change direction when top or bottom row is reached
      if (currentRow == 0 || currentRow == numRows - 1) {
        goingDown = !goingDown;
      }
      currentRow += goingDown ? 1 : -1;
    }

    StringBuilder result = new StringBuilder();
    for (StringBuilder row : rows) {
      result.append(row);
    }
    return result.toString();
  }
}