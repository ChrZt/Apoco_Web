/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udistrital.model.structures;

/**
 *
 * @author Jimmy86gb
 */
public class Node<T> {
    private T data;
    private Node<T> next;
    
    public Node(T data){
        this(data, null);
    }
    public Node(T data, Node<T> next){
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }
    
    public T getNextData(){
        Node<T> next = getNext();
        return next.getData();
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
    
    @Override
    public String toString() {
        return data.toString();
    }
}
