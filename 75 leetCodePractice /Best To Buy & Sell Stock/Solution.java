class Solution {
    public static int maxProfit(int[] prices) {
 
        int cheapToBuy = prices [0] ; //smallToBuy means the price is small or low so i can buy for at cheap price
        int highToSell = prices [0];   //bigToSell mean the price is big or high so i can sell for bes price 

        for (int i =0; i < prices.length ; i++){
     
            if (cheapToBuy >= prices[i]  ){
                cheapToBuy = prices[i];
                highToSell = prices[i];
                for (int j = i + 1; j < prices.length ; j++ ){
                    if (highToSell < prices[j] ){

                        highToSell = prices[j];
                    }
                }
            }
        }

        return highToSell - cheapToBuy;
    }

    public static void main(String[] args) {
        int[] prices = new int[3];
        prices [0] = 2;
        prices [1] = 4;
        prices [2] = 1;

        int profit = maxProfit(prices);
        System.out.println(profit);

    }
}