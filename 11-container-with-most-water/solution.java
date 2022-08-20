/* 

https://leetcode.com/problems/container-with-most-water/

You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
Find two lines that together with the x-axis form a container, such that the container contains the most water.
Return the maximum amount of water a container can store.
Notice that you may not slant the container. */

/* 

Steps:
1. Initialize 2 pointers, left and right, at far end of container
2. Get area with max possible width
3. Move the pointer with lowest height inwards and get new area
4. Compare and maintain biggest area
5. iterate through the loop until both pointers meet.

*/

class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while(left <= right){
            int temp = (right - left) * Math.min(height[left], height[right]);
            max = Math.max(max, temp);
            if(height[left] <= height[right]) 
                left++;
            else
                right--;
        }
        return max;
    }
}