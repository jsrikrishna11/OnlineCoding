//https://leetcode.com/problems/search-in-rotated-sorted-array-ii/

public class RotatedArraySearch {
    public static void main(String[] args) {
        int[] nums = {2,5,6,0,0,1,2};
        int target = 3;

        int length = nums.length;
        int index = 0;
        while(index < length && nums[index]!=target) index++;

        System.out.println( index<length);

    }
}
