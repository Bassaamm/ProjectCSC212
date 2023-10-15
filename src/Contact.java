public class Contact implements Comparable<Contact>{
    private String name;
    private String phoneNumber;
    private String emailAddress;
    private String address;
    private String birthday;
    private String notes;
    public LinkedList<Event>event;

    public Contact() {
        this.name = "";
        this.phoneNumber = "";
        this.emailAddress = "";
        this.address = "";
        this.birthday = "";
        this.notes = "";
        this.event = new LinkedList<Event>();
    }

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


    public int compareTo(Contact contact) {
        //x.compareto(y), = 0 (equal), <0 (x before), >0 (y before)
        return this.name.compareTo(contact.name);
    }
    public void printAllEvent() {
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

    @Override
    public String toString() {
        return "Contact " +'\n'+
                "name= " + name + '\n' +
                "phoneNumber= " + phoneNumber + '\n' +
                "emailAddress= " + emailAddress + '\n' +
                "address= " + address + '\n' +
                "birthday= " + birthday + '\n' +
                "notes= " + notes + '\n'
                ;
    }
}
