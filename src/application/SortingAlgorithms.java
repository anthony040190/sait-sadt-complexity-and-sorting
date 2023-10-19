package application;

public class SortingAlgorithms 
{
	public void bubbleSort(int[] array)
	{
		int n = array.length;
		
		for (int i = 0; i < n - 1; i++)
			for (int j = 0; j < n - i - 1; j++)
				if (array[j] > array[j + 1])
				{
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
	}
	
	public void quickSort(int[] array, int begin, int end)
	{
		if (begin < end)
		{
			int partitionIndex = partition(array, begin, end);
			
			quickSort(array, begin, partitionIndex - 1);
			quickSort(array, partitionIndex + 1, end);
		}
		
	}
	
	private int partition(int[] array, int begin, int end)
	{
		int pivot = array[end];
		int i = (begin - 1);
		for (int j = begin; j < end; j++)
		{
			if (array[j] < pivot)
			{
				i++;
				
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}
		
		int temp = array[i + 1];
		array[i + 1] = array[end];
		array[end] = temp;
		
		return i + 1;
	}
	
	public void insertionSort(int[] array)
	{
		int n = array.length;
		for (int i = 1; i < n; ++i)
		{
			int key = array[i];
			int j = i - 1;
			
			while ( j >= 0 && array[j] > key) 
			{
				array[j + 1] = array[j];
				j = j - 1;
			}
			
			array[j + 1] = key;
		}
		
	}
	
	public void selectionSort(int[] array)
	{
		int n = array.length;
		
		for (int i = 0; i < n-1; i++)
		{
			int min_index = i;
			for (int j = i+1; j < n; j++)
				if (array[j] < array[min_index])
					min_index=j;
			
			int temp = array[min_index];
			array[min_index] = array[i];
			array[i] = temp;
		}

	}
	
	public void mergeSort(int[] array) {
	}
	//Add another Sort
}
