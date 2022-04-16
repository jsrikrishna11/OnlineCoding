package algos.youtube;

/*
* Count number of steps
* Count number of islands
* */

import java.io.CharArrayReader;
import java.util.*;

public class GraphAlgos {

    static HashMap<Integer, List<Character>> input = new HashMap<>();

    private static void init(){
        input.put(0, Arrays.asList('8', '1', '5'));
        input.put(1, Arrays.asList('0'));
        input.put(5, Arrays.asList('0', '8'));
        input.put(8, Arrays.asList('0', '5'));
        input.put(2, Arrays.asList('3', '4'));
        input.put(3, Arrays.asList('2', '4'));
        input.put(4, Arrays.asList('3', '2'));

    }

    private static boolean
    hasPath(HashMap<Integer,List<Character>> graph, int source, int destination, Set<Integer> visited ){

        if(source == destination) return true;

        if(visited.contains(source)) return false;
        visited.add(source);

        for(Character neighbour : graph.get(source)){
            int node = Integer.parseInt(neighbour+"");

            if(hasPath(graph, node, destination, visited)) return true;
        }
        return false;
    }

    private static int
    countSteps(HashMap<Integer,List<Character>> graph, int source, int destination, Set<Integer> visited, int count ){

        if(source == destination) return count;

        if(visited.contains(source)) return 0;
        visited.add(source);
        count++;
        for(Character neighbour : graph.get(source)){
            int node = Integer.parseInt(neighbour+"");
            int temp = countSteps(graph, node, destination, visited, count);
            if(temp>=count) {

                return temp;
            }
        }
        return 0;
    }



    public static void main(String[] args) {
        init();

        //System.out.println("path from 5->1 exists: "+hasPath(input, 5, 1, new HashSet<Integer>()));

        System.out.println("Number of steps from 1->5 are: "+countSteps(input, 1, 5, new HashSet<Integer>(), 0));


    }
}
