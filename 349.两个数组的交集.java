import java.util.Arrays;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=349 lang=java
 *
 * [349] 两个数组的交集
 */

// @lc code=start
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int index = 0;
        Set<Integer> set1 = new HashSet<Integer>();
        Set<Integer> set2 = new HashSet<Integer>();
        for(int num1:nums1) {
            set1.add(num1);
        }
        for(int num2:nums2){
            set2.add(num2);
        }

        Set<Integer> interset = new HashSet<Integer>();
        for(int num:set1){
            if(set2.contains(num)){
                interset.add(num);
            }
        }
        int[] interarray = new int[interset.size()];
        for(int i:interset){
            interarray[index++] = i;
        }
        return interarray; 
    }
}
// @lc code=end

