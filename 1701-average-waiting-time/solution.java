/* 

https://leetcode.com/problems/average-waiting-time/

There is a restaurant with a single chef. You are given an array customers, where customers[i] = [arrivali, timei]:

arrivali is the arrival time of the ith customer. The arrival times are sorted in non-decreasing order.
timei is the time needed to prepare the order of the ith customer.
When a customer arrives, he gives the chef his order, and the chef starts preparing it once he is idle. The customer waits till the chef finishes preparing his order. The chef does not prepare food for more than one customer at a time. The chef prepares food for customers in the order they were given in the input.

Return the average waiting time of all customers. Solutions within 10-5 from the actual answer are considered accepted.


*/

class Solution {
    public double averageWaitingTime(int[][] customers) {
        
        int lastServedTime = 0;
        double totalServiceTime = 0;
        
        for (int[] customer : customers){
            int startTime = customer[0];
            int endTime;
            if (startTime > lastServedTime){
                // chef is free
                endTime = startTime + customer[1];
            } else {
                // chef is still preparing prev order
                endTime = lastServedTime + customer[1];
            }
            lastServedTime = endTime;
            totalServiceTime += endTime-startTime;
        }
        
        return (double) totalServiceTime/customers.length;
    }
}
