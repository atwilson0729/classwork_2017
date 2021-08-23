package DataStructures;

import java.util.Arrays;

/**
 * SortingComp.java
 * @author Lewis/Chase, modified by Perez Quinones and Latulipe
 */

public class Searching<T> {

   /********************************************************************
     Searches the specified array of objects using a linear search
     algorithm.
     * @param data
   ********************************************************************/
   public static <T extends Comparable> boolean linearSearch (T[] data, T target)
   {
      int index = 0;
      int max = data.length;
      boolean found = false;

      while (!found && index < max) 
      {
         if (data[index] == null) break;
         if (data[index].compareTo(target) == 0) 
            found = true;
         index++;
      }

      return found;
   }
   
   /********************************************************************
     Searches the specified array of objects using a linear search
     algorithm.
     * @param data
   ********************************************************************/
   public static <T extends Comparable> T linearSearch2 (T[] data, T target)
   {
      T element = null;
      int index = 0;
      int max = data.length;
      boolean found = false;

      while (!found && index < max) 
      {
         if (data[index] == null) break;
         if (data[index].compareTo(target) == 0) {
            element = data[index];
            found = true;
         }
         index++;
      }

      return element;
   }

   public static <T extends Comparable> int[] linearSearch3 (T[] data, T target)
   {
       // TODO: complete this version of linearSearch
       // It must return an int array that contains only the indices where the target
       // was found in the data array. So, if the target is found 3 times,
       // an array of length 3, containing 3 ints, should be returned. Pseudocode below
       
       
       /* Pseudocode for linearSearch3
            - create an indices array the same size as the passed in data array
                (worst case scenario is that every item matches the target)
            - keep an indices counter of the number of indices copied in (# of target matches)
            - loop through the entire data array
                if at any point array slot contains null, break out of loop
                if array references an element that matches target, copy *index*  
                    into the indices array, and increment indices counter
            - when done going through data array, if indices counter is not 0, need to create a
               smaller array the exact size of the number of matches
                copy the indices into the smaller array and return it.
            - if indices counter is 0 (no matches) return null 
       */
       int [] indices = new int[data.length];
       int indi = 0;
       for (int i =  0; i < data.length; i++)
       {
           if (data[i] == null)
           {
               break;
           }
           if (data[i].compareTo(target) == 0) {
               indices[i] = i;
               indi++;
           }
       }
       int [] matches = new int[indi];
       int prev = 0;
       for (int i = 0; i < matches.length; i++)
       {
           for (int j = prev; j < indices.length; j++)
           {
               if (indices[j] != 0)
               {
                   matches[i] = indices[j];
                   prev = j;
               }
           }
       }
       
       return matches; 
}
   

}
