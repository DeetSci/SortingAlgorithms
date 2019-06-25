package Sort;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Sorting {
     
    private int[] array;
    private int[] tempArr;
    private int   length;
	private int[] sortArray;
	private int[] sortArray2;
    
    public static void main(String args[])
    {
    		new Sorting().testSort();
    }
    
    @SuppressWarnings("resource")
	public void testSort()
    {
    		System.out.println("Welcome to Sorting");
    		System.out.println();
    		System.out.println("Please specify length of Array(To be filled by Random Integers.");
    		
    		System.out.println("Specify Length of Array, Max 100.");
            Scanner sc = new Scanner(System.in);
            int j = sc.nextInt();
            sortArray = new int[j];
            if (j < 101)
            {
            		for(int i = 0; i < sortArray.length; i++)
            		{
            			Random rand = new Random();
            			sortArray[i] = rand.nextInt(99)+1;
            		}
            } else {
            		System.out.println("Please select integer between 1-100.");
            		testSort();
            }
            new Sorting().start(sortArray);
    }
    @SuppressWarnings("resource")
    public void start(int [] sortArray)
    	{
    		sortArray2 = sortArray.clone();
    		
    		System.out.println("Array Before Sorting:");
		System.out.println(Arrays.toString(sortArray));
		
    		System.out.println("Please choose an option");
    		System.out.println("1: Selection Sort");
    		System.out.println("2: Merge Sort");
    		System.out.println("3: Voidswap");
    		System.out.println("4: Quit");
    		
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
        switch (choice) 
        { 
        		case 1: 
        			selectionSort(sortArray, sortArray2); 
        			break; 
        		case 2:
        			mergeSort(sortArray, sortArray2);
        			break;
        		case 3:
        			voidSwap(sortArray, sortArray2);
        			break;
        		case 4:
        			System.out.println("Termination");
        			System.exit(0);
        			break;
        }
    	}

	public void selectionSort(int[] sortArray, int [] sortArray2)
    {
		sSort(sortArray2);
        
    		System.out.println("Array After Selection Sorting:");
    		System.out.println(Arrays.toString(sortArray2));
    	
    		new Sorting().start(sortArray);
    }
    
    void sSort(int[] sortArray2)
    { 
        int n = sortArray2.length; 

        for (int i = 0; i < n-1; i++) 
        {
            int min_idx = i; 
            for (int j = i+1; j < n; j++) 
                if (sortArray2[j] < sortArray2[min_idx]) 
                    min_idx = j; 

            int temp = sortArray2[min_idx]; 
            sortArray2[min_idx] = sortArray2[i]; 
            sortArray2[i] = temp; 
        }
    }
    
    public void mergeSort(int[] sortArray, int [] sortArray2)
    {
        mSort(sortArray2);
        
        	System.out.println("Array After Merge Sorting:");
        	System.out.println(Arrays.toString(sortArray2));
        	
        	new Sorting().start(sortArray);
    }
     
    private void mSort(int inputArr[])
    {
        this.array = inputArr;
        this.length = inputArr.length;
        this.tempArr = new int[length];
        doMergeSort(0, length - 1);
    }
 
    private void doMergeSort(int smaller, int greater)
    {
         
        if (smaller < greater)
        {
            int middle = smaller + (greater - smaller) / 2;
            doMergeSort(smaller, middle);
            doMergeSort(middle + 1, greater);
            mergeParts(smaller, middle, greater);
        }
    }
 
    private void mergeParts(int smaller, int middle, int greater)
    {
 
        for (int i = smaller; i <= greater; i++)
        {
            tempArr[i] = array[i];
        }
        int i = smaller;
        int j = middle + 1;
        int k = smaller;
        while (i <= middle && j <= greater)
        {
            if (tempArr[i] <= tempArr[j])
            {
                array[k] = tempArr[i];
                i++;
            } else {
                array[k] = tempArr[j];
                j++;
            }
            k++;
        }
        while (i <= middle)
        {
            array[k] = tempArr[i];
            k++;
            i++;
        }
    }
    
    public void voidSwap(int[] sortArray, int[] sortArray2) 
    {
    		vSwap(sortArray2);
        
    		System.out.println("Array After Merge Sorting:");
    		System.out.println(Arrays.toString(sortArray2));
    	
    		new Sorting().start(sortArray);
    }
    
    @SuppressWarnings("resource")
	private void vSwap(int[] sortArray2)
    {
    		System.out.println("Please specify which two Indices to switch:");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("First Index:");
		int firstIndex = sc.nextInt();
		System.out.println("Second Index:");
		int secondIndex = sc.nextInt();
		
		int swap1 = sortArray2[firstIndex];
		int swap2 = sortArray2[secondIndex];
		
		sortArray2[secondIndex] = swap1;
		sortArray2[firstIndex] = swap2;
    }
}