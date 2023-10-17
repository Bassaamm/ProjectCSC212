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
                        System.out.println();
                        System.out.println(contact.retrieve().toString());
                        return true;
                    }
                }
                case "nonPrintName" -> {
                    if (contact.retrieve().getName().equalsIgnoreCase(value)) {
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
                    System.out.println();
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

    public void removeContact(String criteria, String value){
        if(search(criteria, value)){
            String name = contact.retrieve().getName();
            contact.remove();
            System.out.println("Has been successfully removed\n");
            return;
        }
        System.out.println("No contacts removed\n");
        return;
    }

    public void searchEvent(String criteria, String value) {

        switch (criteria) {
        case "name" -> {
                int lengthC = contact.retrieve().event.getLength();
                System.out.println(lengthC);
                Contact currentC = contact.retrieve();
                for (int i = 0; i < lengthC; i++) {
                    if (currentC.getName().equalsIgnoreCase(value))
                        currentC.event

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
        System.out.println("Title: " + contact.retrieve().event.toString()current.getTitle());
        System.out.println("Date: " + current.getDate());
        System.out.println("Time: " + current.getTime());
        System.out.println("Location: " + current.getLocation());
        System.out.println();

    }

}