class Solution {
    int[] dp;
    public int climbStairs(int n, int[] costs) {

        dp=new int[n+1];
        Arrays.fill(dp,-1);
        return helper(n,costs,0);
        
    }

    public int helper(int n,int[] costs,int i){
        if (i>=n) return 0;

        if (dp[i]!=-1) return dp[i];

        int oneStep=i+1<=n?(costs[i]+1+helper(n,costs,i+1)):Integer.MAX_VALUE;
        int twoStep=i+2<=n?(costs[i+1]+4+helper(n,costs,i+2)):Integer.MAX_VALUE;
        int threeStep=i+3<=n?(costs[i+2]+9+helper(n,costs,i+3)):Integer.MAX_VALUE;

        return dp[i]=Math.min(oneStep,Math.min(twoStep,threeStep));
    }
}