package reorderLinkedList;
class Solution {
    public void reorderList(ListNode head) {
//Edge case 
        if(head==null || head.next == null)
        {
            return;
        }
//Initialization of pointers
        ListNode slow = head;
        ListNode fast = head;
while (fast.next !=null && fast.next.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
//Reversing the linked list ahead of middel        
        
	fast = revereLinkedList(slow.next);
//   fast = revereLinkedList(slow);
//Initalization of pointers for merging the two lists created   
    
        slow.next = null; //As we will be reversing the linkedlist after middle
        slow = head;
        ListNode temp;
        
        while (slow!=null && fast!=null)
        {
            temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next=temp;
            slow = temp;
        }
    }       
        
        
// Defining a function for reversing a linked list
        
private ListNode revereLinkedList(ListNode head)
{
        
           ListNode prev = null;
           ListNode curr = head;
           ListNode fast = head.next;
        
        while(fast!=null)
        {
            curr.next = prev; 
            prev = curr;
            curr = fast;
            fast = fast.next;
        }
        
        curr.next = prev;
        return curr;
    }

void printList(ListNode head) 
{ 
    while (head != null) { 
        System.out.print(head.val + " "); 
        head = head.next; 
    } 
} 
        

	public static void main(String[] args) {
		ListNode list =  new ListNode(1);
		list.next =  new ListNode(2);
		list.next.next =  new ListNode(3);
		list.next.next.next =  new ListNode(4);
		list.next.next.next.next =  new ListNode(5);
		Solution obj = new Solution();
		System.out.println("Linked List before reordering ");
		obj.printList(list);
		obj.reorderList(list);
		System.out.println("Linked List after reordering ");
		obj.printList(list);



		

	}

}
