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
    public boolean search(int num,T value) {
    if (contact.empty())
        return false;
        contact.findFirst();
        int length = contact.getLength();
    Contact head = contact.retrieve();
        for(int i = 0; i < length ; i++) {
            if(num == 1)
            if (head.getName().equalsIgnoreCase((String) value)){
                System.out.println(value);
                    printCurrentContact(head);
                    return true;
                }
            else {
                contact.findNext();
            };
            if(num == 2)
                if ((Integer)head.getPhoneNumber() == value ){
                    printCurrentContact(head);
                    return true;
                } else {
                    contact.findNext();
                };

        }
    return false;
    }
    public boolean searchMany(int num,T value) {
        if (contact.empty())
            return false;
        contact.findFirst();
        Contact head = contact.retrieve();
        for (int i = 0; i < contact.getLength(); i++) {
            if (num == 3)
                if (head.getEmailAddress().equalsIgnoreCase((String) value)) {
                    printCurrentContact(head);
                    return true;
                }
            if (num == 4)
                if (head.getAddress().equalsIgnoreCase((String) value)) {
                    printCurrentContact(head);
                    return true;
                }
            if (num == 5)
                if (head.getBirthday().equalsIgnoreCase((String) value)) {
                    printCurrentContact(head);
                    return true;
                }
        }
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
    private void printCurrentContact(Contact current){
        System.out.println("Name: " + current.getName());
        System.out.println("Phone Number: " + current.getPhoneNumber());
        System.out.println("Email Address: " + current.getEmailAddress());
        System.out.println("Address: " + current.getAddress());
        System.out.println("Birthday: " + current.getBirthday());
        System.out.println("Notes: " + current.getNotes());
    }

}
