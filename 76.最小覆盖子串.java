/*
 * @lc app=leetcode.cn id=76 lang=java
 *
 * [76] 最小覆盖子串
 */

// @lc code=start
class Solution {
    public String minWindow(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if(sLen == 0 || tLen == 0 || sLen < tLen) return "";

        char[] charArrayS = s.toCharArray();
        char[] charArrayT = t.toCharArray();

        // ascii('z') = 122; 128正好是2的次方
        int[] winFreq = new int[128];
        int[] tFreq = new int[128];
        for(char c:charArrayT){
            tFreq[c]++;
        }

        int distance = 0;
        int minLen = sLen + 1;
        int begin = 0;
        int left = 0, right = 0;
        while(right < sLen){
            if(tFreq[charArrayS[right]] == 0){
                right++;
                continue;
            }
            if(winFreq[charArrayS[right]] < tFreq[charArrayS[right]]){
                distance++;
            }
            winFreq[charArrayS[right]]++;
            right++;

            while(distance == tLen){
                if(right - left < minLen){
                    minLen = right - left;
                    begin = left;
                }
                if(tFreq[charArrayS[left]] == 0){
                    left++;
                    continue;
                }
                if(winFreq[charArrayS[left]] == tFreq[charArrayS[left]]){
                    distance--;
                }
                winFreq[charArrayS[left]]--;
                left++;
            }
        }
        if(minLen == sLen + 1){
            return "";
        }
        return s.substring(begin, begin + minLen);
    }
}
// @lc code=end