/*
Perfect Rectangle Problem
Given N axis-aligned rectangles where N > 0, determine if they all together form an exact cover of a rectangular region.

Each rectangle is represented as a bottom-left point and a top-right point. For example, a unit square is represented as [1,1,2,2]. (coordinate of bottom-left point is (1, 1) and top-right point is (2, 2)).

rectangles = [
  [1,1,3,3],
  [3,1,4,2],
  [3,2,4,4],
  [1,3,2,4],
  [2,3,3,4]
]

Return true. All 5 rectangles together form an exact cover of a rectangular region.

rectangles = [
  [1,1,3,3],
  [3,1,4,2],
  [1,3,2,4],
  [2,2,4,4]
]

Return false. Because two of the rectangles overlap with each other.

LeetCode: https://leetcode.com/problems/perfect-rectangle/
*/

public class RectangleCover {
    public boolean isRectangleCover(int[][] rectangles) {
        // 1. Finding the bottom-left lowest coordinate
        // 2. Finding the top-right highest cordinate
        // 3. Calculate the area of the entire rectangle
        int[] bottomLowest = new int[2];
        int[] topHighest = new int[2];
        int totalIndividualArea = 0;
        
        bottomLowest[0] = rectangles[0][0];
        bottomLowest[1] = rectangles[0][1];
        
        for(int[] rectangle : rectangles) {
            
            if(bottomLowest[0] > rectangle[0]) {
                bottomLowest[0] = rectangle[0];                
            }
            
            if(bottomLowest[1] > rectangle[1]) {
                bottomLowest[1] = rectangle[1];
            }
            
            if(rectangle[2] > topHighest[0]) {
                topHighest[0] = rectangle[2];
            }
            
            if(rectangle[3] > topHighest[1]){
                topHighest[1] = rectangle[3];
            }
            
            int width = rectangle[2] - rectangle[0];
            int height = rectangle[3] - rectangle[1];
            
            int area = height * width;
            totalIndividualArea = totalIndividualArea + area;
        }
        
        int finalWidth = topHighest[0] - bottomLowest[0];
        int finalHeight = topHighest[1] - bottomLowest[1];
        int finalArea = finalWidth * finalHeight;
        
        if(finalArea == totalIndividualArea) {
            return true;
        }
        
        return false;
    }
}