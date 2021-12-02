/**
 * O(n) time and O(1) space complexity
 *
 * This is a joke.
 */

class Solution2 {
    public int maxChunksToSorted(int[] arr) {
        int ans= 0, max= 0;
        for(int i=0;i<arr.length;i++) {
            if(max< i) ans++;

            max= Math.max(max, arr[i]);
        }

        return ans+1;
    }
}