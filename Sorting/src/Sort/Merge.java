package Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;
import java.util.Random;

class Merge {

	private int[] array1;
	private int[] array2;
	private int[] mergeArray;
	int n1;
	int n2;
	
	public static void main(String[] args)
    {
		new Merge().start();
    }
	
	public void start() {
		
		System.out.println("Arrays before Merge: ");
		
//generates and prints out first sorted array
		array1 = generateSorted(10, 0, 100);
		System.out.println(Arrays.toString(array1));
		n1 = array1.length; 
		
//generates and prints out second sorted array
		array2 = generateSorted(10, 0, 100);
        System.out.println(Arrays.toString(array2));
        n2 = array2.length; 
        
        mergeArray = new int[n1+n2];
        
//generates and prints out merged array
        System.out.println("Array after Merge: ");
        mergeArrays(array1, array2, n1, n2, mergeArray);
        
		System.out.println(Arrays.toString(mergeArray));
	}
    
//method to merge arrays using existing sorted arrays
    public static void mergeArrays(int[] array1, int[] array2, int n1, 
            int n2, int[] mergeArray) 
    { 
    		int i = 0, j = 0, k = 0; 

//traverse through both arrays, comparing and adding to final array the smaller integer
    		while (i < n1 && j < n2) 
    		{ 
    			if (array1[i] < array2[j]) 
    				mergeArray[k++] = array1[i++]; 
    			else
    				mergeArray[k++] = array2[j++]; 
    		} 

//adding the remaining elements of the first array to final array
    		while (i < n1) 
    			mergeArray[k++] = array1[i++]; 

//adding the remaining elements of the second array to final array
    		while (j < n2) 
    			mergeArray[k++] = array2[j++];
    }
/* The following method was added to generate a sorted arrays,
* this is not apart of the merge function
* */
    
//method to generate a sorted array using parameters specified above
  	public static int[] generateSorted(final int length, final int minVal, final int maxVal)
    {
  		ArrayList<Integer> data = new ArrayList<>(length);
  		data.add(getRandomVal(minVal, maxVal));

  		boolean added;
  		for(int i = 0; i < length; i++)
  		{
              added = false;
              ListIterator<Integer> itr = data.listIterator();
              int rndNum = getRandomVal(minVal, maxVal);
              while(itr.hasNext() && !added)
              {
                  Integer currentNum = itr.next();
                  if(currentNum >= rndNum)
                  {
                      itr.previous();
                      itr.add(rndNum);
                      added = true;
                  }
              }

              if(!added)
                  data.add(rndNum);
  		}
  		return data.stream().mapToInt(i -> {
  			return i;
  		}).toArray();
      }

      private static int getRandomVal(int min, int max)
      {
          int n = max - min + 1;
          int i = rand.nextInt(n);
          return min + i;
      }
      final static private Random rand = new Random();
}