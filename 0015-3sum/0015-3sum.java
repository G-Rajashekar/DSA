class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        int n=nums.length;
        Arrays.sort(nums);
        List<List<Integer>>result=new ArrayList<>();

        for (int i=0;i<n-2;i++){
            if (i==0 || nums[i]!=nums[i-1]){

                twoSum(nums,result,i,i+1,n-1);
            }
        }


        return result;
    }

    public void twoSum(int[] nums,List<List<Integer>>result,int i,int k,int j){

        while(k<j){

            int sum=nums[k]+nums[j];

            if (sum==-nums[i]){

                result.add(Arrays.asList(nums[i],nums[j],nums[k]));

                while(k<j && nums[k]==nums[k+1]) k++;
                while(j>k && nums[j]==nums[j-1]) j--;

                k++;
                j--;
            }

            else if (sum>-nums[i]) j--;

            else k++;
        }

        return;
    }
}