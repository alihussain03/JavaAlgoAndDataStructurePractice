package com.Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import util.CollectionUtil;
import util.GeneralUtil;

/**
 * <a href="https://leetcode.com/problems/next-greater-element-i/description/">LeetCode</a>
 */
public class NextGreaterElement {

  public static void main(String[] args) {
    CollectionUtil.printArray(nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2}));
    GeneralUtil.newFunctionCall();
    CollectionUtil.printArray(nextGreaterElement(new int[]{2, 4}, new int[]{1, 2, 3, 4}));
    GeneralUtil.newFunctionCall();
    CollectionUtil.printArray(nextGreaterElement(new int[]{2, 1, 3}, new int[]{2, 3, 1}));
  }

  static int[] nextGreaterElement(int[] nums1, int[] nums2) {
    Map<Integer, Integer> map = new HashMap<>();
    Stack<Integer> stack = new Stack<>();

    for (int num : nums2) {
      while (!stack.isEmpty() && stack.peek() < num) {
        map.put(stack.pop(), num);
      }
      stack.push(num);
    }

    int[] res = new int[nums1.length];
    for (int i = 0; i < nums1.length; i++) {
      res[i] = map.getOrDefault(nums1[i], -1);
    }
    return res;
  }
}