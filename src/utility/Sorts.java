package utility;

import java.util.Arrays;
import java.util.Comparator;

public class Sorts 
{
	
	//BubbleSort
	public static <T extends Comparable<? super T>> void bubbleSort(T[] arr)
	{
		int i, j; 
		T temp;
        boolean swapped = false;
        for (i = 0; i < arr.length - 1; i++) 
        {
            swapped = false;
            for (j = 0; j < arr.length - i - 1; j++) 
            {
            	if(arr[j].compareTo(arr[j+1]) > 0)
            	{
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            if (swapped == false)
                break;       
        }
    }
	
	public static <T> void bubbleSort(T[] arr, Comparator<? super T> c)
	{
		int i, j; 
		T temp;
        boolean swapped;
        for (i = 0; i < arr.length - 1; i++) 
        {
            swapped = false;
            for (j = 0; j < arr.length - i - 1; j++) 
            {
            	if(c.compare(arr[j], arr[j+1]) > 0)
            	{
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            if (swapped == false)
                break;
        }
	}
	
	
	//InsertionSort
	public static <T extends Comparable<? super T>> void insertionSort(T[] arr) 
	{
        for (int i = 1; i < arr.length; i++) 
        {
            T key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j].compareTo(key) > 0) 
            {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
	
    public static <T> void insertionSort(T[] arr, Comparator<? super T> c) 
    {
        for (int i = 1; i < arr.length; i++) 
        {
            T key = arr[i];
            int j = i - 1;

            while (j >= 0 && c.compare(arr[j], key) > 0) 
            {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
    
    
    //SelectionSort
    public static <T extends Comparable<? super T>> void selectionSort(T[] arr) 
    {
        for (int i = 0; i < arr.length - 1; i++) 
        {
            int minIndex = i;

            for (int j = i + 1; j < arr.length; j++) 
            {
                if (arr[j].compareTo(arr[minIndex]) < 0) 
                {
                    minIndex = j;
                }
            }

            if (minIndex != i) 
            {
                T temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }
    
    public static <T> void selectionSort(T[] arr, Comparator<? super T> c) 
    {
        for (int i = 0; i < arr.length - 1; i++) 
        {
            int minIndex = i;

            for (int j = i + 1; j < arr.length; j++) 
            {
                if (c.compare(arr[j], arr[minIndex]) < 0) 
                {
                    minIndex = j;
                }
            }

            if (minIndex != i) 
            {
                T temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }
    
    
    //MergeSort
    public static <T extends Comparable<? super T>> void mergeSort(T[] arr) 
    {
    	if (arr == null || arr.length <= 1) 
    	{
    		return;
    	}

    	int mid = arr.length / 2;
    	T[] left = Arrays.copyOfRange(arr, 0, mid);
    	T[] right = Arrays.copyOfRange(arr, mid, arr.length);

    	mergeSort(left);
    	mergeSort(right);

    	merge(arr, left, right);
    }
    private static <T extends Comparable<? super T>> void merge(T[] arr, T[] left, T[] right) 
    {
    	int i = 0, j = 0, k = 0;

    	while (i < left.length && j < right.length) 
    	{
    		if (left[i].compareTo(right[j]) <= 0) 
    		{
    			arr[k++] = left[i++];
    		} 
    		else 
    		{
    			arr[k++] = right[j++];
    		}
    	}

    	while (i < left.length) 
    	{
    		arr[k++] = left[i++];
    	}

    	while (j < right.length) 
    	{
    		arr[k++] = right[j++];
    	}
    }
    public static <T> void mergeSort(T[] arr, Comparator<? super T> c) 
    {
    	if (arr == null || arr.length <= 1) {
    		return;
    	}

    	int mid = arr.length / 2;
    	T[] left = Arrays.copyOfRange(arr, 0, mid);
    	T[] right = Arrays.copyOfRange(arr, mid, arr.length);

    	mergeSort(left, c);
    	mergeSort(right, c);

    	merge(arr, left, right, c);
    }
    private static <T> void merge(T[] arr, T[] left, T[] right, Comparator<? super T> c) 
    {
    	int i = 0, j = 0, k = 0;

    	while (i < left.length && j < right.length) 
    	{
    		if (c.compare(left[i], right[j]) <= 0) 
    		{
    			arr[k++] = left[i++];
    		} 
    		else 
    		{
    			arr[k++] = right[j++];
    		}
    	}

    	while (i < left.length) 
    	{
    		arr[k++] = left[i++];
    	}

    	while (j < right.length) 
    	{
    		arr[k++] = right[j++];
    	}
    }
    
    
    //QuickSort
    public static <T extends Comparable<? super T>> void quickSort(T[] arr) 
    {
        quickSort(arr, 0, arr.length - 1);
    }
    private static <T extends Comparable<? super T>> void quickSort(T[] arr, int low, int high) 
    {
        if (low < high) 
        {
            int partitionIndex = partition(arr, low, high);

            quickSort(arr, low, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, high);
        }
    }
    
    
    private static <T extends Comparable<? super T>> int partition(T[] arr, int low, int high) 
    {
        T pivot = arr[high];

        int i = low - 1;

        for (int j = low; j < high; j++) 
        {
            if (arr[j].compareTo(pivot) <= 0) 
            {
                i++;

                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);

        return i + 1;
    }
    public static <T> void quickSort(T[] arr, Comparator<? super T> c) 
    {
        quickSort(arr, 0, arr.length - 1, c);
    }
    private static <T> void quickSort(T[] arr, int low, int high, Comparator<? super T> c) 
    {
        if (low < high) 
        {
            int partitionIndex = partition(arr, low, high, c);

            quickSort(arr, low, partitionIndex - 1, c);
            quickSort(arr, partitionIndex + 1, high, c);
        }
    }
    
    private static <T> int partition(T[] arr, int low, int high, Comparator<? super T> c) 
    {
        T pivot = arr[high];

        int i = low - 1;

        for (int j = low; j < high; j++) 
        {
            if (c.compare(arr[j], pivot) <= 0) 
            {
                i++;

                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);

        return i + 1;
    }
    
    private static <T> void swap(T[] arr, int i, int j) 
    {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    
    
    //HeapSort
	public static <T extends Comparable<? super T>> void heapSort(T[] arr) 
	{
        int n = arr.length;

        // Build heap
        for (int i = n / 2 - 1; i >= 0; i--) 
        {
            heapify(arr, n, i);
        }

        // One by one extract an element from heap
        for (int i = n - 1; i >= 0; i--) 
        {
            // Move current root to end
            T temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    // To heapify a subtree rooted with node i which is an index in arr[]. n is size of heap
    public static <T extends Comparable<? super T>> void heapify(T[] arr, int n, int i) 
    {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // left = 2*i + 1
        int right = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (left < n && arr[left].compareTo(arr[largest]) > 0) 
        {
            largest = left;
        }

        // If right child is larger than largest so far
        if (right < n && arr[right].compareTo(arr[largest]) > 0) 
        {
            largest = right;
        }

        // If largest is not root
        if (largest != i) 
        {
            T swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }

    public static <T> void heapSort(T[] arr, Comparator<? super T> c) 
    {
        int n = arr.length;

        // Build heap
        for (int i = n / 2 - 1; i >= 0; i--) 
        {
            heapify(arr, n, i, c);
        }

        // One by one extract an element from heap
        for (int i = n - 1; i >= 0; i--) 
        {
            // Move current root to end
            T temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify(arr, i, 0, c);
        }
    }
    // To heapify a subtree rooted with node i which is an index in arr[]. n is size of heap
    public static <T> void heapify(T[] arr, int n, int i, Comparator<? super T> c) 
    {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // left = 2*i + 1
        int right = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (left < n && c.compare(arr[left], arr[largest]) > 0) 
        {
            largest = left;
        }

        // If right child is larger than largest so far
        if (right < n && c.compare(arr[right], arr[largest]) > 0) 
        {
            largest = right;
        }

        // If largest is not root
        if (largest != i) 
        {
            T swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest, c);
        }
    }
}


