import java.util.Scanner;
public class bstcreation{
    static class Node{
        int key;
        Node left,right;
    };
    static Node newNode(int data){
        Node temp=new Node();
        temp.key=data;
        temp.left=null;
        temp.right=null;
        return temp;
    }
    static Node insert(Node root,int key){
        Node newnode=newNode(key);
        Node x=root;
        Node y=null;
        while(x!=null){
            y=x;
            if(key<x.key){
                x=x.left;
            }
            else if(key>x.key){
                x=x.right;
            }
            else{
                System.out.println("Value already exists");
                return newnode;
            }
        }
        if(y==null){
            y=newnode;
        }
        else if(key<y.key){
            y.left=newnode;
        }
        else{
            y.right=newnode;
        }
        return y;
    }
    static void inorder(Node root){
        if(root==null){
            return;
        }
        else{
            inorder(root.left);
            System.out.println(root.key+"");
            inorder(root.right);
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int value,num;
        System.out.println("Enter the no of values:");
        num=sc.nextInt();

        Node root=null;
        Node result=null;

        for(int i=0;i<num;i++){
            System.out.println("\n Enter the value at"+(i+1)+":");
            value=sc.nextInt();
            if(root==null){
                root=insert(root,value);
            }
            else{
                result=insert(root,value);
                if(result.key==value)
                i-=1;
            }
            System.out.println("Inorder of binary tree\n");
            inorder(root);
        }
    }

}