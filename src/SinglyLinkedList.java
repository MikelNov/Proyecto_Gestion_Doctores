
import java.util.Objects;

public class SinglyLinkedList<T> {
    private Node<T> head;
    private int size;

    public SinglyLinkedList() {
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int getSize() {
        return size;
    }

    public void traverse() {
        if (isEmpty()) {
            System.out.println("La lista está vacía.");
            return;
        }

        Node<T> current = head;
        while (current != null) {
            System.out.println(current.getData());
            current = current.getNext();
        }
    }

    public void insertFirst(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.setNext(head);
        head = newNode;
        size++;
    }

    public void insertLast(T data) {
        Node<T> newNode = new Node<>(data);

        if (isEmpty()) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        size++;
    }

    public boolean contains(T data) {
        Node<T> current = head;
        while (current != null) {
            if (Objects.equals(current.getData(), data)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    // Devuelve el objeto almacenado si coincide
    public T find(T data) {
        Node<T> current = head;
        while (current != null) {
            if (Objects.equals(current.getData(), data)) {
                return current.getData();
            }
            current = current.getNext();
        }
        return null;
    }

    public boolean remove(T data) {
        if (isEmpty()) {
            return false;
        }

        if (Objects.equals(head.getData(), data)) {
            head = head.getNext();
            size--;
            return true;
        }

        Node<T> previous = head;
        Node<T> current = head.getNext();

        while (current != null && !Objects.equals(current.getData(), data)) {
            previous = current;
            current = current.getNext();
        }

        if (current == null) {
            return false;
        }

        previous.setNext(current.getNext());
        size--;
        return true;
    }

    public void clear() {
        head = null;
        size = 0;
    }
}