import java.util.*;
import java.lang.*;

public class MyLinkedList{
 private int size;
 private Node start,end;
 public MyLinkedList(){
   super();
 }

 public int size(){
   return size;
 }

 public boolean add(String value){
   Node val = new Node(value);
   if (size == 0){
     start = end = val;
     size++;
   }
   else {
     end.setNext(val);
     val.setPrev(end);
     end = val;
     size++;
   }
   return true;
 }


 public void add(int index, String value){
   if (index < 0 || index > size){
     throw new IndexOutOfBoundsException("Index out of bounds!");
   }
   Node newNode = new Node(value);
   if (size == index){
     add(value);
   }
   if (index == 0){
     Node shift = start;
     Node push = start.getNext();
     start = newNode;
     start.setNext(shift);
     shift.setPrev(push);
   }
 }

 public String get(int index){
   if (index < 0 || index > size){
     throw new IndexOutOfBoundsException("Index out of bounds!");
   }
   else{
     Node bang = start;
     for (int i = 0; i < index; i++){
       bang = bang.getNext();
     }
     return bang.getData();
   }
 }
/*
 public String set(int index, String value);
 public String toString(); */
 //Any helper method that returns a Node object MUST BE PRIVATE!
}
