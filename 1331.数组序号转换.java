/*
 * @lc app=leetcode.cn id=1331 lang=java
 *
 * [1331] 数组序号转换
 */

// @lc code=start
class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int len = arr.length;
        
        int[] sortedarray = new int[len];
        System.arraycopy(arr, 0, sortedarray, 0, len);
        Arrays.sort(sortedarray);

        // key-value 下标 数字
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] result = new int[len];

        for(int num:sortedarray){
            if(!map.containsKey(num)){
                map.put(num, map.size()+1);
            }
        }
        for(int i = 0; i < len; i++){
            result[i] = map.get(arr[i]);
        }
        return result;

    }
}
// @lc code=end

