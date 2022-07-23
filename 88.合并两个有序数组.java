/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] 合并两个有序数组
 */

// @lc code=start
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int point1 = m - 1;      //3
        int point2 = n - 1;      //3
        int point = m + n - 1;   //5
        while(point1 >= 0 && point2 >= 0){
            if(nums1[point1] >= nums2[point2]){
                nums1[point--] = nums1[point1--];
            }else{
                nums1[point--] = nums2[point2--];
            }
        }
        while(point1 >= 0){
            nums1[point--] = nums1[point1--];
        }
        while(point2 >= 0){
            nums1[point--] = nums2[point2--];
        }
    }
}
// @lc code=end

