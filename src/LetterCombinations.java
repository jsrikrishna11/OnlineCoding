import java.util.ArrayList;
import java.util.Map;

//Question: https://leetcode.com/problems/letter-combinations-of-a-phone-number/
public class LetterCombinations {

    private static final Map<Character, ArrayList<Character>> lookup = Map.ofEntries(
        Map.entry(
                '2',
               new ArrayList<Character>() {
                {
                    add('a');
                    add('b');
                    add('c');
                }
    } ),
        Map.entry(
        '3',
        new ArrayList<Character>() {
        {
            add('d');
            add('e');
            add('f');
        }
    }),
        Map.entry(
                '4',
                new ArrayList<Character>() {
                    {
                        add('g');
                        add('h');
                        add('i');
                    }
                }),
        Map.entry(
                '5',
                new ArrayList<Character>() {
                    {
                        add('j');
                        add('k');
                        add('l');
                    }
                }),
        Map.entry(
                '6',
                new ArrayList<Character>() {
                    {
                        add('m');
                        add('n');
                        add('o');
                    }
                }),
        Map.entry(
                '7',
                new ArrayList<Character>() {
                    {
                        add('p');
                        add('q');
                        add('r');
                        add('s');
                    }
                }),
        Map.entry(
                '8',
                new ArrayList<Character>() {
                    {
                        add('t');
                        add('u');
                        add('v');
                    }
                }),
        Map.entry(
                '9',
                new ArrayList<Character>() {
                    {
                        add('w');
                        add('x');
                        add('y');
                        add('z');
                    }
                })
    );

    private static void recurCombinations(String s, String concat, int index){

        if(index>= s.length()){
            System.out.println(concat);
            return;
        }

        char number = s.charAt(index);
        index++;
        if(lookup.containsKey(number)){
            ArrayList<Character> iterate = lookup.get(number);
            for(Character c : iterate){
                String add = concat+c;

                recurCombinations(s, add,index);
            }
        }
    }

    public static void main(String[] args) {
        recurCombinations("2342348497384726849393839579","",0);
        System.out.println("---------------------------");
    }
}
