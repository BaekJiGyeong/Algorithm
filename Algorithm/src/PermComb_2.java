import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PermComb_2 {
	static int N = 0;
	static int R = 0;
	
	static String pre="";
	static String now="";
	static Queue q = new LinkedList<String>();
	static int[] arr;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		
		// 1~N 까지 사용
		arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] =sc.nextInt();
		}
		
		// method 시작
		combination(0, new int[R]);
		
		System.out.println(q.size());
		for (Object ob : q) {
			System.out.println(ob);
		}
	}
	
	static void combination(int depth, int comArr[]) {
		
		// 마지막 depth면 큐에 담음
		if(depth==R) {
			now="";
			for (int i : comArr) {
				now = now+i;
			}
			
			// 이전에 담긴 수와 같으면 return false
			if(!"".equals(pre)&&Integer.parseInt(pre)>Integer.parseInt(now)) {}
			else if(!pre.equals(now)) {
				q.add(now);
				pre = now;
			}
		}
		else {
			// for문을 돌면서  N개중 1개씩 뽑음
			// 만약 이전 수보다 작아질 경우 그 십의 자리수는 skip\
			for(int i=0; i<N; i++) {
				comArr[depth] = arr[i];
				combination(depth+1, comArr);
			}
		}
	}
}
