
    import java.io.*;
import java.util.*;
public class PasswordManeger {

    static Scanner sc = new Scanner(System.in);
    static List<PasswordEntry> entries = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n==== Password Manager ====");
            System.out.println("1. Add Password");
            System.out.println("2. View Passwords");
            System.out.println("3. Generate Strong Password");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addPassword();
                case 2 -> viewPasswords();
                case 3 -> generatePassword();
                case 4 -> {
                    System.out.println("Exiting... Bye!");
                    return;
                }
                default -> System.out.println("Invalid choice! Try again.");
            }
        }
    }

    static void addPassword() {
        System.out.print("Enter Website: ");
        String website = sc.nextLine();
        System.out.print("Enter Username: ");
        String username = sc.nextLine();
        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        PasswordEntry entry = new PasswordEntry(website, username, password);
        entries.add(entry);
        saveToFile(entry);
        System.out.println("✅ Password Saved!");
    }

    static void viewPasswords() {
        try (BufferedReader br = new BufferedReader(new FileReader("passwords.txt"))) {
            String line;
            System.out.println("\n--- Saved Passwords ---");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("⚠️ No passwords saved yet.");
        }
    }

    static void generatePassword() {
        System.out.print("Enter desired password length: ");
        int length = sc.nextInt();
        sc.nextLine(); // consume newline
        String password = Passwordutil.generatePassword(length);
        System.out.println("Generated Password: " + password);
    }

    static void saveToFile(PasswordEntry entry) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("passwords.txt", true))) {
            bw.write(entry.toString());
            bw.newLine();
        } catch (IOException e) {
            System.out.println("❌ Error saving password.");
        }
    }
}


