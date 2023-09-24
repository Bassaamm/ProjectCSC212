public class Contact implements Comparable {
    public String name;
    public int phoneNumber;
    public String emailAddress;
    public String address;
    public String birthday;
    public String notes;
    public Contact(String name, int phoneNumber, String emailAddress, String address, String birthday, String notes) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.address = address;
        this.birthday = birthday;
        this.notes = notes;
    }
    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
