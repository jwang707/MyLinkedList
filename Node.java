public class Node{
 public Node(String value){
   data = value;
 }

 private String data;
 private Node next,prev;

 public String getData(){
   return data;
 }

 public String setData(String value){
   String old = data;
   data = value;
   return old;
 }

 public Node getNext(){
   return next;
 }

 public Node setNext(Node val){
   Node old = next;
   next = val;
   return old;
 }

 public Node getPrev(){
   return prev;
 }

 public Node setNext(Node val){
   Node old = prev;
   prev = val;
   return old;
 }
}
