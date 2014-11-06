/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package btree;

import java.io.IOException;

/**
 *
 * @author vidhu
 */
class Node{
    int n;
    int key[];
    Node c[];
    boolean leaf;
    public Node(){
        key=new int[10];
        c=new Node[10];
    }
}
public class BTree {
//    boolean cre=false;
    Node node=null;
    Node node1=null;
    int t;
    public BTree(int d){
        t=d;
    }
    public void create(){
        node=new Node();
        node.n=0;
        node.leaf=true;
       // node1=node;
    }
    public void insert(int ele){
        Node x=node;
        if(x.n==(2*t-1)){
            Node q=new Node();
            q.leaf=false;
            q.n=0;
            q.c[1]=x;
            node=q;
            bTreeSplit(q,1,x);
            bTreeInsertNonfull(q,ele);
        }
        else
            bTreeInsertNonfull(x,ele);
       // node1=node;
        }

   
    private void bTreeInsertNonfull(Node q, int ele) {
       int j=q.n;
       if(q.leaf){
           while(j>=1&&ele<q.key[j]){
               q.key[j+1]=q.key[j];
               j--;
           }
           q.key[j+1]=ele;
           q.n++;
       }
       else{
           while(j>=1&&ele<q.key[j])
               j--;
           j++;
           if(q.c[j].n==(2*t-1)){
               bTreeSplit(q,j,q.c[j]);
               if(ele>q.key[j])
                   j++;
           }
           if(q.c[j]!=null)
               bTreeInsertNonfull(q.c[j], ele);
       }
    }

    private void bTreeSplit(Node x, int i, Node y) {
       
        Node z=new Node();
        z.leaf=y.leaf;
        z.n=t-1;
        
        for(int j=1;j<=t-1;j++)
            z.key[j]=y.key[j+t];
        if(!y.leaf){
            for(int j=1;j<=t;j++)
                z.c[j]=y.c[j+t];
                        
        }
        y.n=t-1;
        
        for(int j=x.n+1;j>=i+1;j--)
            x.c[j+1]=x.c[j];
        x.c[i+1]=z;
        for(int j=x.n;j>=i;j--)
            x.key[j+1]=x.key[j];
        x.key[i]=y.key[t];
        x.n++;
    }
    
    void search(int ele){
        String str=bTreeSearch(node,ele);
        if(str.equals(" ")){
            System.out.println("Element not present");
            
        }
        else
            System.out.println("Element presents "+str+" in a node");
        
    }

    private String bTreeSearch(Node q, int ele) {
        boolean flag=false;
        String pos=" ";
        int i=1;
      //  System.out.println("1234");
        while(i<=q.n&&ele>q.key[i]){
            i++;
            // System.out.println("key"+q.key[i]);
        }
        if(i<=q.n&&ele==q.key[i]){
            pos+=i+" -th position";
            flag=true;
        }
        if(!flag&&!q.leaf)
            pos=bTreeSearch(q.c[i],ele);
        
        return pos;
    }
    
    
    void display()throws IOException{
        Node nod=node;
        printNode(nod);
        System.out.println("");
        printChild(nod);
    }

    private void printNode(Node nod) {
        for(int i=1;i<=nod.n;i++)
            System.out.print(nod.key[i]+" * ");
    }

    private void printChild(Node nod) {
        for(int i=1;i<=nod.n+1;i++){
            if(nod.c[i]!=null)
                printNode(nod.c[i]);
            System.out.print("   ");
        }
        
        for(int i=1;i<=nod.n+1;i++){
            if(nod.c[i]!=null)
                printChild(nod.c[i]);
        }
            
    }
    
    private void deleteNode(Node q,int ele){
     //   boolean flag=false;
        //String pos=" ";
        int i=1;
        
        while(i<=q.n){
            
        if(ele!=q.key[i]){
                delete(q.key[i]);
            }
        
        i++;
        }
        for(i=1;i<=q.n+1;i++){
         if(!q.leaf)
            deleteNode(q.c[i],ele);
        }
       
        // i++;
        
    }
    
     
    public void bTreeDeleteNode(int ele){
        node1=new Node();
        node1.n=0;
        node1.leaf=true;
        deleteNode(node,ele);
        node=node1;
    }
    private void delete(int ele){
        //deleteNode(node, ele);
        Node x=node1;
        if(x.n==(2*t-1)){
            Node q=new Node();
            q.leaf=false;
            q.n=0;
            q.c[1]=x;
            node1=q;
            bTreeSplit(q,1,x);
            bTreeInsertNonfull(q,ele);
        }
        else
            bTreeInsertNonfull(x,ele);
        //node=node1;
        
    }
    
    
    
}
