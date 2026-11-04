class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        int n=nums.length;
        Arrays.sort(nums);
        List<List<Integer>>result=new ArrayList<>();

        for (int i=0;i<n-2;i++){
            if (i==0 || nums[i]!=nums[i-1]){

                int target=-nums[i];

                int k=i+1;
                int j=n-1;

                while(k<j){

                    int sum=nums[k]+nums[j];

                    if (sum==target){
                        result.add(Arrays.asList(nums[i],nums[k],nums[j]));
                        while(k+1<j && nums[k]==nums[k+1]) k++;
                        while(j-1>k && nums[j]==nums[j-1]) j--;
                        k++;
                        j--;
                    }

                    else if (sum>target){
                        j--;
                    }
                    
                    else{
                        k++;
                    }
                }
            }
        }

        return result;
    }
}