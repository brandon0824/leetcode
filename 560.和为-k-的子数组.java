import java.util.Map;

class Solution {
    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        int count = 0;
        Map<Integer, Integer> preSumMap = new HashMap<Integer, Integer>();
        preSumMap.put(0, 1);
        int preSum = 0;
        for(int num:nums) {
            preSum += num;
            if(preSumMap.containsKey(preSum - k)) {
                count += preSumMap.get(preSum - k);
            }
            preSumMap.put(preSum, preSumMap.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }
}