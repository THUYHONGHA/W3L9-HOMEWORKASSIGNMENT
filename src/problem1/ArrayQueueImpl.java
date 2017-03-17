package problem1;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class ArrayQueueImpl {

	private int[] arr;
	private int front;
	private int rear;

	public ArrayQueueImpl() {
		arr = new int[10];
		front = -1;
		rear = 0;
	}

	public int peek() {
		if (rear == 0){
			System.out.print("Queue is empty ");
			return -1;
		}
			
		else {
			front = 0;
			return arr[front];
		}
	}

	public void enqueue(int obj) {
		if (rear == arr.length) {
			resize();
		}
		arr[rear] = obj;		
		rear++;

	}

	public int dequeue() {
		if (rear == 0){			
			System.out.print("Queue is empty ");
			return -1;
		} else {
			front = 0;
			--rear;
			int temp=arr[0];
			int[] newArr = new int[arr.length];
			newArr = Arrays.copyOfRange(arr, front+1, rear);
			arr = newArr;
			return temp;
		}

	}

	public boolean isEmpty() { // implement
		if (rear == 0)
			return true;
		return false;
	}

	public int size() {
		return rear;
	}

	public void resize() {
		int resize = arr.length+1;
		arr = Arrays.copyOf(arr, resize);
	}
	
	public static void main(String[] args) {
		
		ArrayQueueImpl aq = new ArrayQueueImpl();
		System.out.println("Peek: "+aq.peek());
		System.out.println("Deleted: "+aq.dequeue());
		System.out.println("Array is empty? " + aq.isEmpty());
		aq.enqueue(10);
		aq.enqueue(20);
		aq.enqueue(19);
		System.out.println(aq.size());
		System.out.println("Peek "+aq.peek());
		aq.enqueue(40);
		aq.enqueue(40);
		aq.enqueue(40);
		aq.enqueue(40);
		aq.enqueue(40);
		aq.enqueue(447);
		aq.enqueue(19);
		aq.enqueue(41);
		aq.enqueue(42);
		System.out.println("Array is empty? " + aq.isEmpty());
		System.out.println("List members in array: ");
		for(int test: aq.arr){
			System.out.println(test);
		}
		System.out.println("Array Size before delete: "+aq.size());
		System.out.println("Number was deleted: "+aq.dequeue());
		System.out.println("Array Size "+aq.size());
		System.out.println("After using dequeue:");
		for(int test: aq.arr){
			System.out.println(test);
		}
		
	}

}
