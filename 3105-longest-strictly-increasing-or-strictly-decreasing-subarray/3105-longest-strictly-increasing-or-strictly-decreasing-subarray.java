class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        
        int n=nums.length;
        int incr=1;
        int decr=1;

        int l1=0,l2=0;

        for (int r=1;r<n;r++){

            if (nums[r]<=nums[r-1]) l1=r;
            if (nums[r]>=nums[r-1]) l2=r;

            incr=Math.max(incr,r-l1+1);
            decr=Math.max(decr,r-l2+1);
        }

        return Math.max(incr,decr);
    }
}