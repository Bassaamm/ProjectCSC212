import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();
        Scanner scanner = new Scanner(System.in);
        int mainSwitch;
        System.out.println("Welcome to the linked Tree Phonebook!");
        do{
            System.out.println("Please choose an option:");
            System.out.println("1.Add a contact");
            System.out.println("2.Search for a contact");
            System.out.println("3.Delete a contact");
            System.out.println("4.Schedule an event");
            System.out.println("5.Print event details");
            System.out.println("6.Print contact by first name");
            System.out.println("7.Print all events alphabetically");
            System.out.println("8.Exit");
            System.out.println();
            System.out.print("Enter your choice: ");
            mainSwitch = scanner.nextInt();
            System.out.println();

            switch (mainSwitch){
                case 1 -> {
                    System.out.print("Enter the contact's name: ");
                    String name = scanner.next();

                    System.out.print("Enter the contact's phone number: ");
                    int phoneNumber = scanner.nextInt();

                    System.out.print("Enter the contact's email address: ");
                    String email = scanner.next();

                    System.out.print("Enter the contact's address: ");
                    String address = scanner.next();

                    System.out.print("Enter the contact's birthday: ");
                    String birthday = scanner.next();

                    System.out.print("Enter any notes contact: ");
                    String note = scanner.next();

                    //add duplicate checker before insertion to phonebook
                    Contact newContact = new Contact(name, phoneNumber, email, address, birthday, note);
                }

                case 2 -> {
                    System.out.println("Enter search criteria:");
                    System.out.println("1.Name");
                    System.out.println("2.Phone Number");
                    System.out.println("3.Email Address");
                    System.out.println("4.Address");
                    System.out.println("5.Birthday");
                    System.out.println();
                    System.out.print("Enter your choice: ");
                    int option = scanner.nextInt();
                    switch (option){
                        case 1 -> System.out.println("1");
                        case 2 -> System.out.println("2");
                        case 3 -> System.out.println("3");
                        case 4 -> System.out.println("4");
                        case 5 -> System.out.println("5");
                        default -> System.out.println("Invalid input");
                    }

                    System.out.println();
                }
                case 3 -> System.out.println("Case 3");
                case 4 -> {
                    System.out.print("Enter event title: ");
                    String title = scanner.next();
                    System.out.print("Enter contact name: ");
                    String name = scanner.next();
                    System.out.print("Enter event date and time(MM/DD/YYYY HH:MM): ");
                    String dateTime = scanner.next();
                    System.out.print("Enter event location: ");
                    String location = scanner.next();
                    System.out.println();

                }
                case 5 -> {
                    System.out.println("Enter search criteria:");
                    System.out.println("1.Contact name");
                    System.out.println("2.Event title");
                    System.out.println();
                    System.out.print("Enter your choice: ");
                    int option = scanner.nextInt();

                    if(option == 1){
                        System.out.println("1");
                    } else if (option == 2) {
                        System.out.println("2");
                    } else {
                        System.out.println("Invalid input");
                    }
                    System.out.println();
                }
                case 6 -> System.out.println("6- Print contacts by first name");
                case 7 -> System.out.println("7- Print all events alphabetically");
            }
        }while(mainSwitch != 8);
        System.out.println();
        System.out.println("Goodbye!");
    }
}