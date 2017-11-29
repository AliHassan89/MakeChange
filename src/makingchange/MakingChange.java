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
        System.out.println(numberOfWaysToMakeChange(4, coins));
    }
    
    private static int numberOfWaysToMakeChange(int amount, int[] coins)
    {
        if (coins.length == 0)
        {
            return 0;
        }
        Arrays.sort(coins);
        
        return numberOfWaysToMakeChangeUtil(amount, coins, coins.length-1, 0);
    }
    
    private static int numberOfWaysToMakeChangeUtil(int amount, int[] coins, int index, int totalWays)
    {
        if (index < 0)
            return 0;
        
        int diff = amount - coins[index];
        if (diff < 0)
        {
            totalWays = numberOfWaysToMakeChangeUtil(amount, coins, --index, totalWays);
        }
        else if (diff == 0)
        {
            totalWays++;
            if (index > 0)
            {
                totalWays = numberOfWaysToMakeChangeUtil(amount, coins, --index, totalWays);
            }
            return totalWays;
        }
        else
        {
            totalWays = numberOfWaysToMakeChangeUtil(diff, coins, index, totalWays);
            if (index > 0)
            {
                totalWays = numberOfWaysToMakeChangeUtil(amount, coins, --index, totalWays);
            }
        }
        
        return totalWays;
    }
    
}
