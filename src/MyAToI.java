public class MyAToI {

    private static boolean isLegit(char input){
        return input == '0' || input == '1' || input == '2' || input == '3' ||
                input == '4' || input == '5' || input == '6' || input == '7' ||
                input == '8' || input == '9' || input == '-' || input == '+';
    }
    private static boolean isSpecial(char input){
        return input == ' ' ;
    }
    public static void main(String[] args) {

        long max = Integer.MIN_VALUE;

        String s = "18446744073709551617";
        System.out.println(Long.MAX_VALUE);


        boolean numberStarted = false;
        boolean negative = false;
        boolean positive = false;
        boolean flipped = false;

        long number = 0;
        int length = s.length();

        for(int i = 0; i < length; i ++){
            char c = s.charAt(i);
            if(isLegit(c)){
                int digit = c - '0';
                if(digit==-3 && !numberStarted){
                    if(positive || negative) break;
                    negative = !negative;
                }else if(digit == -5 && !numberStarted){
                    if(negative || positive) break;
                    positive = true;

                }else if(isSpecial(c)) break;
                else if(digit>-1){
                    numberStarted = true;
                    long tens = number*10;
                    if(tens < 0){
                        System.out.println("Sudden flip!");
                        number = Integer.MAX_VALUE;
                        flipped = true;
                        break;
                    }
                    number = tens+ digit;
                    if(number < 0){
                        System.out.println("sudden flip!");
                        number = Integer.MAX_VALUE;
                        flipped = true;
                        break;
                    }
                }else break;
            }else if(!numberStarted && !isSpecial(c)){ negative=false; break;}
            else if(numberStarted && isSpecial(c)) break;
            else if(isSpecial(c) && !positive && !negative) {}
            else break;
        }

        if(!negative && number < 0 ) number =  Integer.MAX_VALUE;
        else if(!negative && flipped) number = Integer.MAX_VALUE;
        else if( negative && number < Integer.MIN_VALUE) number = Integer.MIN_VALUE;
        else if(negative && number > Integer.MAX_VALUE) number = Integer.MIN_VALUE;
        else if(number > (long) Integer.MAX_VALUE) number = Integer.MAX_VALUE;
        else if ( negative && number <= Integer.MAX_VALUE && !flipped) number = number*-1;
        else if(negative && number <= Integer.MAX_VALUE && flipped) number = Integer.MIN_VALUE;


        System.out.println(number);
    }
}
