
public class StackTest {
	public static void main(String[] args) {
		Stack st = new Stack();
		
		System.out.println("isEmpty : "+st.isEmpty()); // true
		
		st.push(1);
		
		System.out.println("isEmpty : "+st.isEmpty()); // false
		
		st.push(3);
		
		System.out.println("size : "+st.size()); // 2
		
		System.out.println("peek : "+st.peek()); // 3
		
		System.out.println("pop : "+st.pop()); // 3

		System.out.println("pop : "+st.pop()); // 1
		
		System.out.println("isEmpty : "+st.isEmpty()); // true
	}
}
