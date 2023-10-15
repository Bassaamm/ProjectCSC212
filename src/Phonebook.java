public class Phonebook{
    LinkedList<Contact> contact;
    LinkedList<Event> event;
    public Phonebook() {
        contact = new LinkedList<Contact>();
        event = new LinkedList<Event>();
    }
    public void sortedAdd(Contact e){
        if(contact.empty()){
            contact.insert(e);
            return;
        }
        contact.findFirst();
        while(!contact.last()){
            if(contact.retrieve().getName().compareTo(e.getName()) > 0)
                break;
            contact.findNext();
        }
        if(contact.retrieve().getName().compareTo(e.getName()) <= 0) {
            contact.insert(e);
            return;
        }
        contact.insertBefore(e, contact.retrieve());
    }

    public Boolean search(String criteria, String value) {
        int counter = 0;
        if (contact.empty()) {
             return false;
        }
        contact.findFirst();
        while (true) {
            switch (criteria) {
                case "name" -> {
                    if (contact.retrieve().getName().equalsIgnoreCase(value)) {
                        System.out.println(contact.retrieve().toString());
                        return true;
                    }
                }
                case "firstName" -> {
                    String [] splitName = contact.retrieve().getName().split(" ", 0);
                    if(splitName[0].equalsIgnoreCase((String) value)) {
                        if(counter == 0)
                            System.out.println("Contacts found!\n");
                        System.out.println(contact.retrieve().toString());
                        counter++;
                    }
                }
                case "phoneNumber" -> {
                    if (contact.retrieve().getPhoneNumber().equalsIgnoreCase((String) value)) {
                        System.out.println(contact.retrieve().toString());
                        return true;
                    }
                }
                case "email" -> {
                    if (contact.retrieve().getEmailAddress().equalsIgnoreCase((String) value)){
                        counter++;
                        System.out.println(contact.retrieve().toString());
                    }
                }
                case "address" -> {
                    if (contact.retrieve().getAddress().equalsIgnoreCase((String) value)){
                        counter++;
                        System.out.println(contact.retrieve().toString());
                    }
                }
                case "birthday" -> {
                    if (contact.retrieve().getBirthday().equalsIgnoreCase((String) value)){
                        counter++;
                        System.out.println(contact.retrieve().toString());
                    }
                }
            }
            if(contact.last())
                break;
            contact.findNext();
        }
        return !(counter == 0);
    }

    public Boolean remove(String number){
        boolean temp = search("phoneNumber" ,number);
        contact.remove();
        return true;
    }

    public void searchEvent(String name, String value) {

        switch (name) {
        case "name" -> {
                int lengthC = contact.retrieve().event.getLength();
                System.out.println(lengthC);
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
           case "event" -> {
                int lengthE = contact.retrieve().event.getLength();
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

    }
    public void sortedAddEvent(Event e) {
       Boolean con = search("name" , e.getContect().getName());
        if (event.empty() && con) {
            contact.retrieve().event.insert(e);
            event.insert(e);
            return;
        }
        event.findFirst();
        while (!event.last()) {
            if (event.retrieve().getTitle().compareTo(e.getTitle()) > 0 && con )
                break;
            event.findNext();
        }
        if (event.retrieve().getTitle().compareTo(e.getTitle()) <= 0 && con) {
            contact.retrieve().event.insert(e);
            event.insert(e);
            return;
        }
        contact.retrieve().event.insertBefore(e , event.retrieve());
        event.insertBefore(e, event.retrieve());
    }

    public void printCurrentEvent(Event current) {
        System.out.println("Title: " + current.getTitle());
        System.out.println("Date: " + current.getDate());
        System.out.println("Time: " + current.getTime());
        System.out.println("Location: " + current.getLocation());
        System.out.println();

    }
    private void printContact(){
        System.out.println("Name: " + contact.retrieve().getName());
        System.out.println("Phone Number: " + contact.retrieve().getPhoneNumber());
        System.out.println("Email Address: " + contact.retrieve().getEmailAddress());
        System.out.println("Address: " + contact.retrieve().getAddress());
        System.out.println("Birthday: " + contact.retrieve().getBirthday());
        System.out.println("Notes: " + contact.retrieve().getNotes());
        System.out.println("==============================");
    }
    public void printAllContacts(){
        if(contact.empty()) {
            System.out.println("The PhoneBook is empty");
            return;
        }
        contact.findFirst();
        while(!contact.last()){
            printContact();
            contact.findNext();
        }
        printContact();
        System.out.println();
    }
    private void printeventData() {
        System.out.println("title: " + event.retrieve().getTitle());
        System.out.println("event date: " + event.retrieve().getDate());
        System.out.println("event time: " + event.retrieve().getTime());
        System.out.println("location: " + event.retrieve().getLocation());

    }
    public void printAllevent() {
        if (event.empty()) {
            System.out.println("The event is empty");
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