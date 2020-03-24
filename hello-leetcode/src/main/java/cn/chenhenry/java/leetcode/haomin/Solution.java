package cn.chenhenry.java.leetcode.haomin;

import javax.sound.midi.Soundbank;

class Solution {
    public int searchNearestLargerNum(int[] nums, int target) {
        if (target >= nums[nums.length - 1]) {
            return -1;
        }

        int l = 0, h = nums.length - 1;
        int m;

        do {
            m = l + (h - l) / 2;
            if (nums[m] > target) {
                h = m;
            } else {
                l = m + 1;
            }
        } while (l < h);

        return l;
    }

    public static void case1() {
        int[] nums = {1, 2, 3, 3, 5, 6, 9};
        Solution solution = new Solution();
        System.out.println(solution.searchNearestLargerNum(nums, 3));
        System.out.println(solution.searchNearestLargerNum(nums, 8));
        System.out.println(solution.searchNearestLargerNum(nums, 10));
        System.out.println(solution.searchNearestLargerNum(nums, 0));
    }

    public static void case2() {
        int[] nums = {1, 4, 4, 4, 4};
        Solution solution = new Solution();
        System.out.println(solution.searchNearestLargerNum(nums, 3));
    }

    public static void main(String[] args) {
        // case1();
        case2();
    }
}
