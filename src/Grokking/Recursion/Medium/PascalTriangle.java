package Grokking.Recursion.Medium;

import java.util.ArrayList;
import java.util.List;
import util.CollectionUtil;

// Follow-up questions, how to print specific row 2) what is the value of specific row and index
public class PascalTriangle {

  public static void main(String[] args) {
    List<List<Integer>> triangle = generatePascalTriangleUsingIteration(4);
    CollectionUtil.printList(triangle);

    triangle.clear();
    System.out.println("\nPascal triangle using Recursion ");
    generatePascalTriangleUsingRecursion(triangle, 4, 0);
    CollectionUtil.printList(triangle);
  }

  /*
  1
  1 1
  1 2 1
  1 3 3 1
  */
  static List<List<Integer>> generatePascalTriangleUsingIteration(int numRows) {
    List<List<Integer>> triangle = new ArrayList<>();
    for (int i = 0; i < numRows; i++) {
      generateRow(triangle, i);
    }
    return triangle;
  }

  static void generatePascalTriangleUsingRecursion(List<List<Integer>> triangle, int numRows, int rowIndex) {
    if (numRows == rowIndex) {
      return;
    }
    generateRow(triangle, rowIndex);
    generatePascalTriangleUsingRecursion(triangle, numRows, rowIndex + 1);
  }

  static void generateRow(List<List<Integer>> triangle, int rowIndex) {
    List<Integer> row = new ArrayList<>();
    for (int j = 0; j <= rowIndex; j++) {
      if (j == 0 || j == rowIndex) {
        row.add(1);
      } else {
        row.add(triangle.get(rowIndex - 1).get(j - 1) + triangle.get(rowIndex - 1).get(j));
      }
    }
    triangle.add(row);
  }
}
