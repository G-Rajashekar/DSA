class Solution {
    public int[] runningSum(int[] nums) {
        
        int n=nums.length;
        int[] runningSum=new int[n];

        for (int i=0;i<n;i++){

            if (i==0) runningSum[0]=nums[0];
            else runningSum[i]=nums[i]+runningSum[i-1];
        }

        return runningSum;
    }
}