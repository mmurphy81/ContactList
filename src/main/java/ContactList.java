import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class ContactList {
    private ArrayList<Person> contacts;

    public ContactList(ArrayList<Person> contacts) {
        this.contacts = contacts;
    }

    public ArrayList<Person> getContacts() {
        return contacts;
    }

    public void addContact() {
        System.out.println("Select a type of contact to add \n 1 is Student and 2 is Teacher");
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        s.nextLine();
        System.out.println("What is the first name?");
        String firstName = s.nextLine();
        System.out.println("What is the last name?");
        String lastName = s.nextLine();
        System.out.println("What is the phone number?");
        String phoneNumber = s.nextLine();

        Person p;
        if (num == 1) {
            System.out.println("What is their grade?");
            int grade = s.nextInt();
            s.nextLine();
            p = new Student(firstName, lastName, phoneNumber, grade);
        }
        if (num == 2) {
            System.out.println("What is their subject?");
            String subject = s.nextLine();
            p = new Teacher(firstName, lastName, phoneNumber, subject);
        }
    }

    public void printContacts() {
        for (Person contact : contacts) {
            System.out.print(contact);
        }
    }

    public ArrayList<Person> sort(int sortBy) {
        ArrayList<Person> sorted = new ArrayList<>(contacts);

        int size = sorted.size();
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                Person p1 = sorted.get(j);
                Person p2 = sorted.get(j + 1);
                boolean isSwap = false;

                if (sortBy == 0) {
                    isSwap = p1.getFirstName().compareTo(p2.getFirstName()) > 0;
                } else if (sortBy == 1) {
                    isSwap = p1.getLastName().compareTo(p2.getLastName()) > 0;
                } else if (sortBy == 2) {
                    isSwap = p1.getPhoneNumber().compareTo(p2.getPhoneNumber()) > 0;
                }

                if (isSwap) {
                    sorted.set(j, p2);
                    sorted.set(j + 1, p1);
                }

            }
        }
        System.out.println(sorted);
        return sorted;
    }
    public Person search(int searchBy, String target) {
        for (Person people : contacts) {
            if (searchBy == 0 && people.getFirstName().equalsIgnoreCase(target)) {
                return people;
            }
            else if (searchBy == 1 && people.getLastName().equalsIgnoreCase(target)) {
                return people;
            }
            else if (searchBy == 2 && people.getPhoneNumber().equalsIgnoreCase(target)) {
                return people;
            }
        }
        return null;
    }

    public void listStudents() {
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i) instanceof Student) {
                System.out.println(contacts.get(i));
            }
        }
    }

    public void run() {
        Scanner s = new Scanner(System.in);
        System.out.println("Menu: \n 1. Add contact \n 2. List all Contacts by first name \n 3. List all contacts by last name \n " +
                "4. List all contacts by phone number \n 5. List all students \n 6. Search by First Name \n 7. Search by last name " +
                "\n 8. Search by phone number \n 0. Exit");
        int key = s.nextInt();
        switch(key) {
            case 0 : System.exit(0);
                break;
            case 1 : addContact();
                break;
            case 2 : sort(0);
                break;
            case 3: sort(1);
                break;
            case 4: sort (2);
                break;
            case 5: listStudents();
                break;
            case 6:
                s.nextLine();
                System.out.println("Print a first name");
                String firstName = s.nextLine();
                Person result = search(0, firstName);
                if ( result == null) {
                    System.out.println(firstName + " is not on the list");
                }
                else {
                    System.out.println(result);
            }

            case 7:
                s.nextLine();
                System.out.println("Print a last name");
                String lastName = s.nextLine();
                Person result1 = search(1, lastName);
                if ( result1 == null) {
                    System.out.println(lastName + " is not on the list");
                }
                else{
                System.out.println(result1);
            }
            case 8:
                s.nextLine();
                System.out.println("Print a phone number");
                String phoneNumber = s.nextLine();
                Person result2 = search(2, phoneNumber);
                if ( result2 == null) {
                    System.out.println(phoneNumber + " is not on the list");
                }
                else{
                System.out.println(phoneNumber);
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Person> peoples = new ArrayList<>();
        Person mera = new Person("Mera", "Murphy", "6507145901");
        Person Eisha = new Person("Eisha", "Yadav", "6787528201");
        peoples.add(mera);
        peoples.add(Eisha);
        ContactList list = new ContactList(peoples);

        list.run();

    }
}
