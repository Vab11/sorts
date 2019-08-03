import java.util.Scanner;

public class mergesort{
	public static void printarr(int arr[], int n){
		int i = 0;
		for(i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
		System.out.println("\n");
	}

	public static void merge(int arr[], int l, int m, int r){
		int i, j, k = l;

		int n1 = m - l + 1;
		int n2 = r - m;
		int L[] = new int [n1];
		int R[] = new int [n2];

		for(i = 0; i < n1; i++)
			L[i] = arr[l + i];
		for(i = 0; i < n2; i++)
			R[i] = arr[m + 1 + i];

		i = 0; j = 0;

		while(i < n1 && j < n2){
			if(L[i] <= R[j])
				arr[k++] = L[i++];
			else
				arr[k++] = R[j++];
		}

		while(i < n1)
			arr[k++] = L[i++];
		while(j < n2)
			arr[k++] = R[j++];
	}

	public static void merge_sort(int arr[], int l, int r){
		int mid;
		if(l < r){
			mid = (l+(r-1))/2;
			merge_sort(arr, l, mid);
			merge_sort(arr, mid+1, r);
			merge(arr, l, mid, r);
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
		mergesort ob = new mergesort();
		ob.merge_sort(arr, 0, arr.length - 1);
		printarr(arr, arr.length);

	}
}