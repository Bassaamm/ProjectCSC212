
public class LinkedList<T> {

    private Node<T> head;
    private Node<T> current;

    public LinkedList(){
        head = current = null;
    }

    public void printList(){
        Node<T> temp = head;
        while(temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public int getLength(){
        Node<T> temp = head;
        int counter = 0;
        while (temp != null) {
            temp = temp.next;
            counter++;}
        return counter;
    }

    public boolean empty() {
        return head == null;
    }

    public boolean last() {
        return current.next == null;
    }

    public void findFirst() {
        current = head;
    }

    public void findNext() {

        current = current.next;
    }

    public T retrieve () {
        return current.data;
    }

    public void update (T val) {
        current.data = val;
    }

    //insert
    //remove

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