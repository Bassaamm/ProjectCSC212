import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;
public class Main {
    public static void main(String[] args)  {
        Phonebook phonebook = new Phonebook();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        Scanner scanner = new Scanner(System.in);
        int mainSwitch;
        boolean mainMenu = true;
        System.out.println("Welcome to the linked Tree Phonebook!");

        do{
            System.out.println("Event added");
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
                    String Scancontumer = scanner.nextLine();
                    String name = scanner.nextLine();
                    System.out.println(name);

                    //duplicate name checker
                    if(phonebook.search("name", name)){
                        System.out.println("A contact with the same name already exists \n");
                        break;
                    }

                    System.out.print("Enter the contact's phone number: ");
                    String phoneNumber = scanner.next();

                    //duplicate number checker
                    if(phonebook.search("phoneNumber", phoneNumber)){
                        System.out.println("A contact with the same phone number already exists \n");
                        break;
                    }

                    System.out.print("Enter the contact's email address: ");
                    String email = scanner.next();

                    System.out.print("Enter the contact's address: ");
                    Scancontumer = scanner.nextLine();
                    String address = scanner.nextLine();

                    System.out.print("Enter the contact's birthday: ");
                    String birthday = scanner.next();

                    System.out.print("Enter any notes contact: ");
                    String note = scanner.next();

                    // Creating Contact
                    Contact newContact = new Contact(name, phoneNumber, email, address, birthday, note);
                    phonebook.sortedAdd(newContact);
                    phonebook.contact.printList();
                    System.out.println();
                }

                //Search for a contact
                case 2 -> {
                    System.out.println("Enter search criteria:");
                    System.out.println("1.Name");
                    System.out.println("2.Phone Number");
                    System.out.println("3.Email Address");
                    System.out.println("4.Address");
                    System.out.println("5.Birthday \n" );
                    System.out.print("Enter your choice: ");
                    int option = scanner.nextInt();
                    switch (option){

                        case 1 -> {
                            System.out.print("Enter the name: ");
                            String name = scanner.nextLine();
                            System.out.println();
                            phonebook.search("name", name);
                        }
                        case 2 -> {
                            System.out.print("Enter the number: ");
                            String phoneNumber = scanner.next();
                            System.out.println();
                            phonebook.search("phoneNumber", phoneNumber);
                        }
                        case 3 ->  {
                            System.out.print("Enter the email: ");
                            String email = scanner.next();
                            System.out.println();
                            phonebook.search("email", email);
                        }
                        case 4 -> {
                            System.out.println("Enter the Address: ");
                            String address = scanner.next();
                            System.out.println();
                            phonebook.search("address", address);
                        }
                        case 5 -> {
                            System.out.println("Enter the Birthday: ");
                            String birthday = scanner.next();
                            System.out.println();
                            phonebook.search("birthday", birthday);
                        }
                        default -> System.out.println("Invalid input");
                    }
                    System.out.println();
                }

                // Delete a contact (Incomplete)
                case 3 ->{
                    System.out.println("Enter search criteria: ");
                    System.out.println("1.Name");
                    System.out.println("2.Phone Number\n");
                    System.out.print("Enter your choice: ");
                    int option = scanner.nextInt();
                    switch (option){
                        case 1 -> {
                            System.out.print("Enter the name: ");
                            String ScanConsumer = scanner.nextLine();
                            String name = scanner.nextLine();
                            phonebook.removeContact("name", name);
                        }
                        case 2 ->{
                            System.out.print("Enter the number: ");
                            String ScanConsumer = scanner.nextLine();
                            String phoneNumber = scanner.nextLine();
                            phonebook.removeContact("phoneNumber", phoneNumber);
                        }
                    }
                }

                //Scheduale an event (Incomplete)
                case 4 -> {
                    System.out.print("Enter event title: ");
                    String title = scanner.next();
                    System.out.print("Enter contact name: ");
                    String name = scanner.next();
                    String ScannerConsumer = scanner.nextLine();
                    System.out.print("Enter event date and time(MM/DD/YYYY HH:MM): ");
                    String dateTime = scanner.nextLine();
                    System.out.print("Enter event location: ");
                    String location = scanner.next();
                    System.out.println();
                    if (phonebook.search("name", name)) {
                        try {
                            LocalDateTime allDate = LocalDateTime.parse(dateTime, format);
                            LocalDate date = allDate.toLocalDate();
                            LocalTime time = allDate.toLocalTime();
                            Event newEvent = new Event(title , date ,time, location , phonebook.contact.retrieve());
                            phonebook.sortedAddEvent(newEvent);
                            System.out.println("Event added");
                        } catch (Exception e) {
                            System.out.println("Invalid input. Please enter in the format dd/MM/yyyy HH:mm");
                        }
                    }
                    else
                        System.out.println("Failed to add event");
                }

                //
                case 5 -> {
                    System.out.println("Enter search criteria:");
                    System.out.println("1.Contact name");
                    System.out.println("2.Event title \n");
                    System.out.print("Enter your choice: ");
                    int option = scanner.nextInt();
                    switch (option){
                        case 1 -> {
                            System.out.print("Enter the contact name: ");
                            String name = scanner.next();
                            System.out.println();
                            phonebook.searchEvent("name", name);
                        }
                        case 2 -> {
                            System.out.print("Enter the event title: ");
                            String event = scanner.next();
                            System.out.println();
                            phonebook.searchEvent("event", event);
                        }
                        default -> System.out.println("Invalid input");
                    }
                }
                //Testing stuff
                case 6 -> {
                    System.out.print("Enter the first name: ");
                    String name = scanner.next();
                    if(!phonebook.search("firstName", name))
                        System.out.println("Sorry there are no contacts with this name\n");

                }
                //Testing stuff
                case 7 -> {
                    Contact newContact = new Contact("fahad", "055", "email", "address", "birthday", "note");
                    phonebook.sortedAdd(newContact);
                    Contact newContact3 = new Contact("khalid", "056", "email2", "address2", "birthday2", "note2");
                    phonebook.sortedAdd(newContact3);
                    Contact newContact2 = new Contact("abdullah", "057", "email2", "address2", "birthday2", "note2");
                    phonebook.sortedAdd(newContact2);
                    phonebook.printAllEvent();
                }
                case 8 -> mainMenu = false;
                case 9 -> phonebook.printAllContacts();
                default -> System.out.println("Please enter a valid input\n");
            }

        }while(mainMenu);
        System.out.println("Goodbye!");
    }

    }
