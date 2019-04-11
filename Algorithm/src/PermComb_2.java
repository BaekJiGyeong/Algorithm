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
		
		// 1~N ���� ���
		arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] =sc.nextInt();
		}
		
		// method ����
		combination(0, new int[R]);
		
		System.out.println(q.size());
		for (Object ob : q) {
			System.out.println(ob);
		}
	}
	
	static void combination(int depth, int comArr[]) {
		
		// ������ depth�� ť�� ����
		if(depth==R) {
			now="";
			for (int i : comArr) {
				now = now+i;
			}
			
			// ������ ��� ���� ������ return false
			if(!"".equals(pre)&&Integer.parseInt(pre)>Integer.parseInt(now)) {}
			else if(!pre.equals(now)) {
				q.add(now);
				pre = now;
			}
		}
		else {
			// for���� ���鼭  N���� 1���� ����
			// ���� ���� ������ �۾��� ��� �� ���� �ڸ����� skip\
			for(int i=0; i<N; i++) {
				comArr[depth] = arr[i];
				combination(depth+1, comArr);
			}
		}
	}
}