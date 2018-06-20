/*

Your quirky boss collects rare, old coins...
They found out you're a programmer and asked you to solve something they've been
wondering for a long time.

Write a method that, given:

an amount of money
an array of coin denominations
computes the number of ways to make the amount of money with coins of the 
available denominations.

Example: for amount=4 (4¢) and denominations=[1,2,3],
your program would output 4—the number of ways to make 4¢ with those 
denominations:

1¢, 1¢, 1¢, 1¢
1¢, 1¢, 2¢
1¢, 3¢
2¢, 2¢

 */
package makingchange;

import java.util.Arrays;

/**
 *
 * @author Ali
 */
public class MakingChange 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        int[] coins = {1,2,3};
        int len = coins.length;
        int sum = 4;
        System.out.println(numberOfWaysToMakeChange(coins, len, sum));
    }
    
    private static numberOfWaysToMakeChange(int coins[], int len, int n)
    {
        //Time complexity of this function: O(len * n)
        //Space Complexity of this function: O(n)
 
        // table[i] will be storing the number of solutions
        // for value i. We need n+1 rows as the table is
        // constructed in bottom up manner using the base
        // case (n = 0)
        long[] table = new long[n+1];
 
        // Initialize all table values as 0
        Arrays.fill(table, 0);   //O(n)
 
        // Base case (If given value is 0)
        table[0] = 1;
 
        // Pick all coins one by one and update the table[]
        // values after the index greater than or equal to
        // the value of the picked coin
        for (int i=0; i<len; i++)
            for (int j=coins[i]; j<=n; j++)
                table[j] += table[j-coins[i]];
 
        return table[n];
    }
    
}
