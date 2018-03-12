package partitionlinkedlist;

public class PartitionLinkedList {
	// solution 1
	LinkedListNode Partition (LinkedListNode node, int x ){
		LinkedListNode beforeStart = null;
		LinkedListNode beforeEnd = null;
		LinkedListNode afterStart = null;
		LinkedListNode afterEnd = null;
		
		while( node != null){
			LinkedListNode next = node.next;
			node.next = null;
			if ( node.data < x){
				if (beforeStart == null){
					beforeStart = node;
					beforeEnd = beforeStart;					
				}else {
					beforeEnd.next = node;
					beforeEnd = node;		
				}
			} else {
				if (afterStart == null){
					afterStart = node;
					afterEnd = afterStart;
				}else {
					afterEnd.next = node;
					afterEnd = node;
				}
				
			}
			node = next; 
		}
		
		if (beforeStart == null){
			return afterStart;
		}
		
		beforeEnd.next = afterStart;
		return beforeStart;
	}
	
	// solution 2
	LinkedListNode Partition2(LinkedListNode node, int x){
		LinkedListNode head = node; 
		LinkedListNode tail = node; 
		
		while (node != null){
			if (node.data < x){
				node.next = head; 
				head = node; 
			} else {
				tail.next = node;
				tail = node;
			}
			node = node.next;
		}
		tail.next = null;
		return head; 		
	}
}
