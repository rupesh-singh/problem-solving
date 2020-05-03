class LNode {
    LNode next;
    int value;

    public LNode(int value){
        next=null;
        this.value=value;
    }

}
/*
class LinkedList {

public Node head;

public LinkedList(){
    head=null;    
}

public void add(int Value){
    Node n = new Node();
    n.value=Value;
    Node temp=head;
    if(head==null)
        head=n;
    else{
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=n;          
    }
    
} 

public void print(){

    while(head!=null){
        System.out.print(head.value+" => ");
        head=head.next;
    }
}

public int delete(int value){
    Node temp=head;
    Node previousNode=null;

    if(temp.value==value)
        head=head.next;
    else {
        while(temp.value!=value){
            previousNode = temp;
            temp=temp.next;
        }
        previousNode.next = temp.next;
    }
    return -1;
}

    public int size(){
        Node node=head;
        int count=0;
        if(node==null)
            return 0;
        else{
            while(node!=null)
            {
                node=node.next;
                count++;
            }
        }
        return count;
}


}

*/

class LinkedListClass {

    public static LNode polynomialAddition(LNode exp1, LNode exp2){
        LNode output = null, temp=null;
        if(exp1==null && exp2==null)
            return null;
        else if(exp1==null)
            return exp2;
        else if(exp2==null)
            return exp1;
        else{
            int sum=0,carry=0;
            while(exp1!=null && exp2!=null){
                sum=carry;
                if(exp1!=null){
                    sum=sum+exp1.value;
                    exp1=exp1.next;
                }
                
                if(exp2!=null){
                    sum=sum+exp2.value;
                    exp2=exp2.next;
                }
                LNode n = new LNode(sum%10);
                carry = sum>10?1:0;
                if(output==null){
                    output=n;
                    temp=output;
                }
                else{
                    output.next=n;
                    output=output.next;
                }
                sum=0;
            }

        }
        return temp;       
    }

    public static void main(String args[]){
    
        // LinkedList Creation
        // LinkedList list = new LinkedList();
        // list.add(1);
        // list.add(2);
        // list.add(3);
        // list.add(4);
        // list.add(5);
        // list.delete(1);
        // list.print();
    

    // Ploynomial Addition
    LNode exp11 = new LNode(7);
    LNode exp12 = new LNode(1);
    LNode exp13 = new LNode(6);
    exp11.next = exp12;
    exp12.next=exp13;

    
    LNode exp21 = new LNode(5);
    LNode exp22 = new LNode(9);
    LNode exp23 = new LNode(2);
    exp21.next = exp22;
    exp22.next=exp23;
    System.out.println("Addition of LinkedList:\n");
    LNode output = polynomialAddition(exp11,exp21);
    
    while(output!=null){
    System.out.print(output.value+"=>");
    output=output.next;
    }
    }

}