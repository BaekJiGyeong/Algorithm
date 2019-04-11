public class Stack {
	
	private Object[] stack ;
	private int size ;
	
	public Stack () {
		this.stack = new Object[0];
		this.size = 0;
	}
	
	public boolean push(Object param) {
		this.size++;
		
		Object[] temp = new Object[this.size];
		System.arraycopy(this.stack, 0, temp, 0, this.size-1);
		temp[this.size-1] = param;
		this.stack = temp;
		
		return true;
	}
	
	public Object pop () {
		Object temp = this.stack[this.size-1];
		stack[this.size-1] = null;
		this.size--;
		
		return temp;
	}
	
	public boolean isEmpty() {
		if(this.size==0) {
			return true;
		}
		else return false;
	}
	
	public Object peek() {
		return this.stack[this.size-1];
	}
	
	public int size() {
		return this.size;
	}
}