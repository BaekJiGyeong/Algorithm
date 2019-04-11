import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Combination {
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
		
		// 순열 method 시작
		combination();
		
		System.out.println(q.size());
		for (Object ob : q) {
			System.out.println(ob);
		}
	}
	
	static void combination() {
		
		
		// for문을 돌면서  N개중 1개씩 뽑음
		// 만약 이전 수보다 작아질 경우 그 십의 자리수는 skip\
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				for(int k=0; k<N; k++) {
					
					now = ""+arr[i]+arr[j]+arr[k];
					
					// 이전에 담긴 수와 같으면 return false
					if(!"".equals(pre)&&Integer.parseInt(pre)>Integer.parseInt(now)) break;
					else if(!pre.equals(now)) {
						q.add(now);
						pre = now;
					}
				}
			}
		}
	}
}
