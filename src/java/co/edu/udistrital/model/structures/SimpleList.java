package co.edu.udistrital.model.structures;

/**
 *
 * @author Jimmy86gb
 * @param <T>
 */
public class SimpleList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;
    
    public SimpleList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    public void add(T data){
        Node<T> newNode = new Node<>(data);
        if(head == null){
            head = newNode;
            tail = newNode;
        }else{
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
    }
    
    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public Node<T> getTail() {
        return tail;
    }

    public void setTail(Node<T> tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isEmpty() {
        if(getSize() == 0){
            return true;
        }
        return false;
    }
    
}
