import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Problem2751_Radix {

	public static void main(String[] args) throws IOException {

		// 1. ���� ����
		Queue<Integer> pQue = new LinkedList();
		Queue<Integer> nQue = new LinkedList();
		int pArr[] = null; // ���
		int nArr[] = null; // ����
		int N = 0;
		
		Scanner sc = new Scanner(System.in);

		// 2. �Է��� ��ĵ����
		N = sc.nextInt();
		
		int input = 0;
		int idx = 0;
		while (idx < N) {
			
			input = sc.nextInt();
			
			if(input < 0) nQue.add(input);
			else pQue.add(input);
			
			idx++;
		}
		
		
		pArr = new int[pQue.size()];
		nArr = new int[nQue.size()];
		
		for(int i=0; i<pArr.length; i++) {
			pArr[i] = pQue.poll();
		}
		for(int i=0; i<nArr.length; i++) {
			nArr[i] = nQue.poll();
		}
		
		// radixSort ����
		pArr = radixSort(pArr);
		nArr = radixSort(nArr);

		StringBuilder sb = new StringBuilder();
		
		// ���� ����
		for(int i=nArr.length-1; i>=0; i--) {
			sb.append((int)nArr[i]+"\n");
		}
		
		// ��� ����
		for (Integer i : pArr) {
			sb.append((int) i + "\n");
		}
		
		System.out.println(sb);
	}

	static int[] radixSort(int[] arr) {
		
		int sortArr[] = new int[arr.length];
		int queSize, max_length = 0;
		int lenght = 0;
		int idx= 0;
		
		Map<Integer, Queue> map = new HashMap<>();
		
		for (int l : arr) {
			lenght = (int) Math.log10(Math.abs(l))+1;
			if(max_length < lenght) {
				max_length = lenght;
			}
		}
		
		// map �ʱ� ����
		for (int j = 0; j < 10; j++) {
			map.put(j, new LinkedList<Integer>());
		}

		// �ִ� �ڸ��� ��ŭ �ݺ�
		for (int i = 0; i < max_length; i++) {

			// map �ʱ�ȭ
			for (int j = 0; j < 10; j++) {
				map.get(j).clear();
			}

			for (int j = arr.length - 1; j >= 0; j--) { // �迭�� �ں��� Hash Map�� �ε����ؼ� ����
				map.get((int) (Math.abs(arr[j]) / Math.pow(10, i) % 10)).add(arr[j]);
			}

			// 4. 9���� Map���� ���� sortArr�� ����
			idx = arr.length - 1;
			for (int j = 9; j >= 0; j--) {

				queSize = map.get(j).size();
				for (int qIdx = 0; qIdx < queSize; qIdx++) {
					sortArr[idx] = (Integer) map.get(j).poll();
					idx--;
				}
			}

			// 5. arr�� sortArr ����
			System.arraycopy(sortArr, 0, arr, 0, arr.length);
		}
		return arr;
	}
}