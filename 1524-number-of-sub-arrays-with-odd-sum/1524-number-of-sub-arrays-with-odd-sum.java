class Solution {
    public int numOfSubarrays(int[] arr) {
        int n=arr.length;
        int MOD=1000_000_00_7;
        int ans=0,odd=0,even=1,prefix=0;

        for (int i=0;i<n;i++){
            prefix+=arr[i];
            int parity=(prefix)%2;
            if (parity==1){
                ans=(ans+even)%MOD;
                odd++;
            }
            else{
                ans=(ans+odd)%MOD;
                even++;
            }
        }

        return ans;
    }
}