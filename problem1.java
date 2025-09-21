public class problem1 {
    // This solution counts the number of arthimetic slices(subarray of length>=3 with equal differences)
    // It ierates through the array and checks if the current three numbers form an arthimetic progression
    // if yes , it extends the count of previous slices (curr=prev+1) otherwise resets curr=0. The total
    // count is accumulated in count and returned at the end

    // TC= O(n) ; SC= O(1)
    public int numberOfArithmeticSlices(int[] nums) {
        int curr=0, prev=0;
        int count=0;
        int n= nums.length;
        if (n<3)
        {
            return 0;
        }
        for (int i = 2; i < n; i++)
        {
            if (nums[i-1]-nums[i-2] == nums[i]-nums[i-1])
            {
                curr=prev+1;

            }
            else {
                curr=0;
            }
            count+=curr;
            prev=curr;

        }
        return count;
    }
}