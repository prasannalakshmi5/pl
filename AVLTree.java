class Node{
    int val,height;
    Node left,right;
    Node(int val){
        this.val=val;
        this.height=1;
    }
}
public class AVLTree{
    int height(Node node){
        return(node==null)?0:node.height;
    }
    int getBalance(Node node){
        return(node==null)?0:height(node.left)-height(node.right);
    }
    Node rightRotate(Node y){
        Node x=y.left;
        Node T2=x.right;
        x.right=y;
        y.left=T2;
        y.height=Math.max(height(y.left),height(y.right))+1;
        x.height=Math.max(height(x.left),height(x.left))+1;
        return x;
    }
    Node leftRotate(Node x){
        Node y=x.right;
        Node T2=y.left;
        y.left=x;
        x.right=T2;
        x.height=Math.max(height(x.left),height(x.right))+1;
        y.height=Math.max(height(y.left),height(y.right))+1;
        return y;
    }
    Node insert(Node node,int key){
        if(node==null)
        return new Node(key);
        if(key<node.val)
        node.left=insert(node.left,key);
        else if(key>node.val)
        node.right=insert(node.right,key);
        else
        return node;
        node.height=1+Math.max(height(node.left),height(node.right));
        int balance=getBalance(node);
        if(balance>1&&key<node.left.val)
        return rightRotate(node);
        if(balance<-1&&key>node.right.val)
        return leftRotate(node);
        if(balance>1&&key>node.left.val){
            node.left=leftRotate(node.left);
            return rightRotate(node);
        }
        if(balance<-1&&key<node.right.val){
            node.right=rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }
    void preOrder(Node node){
        if(node!=null){
            System.out.print(node.val+" ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }
    public static void main(String[] args){
        AVLTree tree=new AVLTree();
        Node root=null;
        int[]keys={10,20,30,40,50,25};
        for(int key:keys){
            root=tree.insert(root,key);
        }
        System.out.println("preOrder travesal of AVLTree is:");
        tree.preOrder(root);
    }
}