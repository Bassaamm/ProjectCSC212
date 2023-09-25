public class Phonebook<T> {
    LinkedList<Contact> contact;
    public Phonebook(){
    LinkedList<Contact> contact = new LinkedList<Contact>();
    }
    public boolean add(Contact e ){
        contact.insert(e);
        return true;
    }
    public boolean search(T check){
        Contact head = contact.retrieve();



        return false;
    }
    public boolean remove(Contact e){


        return false;
    }

}
