import java.util.*;

class Node{
int value;
Node left;
Node right;

Node(int value){
this.value = value;
this.left=null;
this.right=null;
    }

}

class MinStack {

    List<Integer> list;
    int item = 0;
    /** initialize your data structure here. */
    public MinStack() {
        list = new ArrayList<Integer>();
    }
    
    public void push(int x) {
        list.add(x);
        item++;
    }
    
    public void pop() {
     list.remove(item);   
        item--;
    }
    
    public int top() {
        return list.get(item);
    }
    
    public int getMin() {
        int min = list.get(0);
        for(int i =0;i<list.size();i++){
            if(min>list.get(i))
                min=list.get(i);
        }
        return min;
    }
}

class BinaryTree{

Node root;

private Node addrecursively(Node current, int value){
    if(current == null)
    return new Node(value);

    else if(value < current.value)
        current.left = addrecursively(current.left, value);
    else if(value > current.value)
        current.right =  addrecursively(current.right, value);
    else
    return current;
    return current;

    }

public void add(int value){
    root = addrecursively(root, value);
}

public void traverseDfsInorder(Node node){

    if(node!=null){
        traverseDfsInorder(node.left);
        System.out.print(" "+node.value);
        traverseDfsInorder(node.right);
    }

}

public void traverseDfsPreorder(Node node){

    if(node!=null){
        System.out.print(" "+node.value);
        traverseDfsInorder(node.left);
        traverseDfsInorder(node.right);
    }

}

public void traverseDfsPostorder(Node node){

    if(node!=null){
        traverseDfsInorder(node.left);
        traverseDfsInorder(node.right);
        System.out.print(" "+node.value);
    }

}

public void printTree(){
    System.out.println("Inorder: ");
    traverseDfsInorder(root);

    System.out.println("\nPreorder: ");
    traverseDfsPreorder(root);

    System.out.println("\nPostorder: ");
    traverseDfsPostorder(root);
}

}



public class BinaryTreeCreator {
   
    public static void main(String args[]){
        BinaryTree tree = new BinaryTree();
        tree.add(11);
        tree.add(15);
        tree.add(41);
        tree.add(8);
        tree.add(6);
        tree.add(45);
        tree.add(75);
        tree.add(23);
        tree.add(3);
        tree.add(9);

        System.out.println("-----Traversing order----");
        tree.printTree();

        MinStack min = new MinStack();
        min.push(-1);
        // min.pop();
        min.push(2);
        min.push(6);
        System.out.println(min.getMin());
    }

}