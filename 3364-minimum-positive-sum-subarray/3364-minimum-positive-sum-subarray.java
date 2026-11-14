class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        
        int n=nums.size();
        int ans=Integer.MAX_VALUE;

        int[] prefix=new int[n];
        prefix[0]=nums.get(0);
        for (int i=1;i<n;i++){
            prefix[i]=prefix[i-1]+nums.get(i);
        }

        for (int i=0;i<n;i++){
            for (int len=l;len<=r && len<=i+1;len++){
                int s=i-len+1;

                int sum=s==0?prefix[i]:prefix[i]-prefix[s-1];
                if (sum>0) ans=Math.min(ans,sum);
            }
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
}