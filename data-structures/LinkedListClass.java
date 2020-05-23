class LinkedList<T extends Comparable<T>>{

    private class Node<T extends Comparable<T>>{
        T value;
        Node next;

        Node(T value) {
            this.value = value;
            this.next = null;
        }

        public T getValue() {
            return value;
        }

        @SuppressWarnings("unused")
        public void setValue(T val) {
            this.value = val;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node n) {
            this.next = n;
        }

        public int compareTo(T value){
            return this.value.compareTo(value);
        }

    }

    private Node<T> head;
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    private void incrementSize() {
        size++;
    }

    private void decrementSize() {
        size--;
    }

    public void add(T value) {
        Node<T> newNode = new Node(value);
        if (head == null) {
            head = newNode;
            return;
        }
        Node<T> temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        temp.setNext(newNode);
        incrementSize();
    }

    public T delete(T value) {
        if (head.getValue() == value) {
            head = null;
            return null;
        }
        Node<T> temp = head;
        while (temp.getNext() != null) {
            if (temp.getNext().getValue() == value) {
                Node<T> n = temp.getNext();
                temp.setNext(n.getNext());
                decrementSize();
                return n.getValue();
            }
            temp = temp.getNext();
        }
        return null;
    }

    public void reverseList(){
        this.head = reverse(this.head);
    }
    
    private Node<T> reverse(Node<T> head) {
        if (head == null || head.getNext() == null)
            return head;
        Node<T> prev = null, curr = head, next=null;
        
        while(curr!=null){
            next = curr.getNext();
            curr.setNext(prev);
            prev= curr;
            curr=next;
        }
        head=prev;
        return prev;
    }

    public boolean findLoop() {
        if (head == null || head.getNext() == null)
            return false;
        Node fast = head.getNext(), slow = head;
        while (slow != null && fast != null && fast.getNext() != null) {
            if (slow == fast)
                return true;
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return false;
    }

    public void removeLoop(){
        if(head==null || head.getNext() == null)
            return;
            Node fast = head.getNext(), slow = head;
            while (slow != null && fast != null && fast.getNext() != null) {
                if (slow == fast)
                    break;
                  slow = slow.getNext();
                fast = fast.getNext().getNext();
            }

            slow = head;
            while(slow.next!=null){
                if(slow.next==fast.next){
                    fast.next=null;
                    break;
                }
                slow=slow.next;
                fast=fast.next;
            }

    }

    public void mergeLinkedList(LinkedList<T> list){
        head = mergeList(this.head, list.head);
    }

    private Node<T> mergeList(Node<T> list1, Node<T> list2){

        Node<T> merged = null, output = null;
        Node<T> ptr1=list1, ptr2=list2;

        while(ptr1!=null || ptr2!=null){
            if(ptr1==null){
                if(merged==null){
                    merged = ptr2;
                    output = merged;
                }
                else{
                    merged.setNext(ptr2);
                    merged=merged.getNext();
                }
                ptr2=ptr2.getNext();
            }
            else if(ptr2==null){
                if(merged==null){
                    merged = ptr1;
                    output = merged;
                }
                else{
                    merged.setNext(ptr1);
                    merged=merged.getNext();
                }
                ptr1=ptr1.getNext();
            }
            else if(ptr1.compareTo(ptr2.getValue())<0){
                if(merged == null){
                    merged = ptr1;
                    output= merged;
                }
                else{
                    merged.setNext(ptr1);
                    merged = merged.getNext();
                }
                ptr1=ptr1.getNext();
            }
            else{
                if(merged == null){
                    merged = ptr2;
                    output= merged;
                }
                else{
                    merged.setNext(ptr2);
                    merged = merged.getNext();
                }
                ptr2=ptr2.getNext();
            }

        }
        return output;
    }

    public boolean checkIfPalindrome(){
        return checkPalindrome(this.head);
    }

    private boolean checkPalindrome(Node<T> list){
        if(list==null || list.getNext()==null)
            return true;
        
        Node<T> slow=list;
        Node<T> fast = list;
        fast = fast.getNext();

        //-- Finding middle element
        while(fast!=null && fast.getNext()!=null){
            slow=slow.getNext();
            fast = fast.getNext().getNext();
        }

        // -- reverse from Middle---
        Node<T> reversedNode = reverse(slow.getNext());
        slow.setNext(reversedNode);
        slow=slow.getNext();

        Node<T> start = list;
        while(slow!=null){
            if(slow.compareTo(start.getValue())!=0)
                return false;
            slow=slow.getNext();
            start =  start.getNext();
        }
        return true;
    }

    public void printList(){
        Node n=head;
        String output="[ ";
        while(n!=null){
            output+=n.getValue()+", ";
            n= n.getNext();
        }
        output=output.substring(0,output.length()-2);
        System.out.println(output+" ]");
    }
}

public class LinkedListClass {

    public static void main(final String[] args) {
        //-- Create Linked List---
        System.out.println("Creating Linked List...");
        LinkedList<Integer> list = new LinkedList<>();
        System.out.println("Inserting element...");
        //---Insert ----
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
       
        list.printList();
        
        
        //---Delete----
        System.out.println("Deleting Following element: \n 1. "+list.delete(3)+" \n 2. "+list.delete(8));
        // list.delete(3);
        // list.delete(8);

        list.printList();
        
        //---Reverse ----
        System.out.println("Reversing List...");
        list.reverseList();

        list.printList();
        //---Find Loop----
        System.out.println("check if Loop present: "+list.findLoop());

        //---Remove Loop ----
        
        // -- merging list
        System.out.println("Creating Linked List 2...");
        LinkedList<Integer> list1 = new LinkedList<>();
        list1.add(2);
        list1.add(3);
        list1.add(5);
        list1.add(7);
        list1.add(8);
        list1.add(9);
        list1.add(11);
        list1.add(15);

        list1.printList();
        System.out.println("Merging Above List---");
        list.mergeLinkedList(list1);
        list.printList();
        
        //-- Check for palindrome
        LinkedList<Integer> list2 = new LinkedList<>();
        list1.add(2);
        list1.add(3);
        list1.add(5);
        list1.add(7);
        list1.add(7);
        list1.add(5);
        list1.add(3);
        list1.add(2);
        System.out.println("Check for palindrome: "+list2.checkIfPalindrome());
    }

}