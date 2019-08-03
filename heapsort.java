import java.util.Scanner;

public class heapsort{
	
	public static void printarr(int arr[], int n){
		int i = 0;
		for(i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
		System.out.println("\n");
	}

	public static void heapify(int arr[], int l, int n){
		int largest = l;
		int right = 2*l + 2;
		int left = 2*l + 1;

		if(left < n && arr[largest] < arr[left])
			largest = left;
		if(right < n && arr[largest] < arr[right])
			largest = right;

		if(largest != l){
			int swap = arr[l];
			arr[l] = arr[largest];
			arr[largest] = arr[l];
			heapify(arr, largest, n);
		}
	}

	public static void heap_sort(int arr[]){
		int n = arr.length;

		for(int i = (n/2) - 1; i >= 0; i--)
			heapify(arr, i, n);

		for(int i = n-1; i >= 0; i--){
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			heapify(arr, 0, i);
		}
	}

	

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter Number of array elements : ");
		int n = sc.nextInt();
		int arr[] = new int [n];
		System.out.print("Enter Element : ");
		for(int i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		heapsort ob = new heapsort();
		ob.heap_sort(arr);
		printarr(arr, arr.length);
	}
}