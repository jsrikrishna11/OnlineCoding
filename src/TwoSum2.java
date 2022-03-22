import org.jetbrains.annotations.NotNull;

public class TwoSum2 {

    public static int binarySearch(int @NotNull [] nums, int begin,  int target){
        int end = nums.length-1;
        int length = end;
        int index = -1;


        while(begin<=end) {
            int mid = (begin + end) / 2;
            System.out.println(mid);
            if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                begin = mid + 1;
            } else {
                index = mid;
                break;
            }
        }
        return index;
    }
    public static void main(String[] args) {

        int[] numbers = {1,2,3,4,5,6,7};
        int length = numbers.length;
        int target = 9;
        int[] output = new int[2];

        for(int i = 0; i < length; i++ ){
            int get = target - numbers[i];
            int index = binarySearch(numbers,i+1,get);
            if(index > -1) output = new int[]{i+1,index+1};
        }
        for(int i = 0; i<2; i++) System.out.println(output[i]+" | ");

        //approach two
        int begin = 0;
        int end = numbers.length-1;


        while(begin<end){
            int sum = numbers[begin]+numbers[end];
            if(sum == target) break;
            else if(sum > target) end--;
            else begin++;
        }

        System.out.println(begin+1+" | " + end+1);


    }
}
