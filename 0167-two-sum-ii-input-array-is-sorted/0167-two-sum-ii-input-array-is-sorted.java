class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        int n=numbers.length;

        int l=0,r=n-1;

        int[] result=new int[2];

        while(l<r){

            int sum=numbers[l]+numbers[r];

            if (sum==target){

                result[0]=l+1;
                result[1]=r+1;
                break;
            }

            else if (sum>target) r--;

            else l++;
        }

        return result;
    }
}