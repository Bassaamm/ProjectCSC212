public class Phonebook{
    LinkedList<Contact> contact;
    public Phonebook() {
        contact = new LinkedList<Contact>();
    }
    public void sortedAdd(Contact e){
        if(contact.empty()){
            contact.insert(e);
            return;
        }
        contact.findFirst();
        while(!contact.last()){
            if(contact.retrieve().getName().compareTo(e.getName()) >= 0)
                break;
            contact.findNext();
        }
        if(contact.retrieve().getName().compareTo(e.getName()) <= 0) {
            contact.insert(e);
            return;
        }
        contact.insertBefore(e, contact.retrieve());
    }

    public <T> boolean search(String criteria, T value) {
        int counter = 0;
        if (contact.empty()) {
            return false;
        }
        contact.findFirst();
        while (true) {
            switch (criteria) {
                case "name" -> {
                    if (contact.retrieve().getName().equalsIgnoreCase((String) value)) {
                        printData();
                        System.out.println();
                        return true;
                    }
                }
                case "phoneNumber" -> {
                    if (contact.retrieve().getPhoneNumber().equalsIgnoreCase((String) value)) {
                        printData();
                        System.out.println();
                        return true;
                    }
                }
                case "email" -> {
                    if (contact.retrieve().getEmailAddress().equalsIgnoreCase((String) value)){
                        counter += 1;
                        printData();
                        System.out.println();
                    }
                }
                case "address" -> {
                    if (contact.retrieve().getAddress().equalsIgnoreCase((String) value)){
                        counter += 1;
                        printData();
                        System.out.println();
                    }
                }
                case "birthday" -> {
                    if (contact.retrieve().getBirthday().equalsIgnoreCase((String) value)){
                        counter += 1;
                        printData();
                        System.out.println();

                    }
                }
            }
            if(contact.last())
                break;
            contact.findNext();
        }
        return !(counter == 0);
    }

    public <T> boolean remove(T number){
           boolean temp = search("phoneNumber" ,number);
           contact.remove();
        return true;
    }

    public void printAllContacts(){
        if(contact.empty()) {
            System.out.println("The PhoneBook is empty");
            return;
        }
        contact.findFirst();
        while(!contact.last()){
            printData();
            contact.findNext();
        }
        printData();
        System.out.println();
    }
    private void printData(){
        System.out.println("==============================");
        System.out.println("Name: " + contact.retrieve().getName());
        System.out.println("Phone Number: " + contact.retrieve().getPhoneNumber());
        System.out.println("Email Address: " + contact.retrieve().getEmailAddress());
        System.out.println("Address: " + contact.retrieve().getAddress());
        System.out.println("Birthday: " + contact.retrieve().getBirthday());
        System.out.println("Notes: " + contact.retrieve().getNotes());
        System.out.println("==============================");
    }
}
