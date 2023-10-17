public class Phonebook{
    public LinkedList<Contact> contact;
    public LinkedList<Event> event;
    public Phonebook() {
        contact = new LinkedList<Contact>();
        event = new LinkedList<Event>();
    }

    // Abdulaziz
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
    //------------------Search Function Description----------------------
    // it uses the criteria parameter to let the use decide which attribute
    // Wants to use to search by, the value parameter takes the user input.
    // It returns a true if the value the user was looking for was found
    // ----------------------------Big O----------------------------------
    // for the While(true) loop, we can’t apply Big O to this scenario in a meaningful way.
    // since the loop will end if and only if the user enters 8, so it depends on the user input
    // But we assume that if the user entered a number then the loop will start running
    // And the worst case for that if the value that user was looking for does not exist
    // Then we can say that search function is a O(N)
    public Boolean search(String criteria, String value) {
        int counter = 0;
        if (contact.empty()) {
             return false;
        }
        contact.findFirst();
        // The Big O of split built-in Function is O(n)
        String [] splitName = contact.retrieve().getName().split(" ", 0);
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
                // for the feature number 6
                case "firstName" -> {
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

    //----------------------removeContact Function description-------------------------
    // This method will search about contact by using search method
    // If it finds it , it will delete this contact and its event
    //--------------------------------Big O--------------------------------------------
    // This method is big O(n) since the worst case scenario is the contact is not found
    // Or there is no event for the contact that we will delete it
    public void removeContact(String criteria, String value){
        if(search(criteria, value)){
            String name = contact.retrieve().getName();
            contact.remove();
            while(true){
                if (contact.retrieve().getName().equalsIgnoreCase(name));
                    event.remove();
                if (event.last())
                    break;
            }
            System.out.println("Has been successfully removed\n");
            return;
        }
        System.out.println("No contacts removed\n");
        return;
    }
    //------------------searchEvent Method Description----------------------
    // searchEvent Method depends on search method to set the current contact node
    // On the Wanted contact, if it returns true then it was found and if it was false
    // then it does not exist.
    // ----------------------------Big O----------------------------------
    // Since we used the search function then we can tell for now it's definitely
    // It's an O(n), also if the find the contact it will call the printAllEvent() function
    // what it does is to loop all over the event Linked List, So here is another O(n)
    // We do have a loop in the event case also which will loop until it finds the event
    // So obviously it's a O(n)
    public void searchEvent(String criteria, String value) {
        switch (criteria) {
        case "name" -> {
            boolean currentContact = search("nonPrintName" , value);
            if (currentContact)
                contact.retrieve().printAllEvent();
            }
           case "event" -> {
                int lengthE = event.getLength();
                event.findFirst();
                for (int j = 0; j < lengthE; j++) {
                    if (event.retrieve().getTitle().equalsIgnoreCase(value)){
                        printEventData();
                        return;
                    }
                    else
                        event.findNext();

                }
            }
        }

    }
    public void sortedAddEvent(Event e) {
       Boolean con = search("nonPrintName" , e.getContect().getName());
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

    public void printContact(){
        System.out.println("Name: " + contact.retrieve().getName());
        System.out.println("Phone Number: " + contact.retrieve().getPhoneNumber());
        System.out.println("Email Address: " + contact.retrieve().getEmailAddress());
        System.out.println("Address: " + contact.retrieve().getAddress());
        System.out.println("Birthday: " + contact.retrieve().getBirthday());
        System.out.println("Notes: " + contact.retrieve().getNotes());
        System.out.println("==============================");
    }
    //--------------------printallContacts Function description----------------------------
    //this function will print all contacts and its information by calling printContact method
    //--------------------------------Big o------------------------------------------------
    // its big O(n) because its depends on the (n) number of contact that will add.
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
    //-----------printEventData Function description------
    // This function will print the event information
    //-----------------------Big o----------------------
    // Its big O(1)
    public void printEventData() {
        System.out.println("title: " + event.retrieve().getTitle());
        System.out.println("event date: " + event.retrieve().getDate());
        System.out.println("event time: " + event.retrieve().getTime());
        System.out.println("location: " + event.retrieve().getLocation());
        System.out.println();
    }
    //-------------------------printAllEvent Function description----------------------------
    // This function will print all events and its information by calling printEventData method
    //--------------------------------Big O--------------------------------------------------
    // Its big O(n) because its depends on the (n) number of event that will add.
    public void printAllEvent() {
        if (event.empty()) {
            System.out.println("The event is empty");
            return;
        }
        event.findFirst();
        while (!event.last()) {
            printEventData();
            event.findNext();
            System.out.println();
        }
        printEventData();
        System.out.println();
    }
}