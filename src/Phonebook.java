
public class Phonebook{

    public LinkedList<Contact> contact;
    public LinkedList<Event> event;
    public Phonebook() {
        contact = new LinkedList<Contact>();
        event = new LinkedList<Event>();
    }

    //----------------SortedAdd Function Description--------------------
    // It accepts a contact from the user via the add a contact case in the main
    // and adds them to the contacts LinkedList sorted descending alphabetically
    //----------------------------Big O----------------------------------
    // The worst case scenario is that the contact's name is the largest alphabetically
    // so the Linked List pointer would point to the tail before calling either the insert
    // or the insertBefore function both of which are O(n) so the big O of this function
    // is O(n+m) which when simplified is O(n)
    public void sortedAdd(Contact e){

        if(contact.empty()){
            contact.insert(e);
            return;
        }
        contact.findFirst();

        while(!contact.last()){
            //if the name of the new contact is smaller alphabetically than the current, break.
            if(contact.retrieve().getName().compareTo(e.getName()) > 0)
                break;
            contact.findNext();
        }
        //to handle if the pointer is on the tail and see if it should be inserted before or after tail
        if(contact.retrieve().getName().compareTo(e.getName()) <= 0) {
            contact.insert(e);
            return;
        }
        //inserts the new contact before the contact that is immediately larger than it
        contact.insertBefore(e, contact.retrieve());
    }
    //------------------Search Function Description----------------------
    // It's for the 6 input which is look for the events by the first name
    // It takes a value as parameter
    // ----------------------------Big O----------------------------------
    // We have a nested loop
    //
    // Then we can say that search function is a O(n^2)
    public void searchFirstName(String value) {
        int counter = 0;
        boolean passedLast = true;
        if (contact.empty())
            return;
        contact.findFirst();
        do {
            if (contact.last())
                passedLast = false;
            String[] splitName = contact.retrieve().getName().split(" ", 0);
            if (splitName[0].equalsIgnoreCase(value)) {
                if (counter == 0)
                    System.out.println("\nContacts found!\n");
                System.out.println(contact.retrieve().toString());
                counter++;
            }
            if (!contact.last())
                contact.findNext();
        } while (!contact.last() || passedLast);
        if (counter == 0)
            System.out.println("Sorry no contacts with thi name exist.\n");
    }
    //------------------Search Function Description----------------------
    // it uses the criteria parameter to let the use decide which attribute
    // Wants to use to search by, the value parameter takes the user input.
    // It returns a true if the value the user was looking for was found
    // ----------------------------Big O----------------------------------
    // The worst case for that if the value that user was looking for does not exist,
    // Then we can say that search function is a O(n)
    public Boolean search(String criteria, String value) {
        int counter = 0;
        // passedLast is used to check if the do while loop should check
        //
        boolean passedLast = true;
        if (contact.empty()) {
             return false;
        }
        contact.findFirst();

        // The Big O of split built-in Function is O(n)
        do {
            if (contact.last())
                passedLast = false;
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
                case "phoneNumber" -> {
                    System.out.println();
                    if (contact.retrieve().getPhoneNumber().equalsIgnoreCase(value)) {
                        System.out.println(contact.retrieve().toString());
                        return true;
                    }
                }
                case "nonPrintPhoneNumber" -> {
                    System.out.println();
                    if (contact.retrieve().getPhoneNumber().equalsIgnoreCase(value)) {
                        return true;
                    }
                }

                case "email" -> {
                    if (contact.retrieve().getEmailAddress().equalsIgnoreCase(value)){
                        if(counter == 0)
                            System.out.println("Contacts found!\n");
                        counter++;
                        System.out.println(contact.retrieve().toString());
                    }
                }
                case "address" -> {
                    if (contact.retrieve().getAddress().equalsIgnoreCase(value)){
                        if(counter == 0)
                            System.out.println("Contacts found!\n");
                        counter++;
                        System.out.println(contact.retrieve().toString());
                    }
                }
                case "birthday" -> {
                    if (contact.retrieve().getBirthday().equalsIgnoreCase(value)){
                        if(counter == 0)
                            System.out.println("Contacts found!\n");
                        counter++;
                        System.out.println(contact.retrieve().toString());
                    }
                }
            }
            if(!contact.last())
                contact.findNext();
        }while(!contact.last() || passedLast);
        return !(counter == 0);
    }
    //----------------------removeContact Function description-------------------------
    // This method will search about contact by using search method
    // If it finds it , it will delete this contact and its event
    //--------------------------------Big O--------------------------------------------
    // This method is big O(n) since the worst case in this scenario is the contact
    // is not found Or there is no event for the contact that we will delete it
    public void removeContact(String criteria, String value){
        boolean passedLast = true;
        if(search(criteria, value)){
            String name = contact.retrieve().getName();
            contact.remove();
            do {
                if (contact.last())
                    passedLast = false;
              if (event.empty()){
                  System.out.println("Contact Has been successfully removed\n");
                    return;
              }
                if(contact.retrieve().getName().equalsIgnoreCase(name))
                    event.remove();
                if(!contact.last())
                    contact.findNext();
            } while (!event.last() || passedLast);
            System.out.println("Contact and his events were successfully removed\n");
            return;
        }
        System.out.println("No contacts removed\n");
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
                    contact.retrieve().printAllEventContact();
            }
            case "event" -> {
                int lengthE = event.getLength();
                event.findFirst();
                for (int j = 0; j < lengthE; j++) {
                    if (event.retrieve().getTitle().equalsIgnoreCase(value)){
                        System.out.println(event.retrieve().toString());
                        return;
                    }
                    else
                        event.findNext();

                }
            }
        }

    }
    //----------------sortedAddEvent Function Description--------------------
    // It accepts an Event from the user via the add an event case in the main
    // and adds them to the event LinkedList sorted descending alphabetically
    //----------------------------Big O----------------------------------
    // The worst case scenario is that the event's name is the largest alphabetically
    // so the Linked List pointer would point to the tail before calling either the insert
    // or the insertBefore function both of which are O(n) so the big O of this function
    // is O(n+m) which when simplified is O(n)
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

    //-------------------------printAllEvent Function description----------------------------
    // This function will print all events and its information by calling printEventData method
    //--------------------------------Big O--------------------------------------------------
    // Its big O(n) because its depends on the (n) number of event that will add.

    public void printAllEventPhoneBook() {
        if (event.empty()) {
            System.out.println("The event is empty");
            return;
        }
        event.printAll();
    }
}