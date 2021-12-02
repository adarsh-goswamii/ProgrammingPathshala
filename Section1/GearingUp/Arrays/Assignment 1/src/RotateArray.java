/**
 * O(n) time and O(1) space complexity
 *
 * 189. Rotate Array.
 * https://leetcode.com/problems/rotate-array/
 */

class Solution3 {
    public void rotate(int[] nums, int k) {
        int n= nums.length, count= 0, val= 0;
        while(count!= n) {
            int i= val, prev= nums[val];
            do {
                int temp= prev;
                prev= nums[(i+k)%n];
                nums[(i+k)%n]= temp;
                i= (i+k)%n;
                count++;
            } while(i!= val);
            val++;
        }
    }
}