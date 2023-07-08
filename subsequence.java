package DSAPREPARATION;

import java.util.Scanner;

/**
 * subsequence
 */
public class subsequence {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter String X :");
        String str1 = in.nextLine();
        System.out.println("Enter String Y :");
        String str2 = in.nextLine();

        in.close();

        boolean res = findMinOperations(str1, str2)==0;

        System.out.println(res);
        System.out.println("min num of op "+findMinOperations(str1, str2)  );
        


        

}
public static int findMinOperations(String str1, String str2) {
    int m = str1.length();
    int n = str2.length();

    int dp[][] = new int[m + 1][n + 1];

    int i ;
    for(i=0; i<=n; i++){
        dp[0][i]=0;

    }

    for(i=0; i<=m; i++){
        dp[i][0] = i;
    }

    for(i=1; i<=m; i++){
        for(int j=1; j<=n; j++){
            if(str1.charAt(i-1) == str2.charAt(j-1)){
                dp[i][j] = dp[i-1][j-1];
            }
            else{
                dp[i][j] = 1 + Math.min(dp[i][j-1], dp[i-1][j]);
            }
            }
        }
    
            return m-dp[m][n];



}
}

