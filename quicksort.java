import java.util.Scanner;

public class quicksort{
	public static void printarr(int arr[], int n){
		int i = 0;
		for(i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
		System.out.println("\n");
	}

	public static int partition(int arr[], int l, int r){
		int i = l - 1;
		int pivot = arr[r];

		for(int j = l; j < r; j++){
			if(arr[j] <= arr[pivot]){

				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		int temp = arr[i + 1];
		arr[i + 1] = arr[r];
		arr[r] = temp;

		return i + 1;

	}

	public static void quick_sort(int arr[], int l, int r){
		if(l < r){
			int part = partition(arr, l, r);

			quick_sort(arr, l, part - 1);
			quick_sort(arr, part + 1, r);
		}
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter Number of array elements : ");
		int n = sc.nextInt();
		int arr[] = new int [n];
		
		for(int i = 0; i < n; i++){
			System.out.print("Enter Element : ");
			arr[i] = sc.nextInt();
		}
		quicksort ob = new quicksort();
		ob.quick_sort(arr, 0, arr.length - 1);
		printarr(arr, arr.length);

	}
}