class Solution {
    int[] memo;  //memo[n] 表示钱币n可以被换取的最少的硬币数，不能换取就为 -1
    public int coinChange(int[] coins, int amount) {
        if(coins.length == 0){
            return -1;
        }
        memo = new int[amount];
        return findways(coins, amount);
    }

    public int findways(int[] coins, int amount){
        if(amount < 0) return -1;
        if(amount == 0) return 0;
        if(memo[amount-1] != 0){
            return memo[amount-1];
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < coins.length; i++){
            int res = findways(coins, amount-coins[i]);
            if(res >= 0 && res < min){
                min = res + 1;
            }
        }
        memo[amount - 1] = (min == Integer.MAX_VALUE ? -1 : min);
        return memo[amount-1];
    }
}