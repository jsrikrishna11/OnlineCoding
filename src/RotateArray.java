import java.util.*;

public class RotateArray {

    public static void main(String[] args) {
        int[] nums = {-1,-100,3,99};
        int k = 4;

        Map<Integer, ArrayList<Integer>> mapIndex = new HashMap<Integer, ArrayList<Integer>>();


        int length = nums.length;

        for (int i = 0; i < length; i++) {
            int number = nums[i];
            int flipTo = (i + k)%length;

            if(mapIndex.containsKey(number)){
                ArrayList<Integer> li = mapIndex.get(number);
                li.add(flipTo);
                mapIndex.put(number, li);
            }else{
                ArrayList<Integer> li = new ArrayList<>();
                li.add(flipTo);
                mapIndex.put(number, li);
            }
        }

        System.out.println(mapIndex.toString());
        int[] output = converToArray(length,mapIndex);
        for(int i = 0; i<length; i++) System.out.println(output[i]+" | ");

    }

    public static int[] converToArray(int length, Map<Integer, ArrayList<Integer>> mapIndex) {
        int[] array = new int[length];

        Iterator itr = mapIndex.keySet().iterator();

        while(itr.hasNext()){
            int number = (Integer) itr.next();
            ArrayList<Integer> li =  mapIndex.get(number);

            int size = li.size();

            for(int i = 0; i<size; i++) array[li.get(i)] = number;

        }
        return array;
    }
}
