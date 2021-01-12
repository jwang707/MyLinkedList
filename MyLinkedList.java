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

 public String set(int index, String value){
   if (index < 0 || index > size){
     throw new IndexOutOfBoundsException("Index out of bounds!");
   }
   else{
     Node bang = start;
     for (int i = 0; i < index; i++){
       bang = bang.getNext();
     }
     bang.setData(value);
     return bang.getData();
   }
 }

 public String toString() {
   if (size == 0){
     return "[]";
   }

   String result = "[";
   Node newNode = start;
   int counter = 0;

   while (counter < size){
     if (counter == size-1){
        result += newNode.getData() + "]";
        counter++;
     }
     else{
       result += newNode.getData() + ", ";
       newNode = newNode.getNext();
       counter++;
     }
   }
   return result;
 }

 public String toStringReversed() {
   if (size == 0){
     return "[]";
   }

   String result = "[";
   Node newNode = end;

   while (newNode.getPrev() != null){
       result += newNode.getData() + ", ";
       newNode = newNode.getPrev();
  }
  result += newNode.getData() + "]";
  return result;
 }

 public String remove(int index){
   if (index <= 0 || index > size){
     throw new IndexOutOfBoundsException("Index out of bounds!");
   }
   if (size == 1){
     Node grab = start;
     start = end = null;
     return grab.getData();
   }
   else if (index == size){
     Node grab = end;
     end = end.getPrev();
     end.setNext(null);
     size--;
     return grab.getData();
   }
   else{
     Node bang = start; // in hindsight i realize a helper method would have been much much easier
     for (int i = 0; i < index-1; i++){
       bang = bang.getNext();
     }
     Node postbang = bang.getNext();
     Node after = postbang.getNext();
     after.setPrev(bang);
     bang.setPrev(after);
     return postbang.getData();
   }
 }

 /*
*@postcondition: All of the elements from other are removed from the other, and connected to the end of this linked list.
*@postcondition: The size of other is reduced to 0.
*@postcondition: The size of this is now the combined sizes of both original lists
*/
public void extend(MyLinkedList other){
  if (size == 0){
    start = other.start;
    end = other.end;
  }
  if (other.size() != 0){
    end.setNext(other.start);
    other.start.setPrev(end);
    end = other.end;
    size += other.size();
    other.start = null;
    other.end = null;
    other.size = 0;
  }
 }

}
