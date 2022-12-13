// Time Complexity : O(n^2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
public class threeSum {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            // values are greater than 0 in sorted array, there is no use of calculating the
            // sum
            if (nums[i] > 0) {
                break;
            }
            int low = i + 1;
            int high = nums.length - 1;
            // skip duplicate number in the outer loop
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                if (sum == 0) {
                    // create a list to add the elements in the results
                    List<Integer> res = Arrays.asList(nums[i], nums[low], nums[high]);
                    result.add(res);
                    low++;
                    high--;

                    // skip duplicates in inner loop
                    while (low < nums.length && nums[low] == nums[low - 1])
                        low++;
                    while (high >= 0 && nums[high] == nums[high + 1])
                        high--;
                } else if (sum > 0) {
                    high--;
                } else {
                    low++;
                }
            }
        }
        return result;
    }

}