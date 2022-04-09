import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/integer-to-roman/
public class NumToRoman {
    private static final Map<Integer,String> map = Map.ofEntries(
            Map.entry(
                    1,
                    "I"
                    ),
            Map.entry(
                    4,
                    "IV"
            ),
            Map.entry(
                    5,
                    "V"
            ),
            Map.entry(
                    9,
                    "IX"
            ),
            Map.entry(
                    10,
                    "X"
            ),
            Map.entry(
                    50,
                    "L"
            ),
            Map.entry(
                    100,
                    "C"
            ),
            Map.entry(
                    40,
                    "XL"
            ),
            Map.entry(
                    90,
                    "XC"
            ),
            Map.entry(
                    500,
                    "D"
            ),
            Map.entry(
                    1000,
                    "M"
            ),

            Map.entry(
                    400,
                    "CD"
            ),
            Map.entry(
                    900,
                    "CM"
            )
);

    private static String concatTimes(String s, int times){
        StringBuilder concat = new StringBuilder();
        for(int i = 0; i < times; i++) concat.append(s);

        return concat.toString();
    }

    private static int properConcat(int num, StringBuilder string, int div){
        int times = num/div;
        string.append(concatTimes(map.get(div), times));
        num = num%div;

        return num;
    }

    private static int improperConcat(int num, StringBuilder string, int div){
        string.append(map.get(div));
        return num % div;
    }

    public static void main(String[] args) {
        int num = 1000;
        StringBuilder roman = new StringBuilder();
        int temp = num;
        while(temp!=0){
            if(temp>=1000){
                temp = properConcat( temp, roman, 1000);
            }
            else if(temp >= 900){
                temp = improperConcat(temp, roman, 900);
            }else if(temp >= 500){
                temp = properConcat( temp, roman, 500);
            }else if(temp >= 400){
                temp = improperConcat(temp, roman, 400);
            }else if (temp >= 100){
                temp = properConcat( temp, roman, 100);
            }else if(temp >= 90){
                temp = improperConcat(temp, roman, 90);
            }else if (temp >= 50){
                temp = properConcat( temp, roman, 50);
            }else if (temp >= 40){
                temp = improperConcat(temp, roman, 40);
            }else if (temp >= 10){
                temp = properConcat( temp, roman, 10);
            }else if(temp >= 9){
                temp = improperConcat(temp, roman, 9);
            }else if (temp >=5){
                temp = properConcat( temp, roman, 5);
            }else if(temp >=4){
                temp = improperConcat(temp, roman, 4);
            }
            else if (temp >= 1){
                temp = properConcat( temp, roman, 1);
            }
        }

        System.out.println(roman);

    }
}
