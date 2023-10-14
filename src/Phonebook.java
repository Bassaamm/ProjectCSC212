public class Phonebook{
    LinkedList<Contact> contact;
    LinkedList<Event> event;
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
    private void printeventData() {
        System.out.println("title: " + event.retrieve().getTitle());
        System.out.println("event date: " + event.retrieve().getDate());
        System.out.println("event time: " + event.retrieve().getTime());
        System.out.println("location: " + event.retrieve().getLocation());

    }
    private void printCurrentContact(Contact current){
        System.out.println("Name: " + current.getName());
        System.out.println("Phone Number: " + current.getPhoneNumber());
        System.out.println("Email Address: " + current.getEmailAddress());
        System.out.println("Address: " + current.getAddress());
        System.out.println("Birthday: " + current.getBirthday());
        System.out.println("Notes: " + current.getNotes());
    }
    public void searchEvent(int num, String value) {

        if (num == 1) {
            int lengthC = contact.getLength();
            Contact currentC = contact.retrieve();
            for (int i = 0; i < lengthC; i++) {
                if (currentC.getName().equalsIgnoreCase(value))
                    printCurrentEvent(currentC.event.retrieve());

                else {
                    contact.findNext();
                    currentC = contact.retrieve();
                }
            }
        }
        if (num == 2) {
            int lengthE=contact.retrieve().event.getLength();
            Event currentE = contact.retrieve().event.retrieve();
            for (int j = 0; j < lengthE; j++) {
                if (currentE.getTitle().equalsIgnoreCase(value))
                    printCurrentEvent(currentE);
                else {
                    contact.retrieve().event.findNext();
                    currentE = contact.retrieve().event.retrieve();
                }
            }
        }


    }
    private void printCurrentEvent(Event current) {
        System.out.println("Title: " + current.getTitle());
        System.out.println("Time: " + current.getTime());
        System.out.println("Date: " + current.getDate());
        System.out.println("Location: " + current.getLocation());
    }
    public void sortedAddEvent(Event e) {
        if (event.empty()) {
            event.insert(e);
            return;
        }
        event.findFirst();
        while (!event.last()) {
            if (event.retrieve().getTitle().compareTo(e.getTitle()) >= 0)
                break;
            event.findNext();
        }
        if (event.retrieve().getTitle().compareTo(e.getTitle()) <= 0) {
            event.insert(e);
            return;
        }
        event.insertBefore(e, event.retrieve());
    }
    public void printevent() {
        if (event.empty()) {
            System.out.println("The PhoneBook is empty");
            return;
        }
        event.findFirst();
        while (!event.last()) {
            printeventData();
            event.findNext();
            System.out.println();
        }
        printeventData();
        System.out.println();
    }


}