/**
 * O(n) space and time complexity.
 * #42 Trapping Rain Water
 * https://leetcode.com/problems/trapping-rain-water/
 *
 */

class Solution {
    public int trap(int[] height) {
        int[] right= maxRight(height);

        int ans= 0, max= 0;
        for(int i=0;i<height.length;i++) {
            int min= Math.min(max, right[i]);
            if(min> height[i]) ans+= min- height[i];
            max= Math.max(max, height[i]);
        }

        return ans;
    }

    int[] maxRight(int[] a) {
        int max= 0;
        int[] ret= new int[a.length];
        for(int i=a.length-1;i>=0;i--) {
            ret[i]= max;
            max= Math.max(max, a[i]);
        }
        return ret;
    }
}