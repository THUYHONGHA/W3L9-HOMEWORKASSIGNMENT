package problem2;

interface Stack1 {
	public void push(Object ob);

	public Object pop();

	public Object peek();

	public boolean isEmpty();

	public int size();
}

class NodeStack {
	public NodeStack prev;
	public NodeStack next;
	public Object value;

	public NodeStack(NodeStack prev, Object value, NodeStack next) // constructor
	{
		this.prev = prev;
		this.value = value;
		this.next = next;
	}

	public String toString() {
		return (String) value;
	}
}

public class LinkedListStack implements Stack1 {
	public NodeStack header;
	private int top;

	public LinkedListStack() {
		header = null;
		top = -1; // no items in the stack
	}

	public void push(Object item) // add an item on top of stack
	{
		if (header == null) {
			header = new NodeStack(null, item, null);
		} else {
			NodeStack temp = header;
			while (temp.next != null) {
				temp = temp.next;
			}
			NodeStack n = new NodeStack(temp, item, null);
			temp.next = n;
			temp = n;
		}
		top++; // increment top
	}

	public Object pop() // remove an item from top of stack
	{
		if (isEmpty()) {
			System.out.print("Stack is empty. ");
			return null;
		}
		NodeStack temp = header;
		while (temp.next != null) {
			temp = temp.next;
		}
		Object result = temp.value;
		temp = temp.prev;
		temp.next = null;
		top--; // decrement top		
		return result;
	}

	public Object peek() // get top item of stack
	{
		if (isEmpty()){
			System.out.print("Stack is empty. ");
			return null;
		}
		NodeStack temp = header;
		while (temp.next != null) {
			temp = temp.next;
		}
		return temp.value;
	}

	public boolean isEmpty() // true if stack is empty
	{
		return (top == -1);
	}

	public int size() // returns number of items in the stack
	{
		return top + 1;
	}

	public String toString() {
		String str = "";
		NodeStack temp = header;
		while (temp != null) {
			str = str + "-->[" + temp.value.toString() + "]";
			temp = temp.next;
		}
		str = str + "-->[" + "NULL" + "]";
		return str;
	}

	public static void main(String[] args) {
		LinkedListStack stk = new LinkedListStack();
		System.out.println(stk.peek());
		System.out.println(stk.pop());
		stk.push('A');
		stk.push("abc");
		stk.push(123);
		System.out.println(stk);
		System.out.println("size(): " + stk.size());
		System.out.println("Peek value: " + stk.peek());
		System.out.println(stk.pop()+" was deleted.");
		System.out.println(
				"Linkedlist after call pop method: " + stk + "\nPeek now is: " + stk.peek() + "\nSize: " + stk.size());
		
	}

}
