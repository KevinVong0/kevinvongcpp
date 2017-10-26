

/*
	A class implementing an ADT QUEUE using a single linked node
	@author Kevin Vong
	@version 1.0
 */
public class SLDeque<T> /* implements DequeInterface<T> */  {

	private Node<T> head;
	private Node<T> tail;
	
	public SLDeque() {
		
		head = null; // head pointer to null
		tail = null; // tail pointer to null
	}
	
	public void addToFront(T newEntry) {
		
		if (head == null) {
			Node<T> node1 = new Node<T>(newEntry);
			head = node1; 
			tail = node1; // if there is no head, make newEntry both head and tail
		}
		else {
			Node<T> node1 = new Node<T>(newEntry);
			head.setNext(node1); // move pointer to new head
			head = node1;
		}
		
	}

	public void addToBack(T newEntry) {
		if (tail == null) {
			Node<T> node1 = new Node<T>(newEntry);
			head = node1; // if tail, make newEntry both head and tail
			tail = node1;
 		}
		else {
			Node<T> node1 = new Node<T>(newEntry);
			node1.setNext(tail); // move pointer to new tail
			tail = node1;
		}
	}

	
	public T removeFront() throws EmptyQueueException { //fix me
		if(isEmpty()) throw new EmptyQueueException("This queue is empty.");
		
		if (head == tail) {
			T tmp = head.getData(); //set tmp as head's data, can also be tail.getData();
			head = null; // head to null
			tail = null; // tail to null
			return tmp; // return data removed
		}
		else { //examine this
			T tmpData = head.getData(); // set tmpData as head
			head = null; // head to null
			
			Node<T> tmpNext = tail; //set tmpNext as tail
			
			while (tmpNext.getNext() != head) { // if next node != head pointer, tmpNext will move on
				tmpNext = tmpNext.getNext();
			}
			
			tmpNext.setNext(null);
			head = tmpNext;
			
			return tmpData;
		}
		
	} 

	//examine this
	public T removeBack() throws EmptyQueueException{ 
		if(isEmpty()) throw new EmptyQueueException("This queue is empty.");
		
		if (head == tail) { 
			T tmpData = tail.getData(); //set tmpData as tail's data, can also be head.getData();
			head = null; // head to null
			tail = null; // tail to null
			return tmpData; // return data removed
		}
		
		else {
			T data = tail.getData(); // put tail's data into variable
			tail.setData(null); // make tail data to null
			
			Node<T> tmpNext = tail; // new node as tail
			tail = tail.getNext(); // point at next
			tmpNext.setNext(null); // set tmp's next to null
			
			return data; // returns data removed
		}
	}

	
	public T getFront() throws EmptyQueueException {
		if (isEmpty()) throw new EmptyQueueException("This queue is empty.");
			
		return head.getData(); // returns data of head
	}


	public T getBack() throws EmptyQueueException {
		if (isEmpty()) throw new EmptyQueueException("This queue is empty.");

		return tail.getData(); // returns data of tail
	}

	public boolean isEmpty() {	
		return (head == null && tail == null); // true if both are null
	}


	public void clear() {
		head = null; // make both head and tail to nullv
		tail = null;
		
	}

}
