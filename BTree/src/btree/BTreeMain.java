/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package btree;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vidhu
 */
public class BTreeMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner sc=new Scanner(System.in);
        System.out.println("\n Eneter Minimum Degree of Btree value>=2");
        int d=sc.nextInt();
        BTree btree=new BTree(d);
        while(true){
            System.out.println("\n1.Create.\n2.Insert\n3.Display\n4.Search\n5.Exit");
            System.out.println("Enter your choice");
            int c=sc.nextInt();
            switch(c){
                case 1:btree.create();
                    break;
                case 2:
                     System.out.println("\nEnter the element to insert");
                    int ele=sc.nextInt();
                    btree.insert(ele);
                    break;
                case 3:try {
                             btree.display();
                        } catch (IOException ex) {
                           System.out.println(ex.getMessage());
                        }
                    break;
                case 4:System.out.println("\nEnter the element to Search");
                    int ser=sc.nextInt();
                    btree.insert(ser);
                    break;
                case 5:System.exit(0);break;
                    
                case 6:System.out.println("\nEnter the element to delete");
                    int del=sc.nextInt();
                    btree.bTreeDeleteNode(del);
                
                    
            }
        }
    }
}
