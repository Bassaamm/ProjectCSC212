public class Contact implements Comparable<Contact>{
    private String name;
    private String phoneNumber;
    private String emailAddress;
    private String address;
    private String birthday;
    private String notes;
    public LinkedList<Event>event;

    public Contact(String name, String phoneNumber, String emailAddress, String address, String birthday, String notes) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.address = address;
        this.birthday = birthday;
        this.notes = notes;
        event=new LinkedList<Event>();


    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    // The Big O of compareTo function is O(n)
    public int compareTo(Contact contact) {
        //x.compareto(y), = 0 (equal), <0 (x before), >0 (y before)
        return this.name.compareTo(contact.name);
    }
    //-------------------------printAllEvent Function description----------------------------
    // This function will print all events and its information by calling printEventData method
    //--------------------------------Big o--------------------------------------------------
    // Its big O(n) because its depends on the (n) number of event that will add.
    public void printAllEventContact() {
        if (event.empty()) {
            System.out.println("The event is empty");
            return;
        }
        event.findFirst();
        while (!event.last()) {
            System.out.println(event.retrieve().toString());
            event.findNext();
        }
        System.out.println(event.retrieve().toString());
    }

    // The Big O of toString function is O(1)
    public String toString() {
        return  "Name: " + name + '\n' +
                "Phone number: " + phoneNumber + '\n' +
                "Email address: " + emailAddress + '\n' +
                "Address: " + address + '\n' +
                "Birthday: " + birthday + '\n' +
                "Notes: " + notes + '\n'
                ;
    }
}
