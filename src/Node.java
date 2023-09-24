class Node<T> {
    T data;
    Node<T> next;

    Node(){
        data = null;
        next = null;
    }
    Node(T value){
        this.data = value;
        next = null;
    }

}