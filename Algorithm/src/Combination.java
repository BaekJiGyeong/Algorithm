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
		
		// 1~N ���� ���
		arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] =sc.nextInt();
		}
		
		// ���� method ����
		combination();
		
		System.out.println(q.size());
		for (Object ob : q) {
			System.out.println(ob);
		}
	}
	
	static void combination() {
		
		
		// for���� ���鼭  N���� 1���� ����
		// ���� ���� ������ �۾��� ��� �� ���� �ڸ����� skip\
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				for(int k=0; k<N; k++) {
					
					now = ""+arr[i]+arr[j]+arr[k];
					
					// ������ ��� ���� ������ return false
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
