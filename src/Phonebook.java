public class Phonebook<T>{
    LinkedList<Contact> contact;
    public Phonebook() {
        contact = new LinkedList<Contact>();
    }
    public void add(Contact e) {
        if(contact.empty()) {
            contact.insert(e);
            return;
        }
        contact.findFirst();
        while(!(contact.last()) && (contact.retrieve().getName().toLowerCase().compareTo(e.getName().toLowerCase()) >= 0)){
            contact.findNext();
        }
        contact.insert(e);

    }
    public boolean search(T check) {
        Contact head = contact.retrieve();



        return false;
    }
    public boolean remove(Contact e){


        return false;
    }
    public void printContacts(){
        if(contact.empty())
            return;
        contact.findFirst();
        while(!contact.last()){
            printData();
            contact.findNext();
            System.out.println();
        }
        printData();
        System.out.println();
    }
    private void printData(){
        System.out.println("Name: " + contact.retrieve().getName());
        System.out.println("Phone Number: " + contact.retrieve().getPhoneNumber());
        System.out.println("Email Address: " + contact.retrieve().getEmailAddress());
        System.out.println("Address: " + contact.retrieve().getAddress());
        System.out.println("Birthday: " + contact.retrieve().getBirthday());
        System.out.println("Notes: " + contact.retrieve().getNotes());
    }
}
