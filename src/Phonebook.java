public class Phonebook {
    LinkedList<Contact> contact;
    public Phonebook(){
    LinkedList<Contact> contact = new LinkedList<Contact>();
    }
    public boolean add(String name ,int number , String email,String address, String birthday, String notes ){
        Contact con = new Contact(name ,number,email,address,birthday,notes);

        contact.insert(con);
        return true;
    }
    public boolean search(String name){

        return false;
    }
    public boolean remove(Contact e){


        return false;
    }

}
