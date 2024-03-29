

import java.util.Scanner;

public class Problem2751_Heap {
	
	static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		// 0~N 까지 사용
		int[] arr = new int[N];
		
		int idx = 0;
		while (idx < N) {
			
			arr[idx] = sc.nextInt();
			idx++;
		}
		
		arr = heapSort(arr);
		
		for(int i=0; i<N; i++) {
			System.out.println(arr[i]);
		}
	}
	 
	static int[] heapSort(int[] arr) {
	    int n = arr.length;
	 
	    // 제일 마지막 부모노드부터 스캔하면서 부모가 제일 크도록 힙을 완성한다. (int)N/2-1
	    for (int i = n / 2 - 1; i >= 0; i--) {
	        heap(arr, i, n);
	    }
	    
	    // 하나씩 줄여가며 힙정렬한다.
	    for (int i = n - 1; i > 0; i--) {
	    	// 제일 꼭대기에 있는 노드를 제일 마지막과 스왑
	        swap(arr, 0, i);	        
	        
	        heap(arr, 0, i);
	    }
	    
	    return arr;
	}
	
	static void heap(int arr[], int i, int n) { // 배열, 루트노드, 마지막노드
	    // 부모노드
		int parent = i;
	    // 왼쪽 자식노드 = 부모노드 *2+1
	    int left = i*2 + 1;
	    // 오른쪽 자식노드 = 부모노드 *2+2
	    int right = i*2 + 2;
	 
	    if (left < n && arr[parent] < arr[left]) {
	        parent = left;
	    }	 
	    if (right < n && arr[parent] < arr[right]) {
	        parent = right;
	    }
	 
	    if (i != parent) {
	        swap(arr, parent, i);
	        heap(arr, parent, n);
	    }
	}
	 
	static void swap(int[] array, int a, int b) {
	    int temp = array[a];
	    array[a] = array[b];
	    array[b] = temp;
	}
}
