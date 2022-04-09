//https://leetcode.com/problems/longest-palindromic-substring/
public class LongestPalindrome {

    public static void main(String[] args) {

        String input = "cbbd";
        String result = "";
        int n = input.length();
        boolean[][] map = new boolean[n][n];
        int maxLength = 0;

        int start = 0;
        int window = 2;



        for(int i = 0 ; i < n ; i++) {
            map[i][i] = true;
            if(result==""){
                result = input.substring(i,i+1);
            }
            if(i+1 < n)
            {
                char one = input.charAt(i);
                char next = input.charAt(i+1);
                if(one==next) {
                    map[i][i+1] = true;
                    result = input.substring(i,i+2);
                    maxLength = 1;
                }
                else{
                    map[i][i+1] = false;
                }
            }
        }
        /*
        1. move the start plenty of times
        2. increment window konchem konchem
        3. mid nunchi sub-parts should be pallindromes
         */

        for(; start + window < n; window++){
            for(; start + window < n ; start++){
                int subWinLeft = start+1;
                int subWinRight = start+window-1;
                if(map[subWinLeft][subWinRight]){
                    int leftExtreme = input.charAt(start);
                    int rightExtreme = input.charAt(start+window);
                    if(leftExtreme==rightExtreme) {
                        map[start][start+window] = true;
                        result = input.substring(start,start+window+1);
                        maxLength = window+1;
                    }
                }
            }
            start = 0;
        }
    System.out.println(result);
        System.out.println(maxLength);


    }
}
