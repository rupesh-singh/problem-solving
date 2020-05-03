/*
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
*/
class KadaneAlgorithmMaxSubarray {
public static void main(String args[]){

    System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
}
    public static int maxSubArray(int[] nums) {
        int prev_sum = nums[0], max_global = nums[0];
        for (int i = 1; i < nums.length; i++ ){
            prev_sum = (nums[i] > (prev_sum + nums[i]))?nums[i]:(prev_sum + nums[i]);
            
           if(prev_sum > max_global)
                max_global = prev_sum;
        }
        
        return max_global;
    }
}