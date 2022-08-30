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

    public static void main(String[] args)
   {
      int[] coins = {1,2,3};
      Map<Integer, Integer> map = new HashMap<>();
      System.out.println(numOfWaysToMakeChange(coins, coins.length, 14, map));
   }

   private static int numOfWaysToMakeChange(int[] coins, int n, int sum, Map<Integer, Integer> map)
   {
      if (map.get(sum) != null)
      {
         return map.get(sum);
      }
      if (sum == 0)
      {
         return 1;
      }

      if (sum < 0)
         return 0;

      // If there are no coins and sum
      // is greater than 0, then no
      // solution exist
      if (n <= 0)
         return 0;

      map.put(sum, numOfWaysToMakeChange(coins, n - 1, sum, map));
      map.put(sum - coins[n-1], numOfWaysToMakeChange(coins, n, sum - coins[n - 1], map));
      return map.get(sum) + map.get(sum - coins[n-1]) + 1;
   }
    
}
