/*
	A class implementing an ADT QUEUE using a doubly linked node
	@author Kevin Vong
	@version 1.0
 */

public class DLDeque<T> implements DequeInterface<T> {

	private DLNode<T> head;				// pointer to beginning of line
	private DLNode<T> tail;				// pointer to end of line
	
	public DLDeque() {
		head = null; // point to null
		tail = null; // point to null
	}
		
	public void addToFront(T newEntry) {
		
		DLNode<T> node = new DLNode<T>(newEntry);
		node.setNext(head); // set head as next for the new node
		if (head == null) {
			tail = node; // tail to point at new node
		}
		else 
			head.setPrev(node); // set prev for old head to node
		
		head = node; // head points to node	
	}


	public void addToBack(T newEntry) {
		DLNode<T> node = new DLNode<T>(newEntry);
		node.setPrev(tail); // set tail as prev for the new node
		if (tail == null) {
			head = node; // sets node as head
		}
		else 
			tail.setNext(node); // sets the next to node for the  previous tail
		
		tail = node; // sets new node as tail
	}


	public T removeFront() throws EmptyQueueException {

		if(isEmpty()) throw new EmptyQueueException("This queue is empty.");
		
		DLNode<T> tmpHead = head.getNext(); // sets tmpHead to point at head's next
		if (tmpHead == null) {
			tail = null; // tail to null
			T tmpData = head.getData(); // get head's data
			head = tmpHead; // set tmpHead as new head
			
			return tmpData; // return data removed
		}
		else {
			tmpHead.setPrev(null); //set previous for tmpHead to null
			T tmpData = head.getData(); // get data from head
			head = tmpHead; // set tmpHead as new head
			
			return tmpData; // return data removed
		}
	}
	

	
	public T removeBack() throws EmptyQueueException {

		if(isEmpty()) throw new EmptyQueueException("This queue is empty.");
		
		DLNode<T> tmpTail = tail.getPrev(); // new tail to get old tail's prev node
		if (tmpTail == null) { 
			head = null; // head to null
			T tmpData = tail.getData(); // get data from tail
			tail = tmpTail; // put tmpTail as the new tail
			
			return tmpData; // return data removed
		}
		else {
			tmpTail.setNext(null); // set the next for tmpTail as null
			T tmpData = tail.getData(); // get data from tail
			tail = tmpTail; // tmpTail as new tail
			
			return tmpData; // return data removed
		}
	}


	public T getFront() throws EmptyQueueException {
		if(isEmpty()) throw new EmptyQueueException("This queue is empty.");
		
		return head.getData(); // return data of head
	}


	public T getBack() throws EmptyQueueException {
		if (isEmpty()) throw new EmptyQueueException("This queue is empty.");

		return tail.getData(); // returns data of tail
	}


	public boolean isEmpty() {
		return (head == null && tail == null); // true if both are null
	}


	public void clear() {
		head = null; // make both head and tail pointer to null
		tail = null;
		
	}
	

}
