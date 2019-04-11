import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class PermComb_1 {
	static int N = 0;
	static int R = 0;
	static Queue combList = new LinkedList<String>();
	static Set<String> permList = new HashSet<String>();
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		
		// 1~N 까지 사용
		int arr[] = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] =sc.nextInt();
		}
		

		// (조합) 중복되지 않는 수 조합을 찾는다
		combination(arr, R, 0, 0, new int[3]);
		
		String[] combArr = new String[combList.size()];
		int idx = 0;
		while(!combList.isEmpty()) {
//			System.out.println(combList.peek());
			combArr[idx++] = (String) combList.poll();
		}
		System.out.println("=========================");

		
		// (순열) 조합 리스트에서 나올수 있는 순열을 출력한다.
		String[] combString = new String[R];
		for(int i=0; i<combArr.length; i++) {
			combString = combArr[i].split("");
			permutation(combString,0);	
		}
		
		System.out.println(permList.size());
		List list = new ArrayList<>();
		
		for (String string : permList) {
			list.add(string);
			
		}
		Collections.sort(list);
		
		for (Object object : list) {
			System.out.println(object);
		}		
	}
	
	/*순열*/
	private static void permutation(String[] s, int depth) {
		String tt = "";
		for (String string : s) {
			tt = tt + string;
		}
//		System.out.println(tt);
		// if depth = r-1 일 경우 permList.add()
		if(depth==R-1) {
			String temp = "";
			for (String string : s) {
				temp = temp + string;
			}
			permList.add(temp);
		}
		else {
			for(int i=depth; i<R; i++) {
				swap(s,i,depth);
				permutation(s, depth+1);
				swap(s,depth,i);
			}
		}
	}
	
	private static void swap(String[] arr, int idx1, int idx2){
		String temp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = temp;
	}
	
	/*조합*/
	private static void combination(int[] arr, int r, int idx, int depth, int[] comb) {
		
		// for
		// idx = depth~(N-R+depth) // 0 : 0~2(5-3+0) / 1 : 1~3 / 2: 2~4
		for(int i= idx; i<=N-R+depth; i++) {
			// comb 배열에 idx 값을 담음
			comb[depth] = arr[i];
			// if depth = r-1  일 경우 combList.add()
			if(depth==R-1) {
				String combNum = "";
				for(int n=0; n<r; n++) {
					combNum = combNum + comb[n];
				}
				combList.add(combNum);
			}
			else {
				combination(arr, r, i+1, depth+1, comb);
			}
		}
	}
}
