package PayPal;
import java.io.*;
import java.util.*;


/*
Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

Example:

Input: 3
Output:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]


Input: 2
Output:
[
 [ 1, 2 ],
 [ 4, 3]
]

 */

class SpiralMatrix {
  
  public static int[][] getMatrix(int n){
  
    int [][] matrix = new int[n][n];
    int num =1;
    if(n<=0)
      return null;
    
    int i;
    for(i=0; i<=(n/2);i++){
    
      int r =i;
      int c=i;
      
      System.out.println( "Ring no: "+ i);
      System.out.println( "i: "+ i);
      
       for (c=i; c<n-i-1; c++)
         matrix[r][c] = num ++;
        
   
       for ( r=i; r<n-i-1; r++)
        matrix[r][c] = num ++;
      
      
       for ( c=n-i-1; c>i; c--)
        matrix[r][c] = num ++;
      
      
       for ( r=n-i-1; r>i; r--)
        matrix[r][c] = num ++;
      
    }
    
    System.out.println("Value Of i"+i);

    matrix[i-1][i-1] = num;
    
    return matrix;
  
  }
  
  public static void main(String[] args) {
    ArrayList<String> strings = new ArrayList<String>();
    strings.add("Hello, World!");
    strings.add("Welcome to CoderPad.");
    strings.add("This pad is running Java 8.");

    for (String string : strings) {
      System.out.println(string);
    }
    
    int [][] mat =getMatrix(5);
    
    for(int i =0; i<mat.length; i++){
      for(int j =0; j<mat.length; j++)
      {
        System.out.print(mat[i][j]+" ");
        
      }
    System.out.println("");
    }
  }
}
