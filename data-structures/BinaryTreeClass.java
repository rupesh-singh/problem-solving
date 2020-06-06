class BinaryTree<T extends Comparable<T>> {

private class Node<T extends Comparable<T>>{
    T value;
    Node<T> left;
    Node<T> right;

    Node(T value){
        this.value = value;
        this.left=null;
        this.right=null;
    }

    public int compareTo(T value){
        return this.value.compareTo(value);
    }
}

private Node<T> root;

private Node<T> addrecursively(Node<T> current, T value){
    
    if(current == null)
        return new Node(value);
    else if(current.value.compareTo(value) > 0)
        current.left = addrecursively(current.left, value);
    else 
        current.right =  addrecursively(current.right, value);

    return current;
    }

public void add(T value){
    root = addrecursively(root, value);
}

public Node<T> searchRecursively(Node<T> root, T value){
    if (root.value.compareTo(value) > 0) {
        root = searchRecursively(root.left, value);
    } else if (root.value.compareTo(value) < 0) {
        root = searchRecursively(root.right, value);
    } else if (root.value.compareTo(value) == 0)
        return root;
        
    return root;
}

public Node<T> getNodeParent(Node<T> curNode, T value, Node<T> parent){

    if(curNode==null)
        return null;

    else if(curNode.value.compareTo(value)>0){
        parent = getNodeParent(curNode.left, value, curNode);
    }
    else if(curNode.value.compareTo(value)<0){
        parent = getNodeParent(curNode.right, value, curNode);
    }
    else if(curNode.value.compareTo(value) == 0)
        return parent;

    return parent;
  
}

public Node<T> findMinimum(Node<T> node){
    while(node.left!=null){
        node= node.left;
    }
    return node;
}

public void remove(T value){
    delete(root, value);
}

public void delete(Node<T> node, T value){

    Node<T> curr = node;
    Node<T> parent = null;

    curr = searchRecursively(curr, value);
    if(curr == null)
        return;

    parent = getNodeParent(node, curr.value, parent);
    
    if(curr.left==null && curr.right==null){
        if(parent!=null){
            if(parent.left==curr){
                parent.left=null;
            }
            else
                parent.right=null;
        }
        else{
            curr = null;
            return;
        }
    }
    else if(curr.left!=null && curr.right!=null){

        Node<T> smallestNode = findMinimum(curr.right);
        T val = smallestNode.value;
        delete(root, val);
        curr.value=val;
    }

    else if(curr.left==null){
        if(parent.left==curr){
            parent.left = curr.right;
        }
        else{
            parent.right=curr.right;
        }
    }
    else if(curr.right==null){
        if(parent.left==curr){
            parent.left = curr.left;
        }
        else{
            parent.right=curr.left;
        }
    }

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

    System.out.println();
}

}

public class BinaryTreeClass {
   
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
        
        tree.remove(11);
        tree.remove(15);
        
        System.out.println("-----After Deleting Traversing order----");
        tree.printTree();

    }

}