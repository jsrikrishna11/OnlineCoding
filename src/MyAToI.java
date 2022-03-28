public class MyAToI {

    private static boolean isLegit(char input){
        return input == '0' || input == '1' || input == '2' || input == '3' ||
                input == '4' || input == '5' || input == '6' || input == '7' ||
                input == '8' || input == '9' || input == '-' || input == '+';
    }
    private static boolean isSpecial(char input){
        return input == ' ' ;
    }
    private static int overFLowValue(boolean negative){
        return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
    }
    public static void main(String[] args) {

        long temp = Long.MAX_VALUE;
        String s = "-"+(temp);
        s = s.trim();


        boolean numberStarted = false;
        boolean negative = false;
        boolean positive = false;

        int number = 0;
        int length = s.length();

        for(int i = 0; i < length; i ++){
            char c = s.charAt(i);
            if(isLegit(c)){
                int digit = c - '0';
                if(digit==-3 && !numberStarted){
                    if(positive || negative) break;
                    negative = true;
                }else if(digit == -5 && !numberStarted){
                    if(negative || positive) break;
                    positive = true;
                }else if(isSpecial(c)) break;
                else if(digit>-1){
                    numberStarted = true;
                    int tens = number*10;
                    number = tens+ digit;
                    if(tens < 0 || number<0){
                        System.out.println("Sudden flip!");
                        number = overFLowValue(negative);
                        break; //return
                    }
                }else break;
            }else if(!numberStarted && !isSpecial(c)){ negative=false; break;}
            else if(numberStarted && isSpecial(c)) break;
            else break;
        }

        if(negative) number = number*-1;
        System.out.println(number);
    }
}
