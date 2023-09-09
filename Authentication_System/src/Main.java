import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class UserAuthentication {
    private Map<String, String> users = new HashMap<>();

    public void SignUpUser(String username, String password) {
        if (users.containsKey(username)) {
            System.out.println("Username already exists. Please choose a different one.");
        } else if (!isValidPassword(password)) {
            System.out.println("Invalid password. Please follow the password criteria.");
        } else {
            users.put(username, password);
            System.out.println("SignUp successful!");
        }
    }

    public boolean SignInUser(String username, String password) {
        if (users.containsKey(username)) {
            if (users.get(username).equals(password)) {
                System.out.println("Login successful! You can now access the secured page.");
                return true;
            } else {
                System.out.println("Incorrect password. Please try again.");
            }
        } else {
            System.out.println("Username not found. Please register first.");
        }
        return false;
    }

    private static boolean isValidPassword(String password) {
        // Minimum length of 8 characters
        if (password.length() < 8) {
            return false;
        }

        // At least one symbol
        Pattern symbolPattern = Pattern.compile("[!@#$%^&*()_+\\-=\\[\\]{};':\",.<>?]");
        Matcher symbolMatcher = symbolPattern.matcher(password);
        if (!symbolMatcher.find()) {
            return false;
        }

        // At least one number
        Pattern numberPattern = Pattern.compile("\\d");
        Matcher numberMatcher = numberPattern.matcher(password);
        if (!numberMatcher.find()) {
            return false;
        }

        // At least one uppercase letter
        Pattern uppercasePattern = Pattern.compile("[A-Z]");
        Matcher uppercaseMatcher = uppercasePattern.matcher(password);
        if (!uppercaseMatcher.find()) {
            return false;
        }

        // At least one lowercase letter
        Pattern lowercasePattern = Pattern.compile("[a-z]");
        Matcher lowercaseMatcher = lowercasePattern.matcher(password);
        if (!lowercaseMatcher.find()) {
            return false;
        }

        // If all conditions are met, the password is valid
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        UserAuthentication userAuth = new UserAuthentication();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("- - - - - Welcome - - - - -");
            System.out.println("1. SignUp");
            System.out.println("2. SignIn");

            System.out.print("Please select an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter a username: ");
                    String username = scanner.next();
                    System.out.println("Password requirements---\n1. Minimum 8 Character. \n2. At least one Number \n3. At least one Symbol. \n4. At least one Upper case and one Lower case Character ");
                    System.out.print("Enter a password: ");
                    String password = scanner.next();

                    userAuth.SignUpUser(username, password);
                    break;
                case 2:
                    System.out.print("Enter your username: ");
                    username = scanner.next();
                    System.out.print("Enter your password: ");
                    password = scanner.next();
                    userAuth.SignInUser(username, password);
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
