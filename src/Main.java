import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args)  {
        Phonebook phonebook = new Phonebook();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        Scanner scanner = new Scanner(System.in);
        String mainSwitch;
        boolean mainMenu = true;
        System.out.println("Welcome to the linked Tree Phonebook!");

        do{
            //main menu
            System.out.println("Please choose an option:");
            System.out.println("1.Add a contact");
            System.out.println("2.Search for a contact");
            System.out.println("3.Delete a contact");
            System.out.println("4.Schedule an event");
            System.out.println("5.Print event details");
             System.out.println("6.Print contact by first name");
            System.out.println("7.Print all events alphabetically");
            System.out.println("8.Exit\n");
            System.out.print("Enter your choice: ");
            mainSwitch = scanner.next();
            System.out.println();

            switch (mainSwitch){
                case "1" -> {
                    //name input
                    System.out.print("Enter the contact's name: ");
                    String scanConsumer = scanner.nextLine();
                    String name = scanner.nextLine();
                    Pattern patternName = Pattern.compile("^[A-Za-z]+\\s[A-Za-z]+$");
                    Matcher nameMatch = patternName.matcher(name);
                    if(!nameMatch.matches()){
                        System.out.println("\nInvalid name please separate the first and last names with a space (ex:firstName lastName)\n");
                        break;
                    }

                    //duplicate name checker
                    if(phonebook.search("nonPrintName", name)){
                        System.out.println("A contact with the same name already exists \n");
                        break;
                    }

                    System.out.print("Enter the contact's phone number: ");
                    String phoneNumber = scanner.next();
                    Pattern patternNumber = Pattern.compile("^\\d{10}$");
                    Matcher phoneMatch = patternNumber.matcher(phoneNumber);
                    if(!phoneMatch.matches()){
                        System.out.println("\nInvalid phone number please insert 10 consecutive numbers (ex:1234567890)\n");
                        break;
                    }

                    //duplicate number checker
                    if(phonebook.search("nonPrintPhoneNumber", phoneNumber)){
                        System.out.println("A contact with the same phone number already exists \n");
                        break;
                    }

                    //email input
                    System.out.print("Enter the contact's email address: ");
                    String email = scanner.next();

                    //address input
                    System.out.print("Enter the contact's address: ");
                    scanConsumer = scanner.nextLine();
                    String address = scanner.nextLine();

                    //birthday input
                    System.out.print("Enter the contact's birthday: ");
                    String birthday = scanner.next();
                    Pattern patternBirthday = Pattern.compile("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/(\\d{4})$");
                    Matcher birthdayMatch = patternBirthday.matcher(birthday);
                    if(!birthdayMatch.matches()){
                        System.out.println("\nInvalid birthday please use the format: DD/MM/YYYY.\n");
                    }



                    //notes input
                    System.out.print("Enter any notes contact: ");
                    String note = scanner.next();

                    // Creating Contact
                    Contact newContact = new Contact(name, phoneNumber, email, address, birthday, note);
                    phonebook.sortedAdd(newContact);
                    System.out.println("\nContact added successfully!\n");
                }

                //Search for a contact
                case "2" -> {
                    System.out.println("Enter search criteria:");
                    System.out.println("1.Name");
                    System.out.println("2.Phone Number");
                    System.out.println("3.Email Address");
                    System.out.println("4.Address");
                    System.out.println("5.Birthday MM/DD/YYYY \n" );
                    System.out.print("Enter your choice: ");
                    String option = scanner.next();
                    switch (option){
                        case "1" -> {
                            System.out.print("Enter the contact's name: ");
                            String scanConsumer = scanner.nextLine();
                            String name = scanner.nextLine();
                            phonebook.search("name", name);
                        }
                        case "2" -> {
                            System.out.print("Enter the contact's number: ");
                            String phoneNumber = scanner.next();
                            System.out.println();
                            phonebook.search("phoneNumber", phoneNumber);
                        }
                        case "3" ->  {
                            System.out.print("Enter the contact's email: ");
                            String email = scanner.next();
                            System.out.println();
                            phonebook.search("email", email);
                        }
                        case "4" -> {
                            System.out.println("Enter the contact's Address: ");
                            String scanConsumer = scanner.nextLine();
                            String address = scanner.next();
                            System.out.println();
                            phonebook.search("address", address);
                        }
                        case "5" -> {
                            System.out.println("Enter the contact's Birthday: ");
                            String birthday = scanner.next();
                            System.out.println();
                            phonebook.search("birthday", birthday);
                        }
                        default -> System.out.println("Invalid input");
                    }
                    System.out.println();
                }

                // Delete a contact
                case "3" ->{
                    System.out.println("Enter remove criteria: ");
                    System.out.println("1.Name");
                    System.out.println("2.Phone Number\n");
                    System.out.print("Enter your choice: ");
                    String option = scanner.next();
                    switch (option){
                        case "1" -> {
                            System.out.print("Enter the name: ");
                            String scanConsumer = scanner.nextLine();
                            String name = scanner.nextLine();
                            phonebook.removeContact("name", name);
                        }
                        case "2" ->{
                            System.out.print("Enter the number: ");
                            String phoneNumber = scanner.next();
                            phonebook.removeContact("phoneNumber", phoneNumber);
                        }
                        default -> System.out.println("Invalid input");
                    }
                }

                //Schedule an event
                case "4" -> {
                    System.out.print("Enter event title: ");
                    String title = scanner.next();
                    System.out.print("Enter contact name: ");
                    String scanConsumer = scanner.nextLine();
                    String name = scanner.nextLine();
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
                case "5" -> {
                    System.out.println("Enter search criteria:");
                    System.out.println("1.Contact name");
                    System.out.println("2.Event title \n");
                    System.out.print("Enter your choice: ");
                    String option = scanner.next();
                    switch (option){
                        case "1" -> {
                            System.out.print("Enter the contact name: ");
                            String scanConsumer = scanner.nextLine();
                            String name = scanner.nextLine();
                            System.out.println();
                            phonebook.searchEvent("name", name);
                        }
                        case "2" -> {
                            System.out.print("Enter the event title: ");
                            String event = scanner.next();
                            System.out.println();
                            phonebook.searchEvent("event", event);
                        }
                        default -> System.out.println("Invalid input");
                    }
                }

                case "6" -> {
                    System.out.print("Enter the first name: ");
                    String name = scanner.next();
                    phonebook.searchFirstName(name);

                }

                case "7" -> {
                    Contact c1 = new Contact("fahad f", "052", "a", "b", "c", "d");
                    Contact c2 = new Contact("ahmad a", "056", "a", "b", "c", "d");
                    Contact c3 = new Contact("khalid ka", "054", "a", "b", "c", "d");
                    Contact c4 = new Contact("abdullah ab", "053", "a", "b", "c", "d");
                    phonebook.sortedAdd(c1);
                    phonebook.sortedAdd(c2);
                    phonebook.sortedAdd(c3);
                    phonebook.sortedAdd(c4);
                    phonebook.printAllEventPhoneBook();

                }
                case "8" -> mainMenu = false;
                default -> System.out.println("Please enter a valid input\n");
            }

        }while(mainMenu);
        System.out.println("Goodbye!");
    }

    }
