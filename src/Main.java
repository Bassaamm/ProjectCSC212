import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);
        System.out.println("Welcome to the linked Tree Phonebook!");
        int option;
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
            System.out.print("Enter your choice:");
            option = s1.nextInt();

            switch (option){
                case 1 -> {
                    System.out.print("Enter the contact's name:");
                    String name = s1.next();

                    System.out.print("Enter the contact's phone number:");
                    int phoneNumber = s1.nextInt();

                    System.out.print("Enter the contact's email address:");
                    String email = s1.next();

                    System.out.print("Enter the contact's address:");
                    String address = s1.next();

                    System.out.print("Enter the contact's birthday:");
                    String birthday = s1.next();

                    System.out.print("Enter any notes contact: ");
                    String note = s1.next();

                    Contact newContact = new Contact(name, phoneNumber, email, address, birthday, note);

                }
                case 2 -> System.out.println("Case 2");
                case 3 -> System.out.println("Case 3");
                case 4 -> System.out.println("Case 4");
                case 5 -> System.out.println("Case 5");
                case 6 -> System.out.println("Case 6");
                case 7 -> System.out.println("Case 7");
            }
        }while(option != 8);
        System.out.println();
        System.out.println("Goodbye!");
    }
}