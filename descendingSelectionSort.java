import java.util.Scanner;
public class descendingSelectionSort{
   public static void main(String[] args) {
   Scanner keyboard = new Scanner (System.in);
   System.out.print("Please write the amount of numbers that you want to input > ");   //entering length of the array
   int numbers = keyboard.nextInt();
   int array[] = new int [numbers];
   
   for (int x=0; x<array.length;x++){
      System.out.print("Please input score n"+(x+1)+" > ");
      array[x] = keyboard.nextInt();         //filling array
   }
   
   boolean rightOrder = isDescending(array);    //checking if the array is in the right descending position
   int numberOfElements = numOfElements(array); //checking length of array
   int temporary=0;
   
   
   while(rightOrder == false){      //while order is not correct
      int mI = minIndex(array, numberOfElements);  //finds index where minimum value is at
      
      
      if(numberOfElements>0){
         temporary = array[numberOfElements-1];
         array[numberOfElements-1] = array[mI];
         array[mI] = temporary;
         //this is where the swaping takes place. First the temporary variable is equal to 
         //the value at the indexed position at numberOfElements-1. Then the array at that
         //position is equal to array at the place where the minimum index is located, and
         // then to finalize the swapping, the array at mI is set equal to the temporary 
         //variable completing the swapping of variables. 
         //
         //
      }
      rightOrder = isDescending(array);   //checking again if the array is in the correct order
      if(numberOfElements>=0){
         numberOfElements--;           //doing this, so that the sorted part of the array isn't 
         //taken into consideration for the search of a minimum value
      }
      
   }
   for (int z=0; z<array.length; z++){
      System.out.print(array[z] + ", ");  //printing array
   }
   
   }//end main
   
   public static int minIndex(int [] arr, int numOfEl){  //finding the index at which the minimum value is located
      int minIndex= 0;
      for(int i=0;i<numOfEl;i++){
         if(arr[i]<=arr[minIndex]){ //finding the index at which the minimum value is located at
            minIndex = i;
         }
      }//end for loop
      return minIndex;
   }//end minIndex
      
   public static boolean isDescending(int[] array) {
    for (int i = 1; i < array.length; i++) {
        if (array[i - 1] < array[i]) {//if an array at x position has less value than the next position then it is false
            return false; // Not in descending order
        }
    }
    return true; // In descending order
   }//end isDescending
   
   public static int numOfElements(int array[]){      //this determines the number of elements in the array
      int num = 0;
      for (int i=0;i<array.length;i++){
         num++;
      }//end for loop
      
      return num;
   }//end numOfElements
}