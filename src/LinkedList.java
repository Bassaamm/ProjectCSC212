
public class LinkedList<T> {

    private Node<T> head;
    private Node<T> current;

    public LinkedList(){
        head = current = null;
    }
    public void printAll(){
        if(head == null)
            return;
        Node<T> temp = head;
        while(temp != null){
            System.out.println(temp.data.toString());
            temp = temp.next;
        }
    }
    // Big O(n)
    public int getLength(){
        Node<T> temp = head;
        int counter = 0;
        while (temp != null) {
            temp = temp.next;
            counter++;
        }
        return counter;
    }
    // Big O(1)
    public boolean empty() {
        return head == null;
    }
    // Big O(1)
    public boolean last() {
        return current.next == null;
    }
    // Big O(1)
    public void findFirst() {
        current = head;
    }

    // Big O(1)
    public void findNext() {
        current = current.next;
    }

    // Big O(1)
    public T retrieve () {
        return current.data;
    }

    // Big O(1)
    public void update (T val) {
        current.data = val;
    }

    // Big O(1)
    public void insert(T value){
        Node<T> temp;
        if (head == null)

            current = head = new Node<T>(value);
        else {
            temp = current.next;
            current.next = new Node<T>(value);
            current = current.next;
            current.next = temp;
        }
    }

    // Big O(n)
    public void insertBefore(T value, T currentData){
        Node<T> newNode = new Node<>(value);
        if(head == null) {
            head = current = newNode;
            return;
        }
        Node<T> current = head;
        Node<T> previous = null;
        while(current != null){
            if(current.data.equals(currentData))
                break;
            previous = current;
            current = current.next;
        }
        if(previous == null){
            head = newNode;
            head.next = current;
            return;
        }
        previous.next = newNode;
        newNode.next = current;
    }

    // Big O(n)
    public void remove(){
        if (current == head)
            head = head.next;
        else {
            Node<T> temp = head;
            while (temp.next != current)
                temp = temp.next;
            temp.next = current.next;
        }
        if (current.next == null)
            current = head;
        else
            current = current.next;

    }

}
