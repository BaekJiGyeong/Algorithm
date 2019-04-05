

import java.util.Scanner;

public class Problem2751_Heap {
	
	static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		// 0~N ���� ���
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
	 
	    // ���� ������ �θ������ ��ĵ�ϸ鼭 �θ� ���� ũ���� ���� �ϼ��Ѵ�. (int)N/2-1
	    for (int i = n / 2 - 1; i >= 0; i--) {
	        heap(arr, i, n);
	    }
	    
	    // �ϳ��� �ٿ����� �������Ѵ�.
	    for (int i = n - 1; i > 0; i--) {
	    	// ���� ����⿡ �ִ� ��带 ���� �������� ����
	        swap(arr, 0, i);	        
	        
	        heap(arr, 0, i);
	    }
	    
	    return arr;
	}
	
	static void heap(int arr[], int i, int n) { // �迭, ��Ʈ���, ���������
	    // �θ���
		int parent = i;
	    // ���� �ڽĳ�� = �θ��� *2+1
	    int left = i*2 + 1;
	    // ������ �ڽĳ�� = �θ��� *2+2
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