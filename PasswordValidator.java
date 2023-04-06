import java.util.Scanner;

public class PasswordValidator {
    private static final String lower_case_regex = ".*[a-z].*";
    private static final String upper_case_regex = ".*[A-Z].*";
    private static final String digit_regex = ".*\\d.*";
    private static final String special_char_regex = ".*[~!@#$%^&*\\(\\)-=+_].*";  //The backslashes are to escape the special characters
    
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter a password to validate: ");
            String password = sc.nextLine();
            if (isValid(password)) {
                System.out.println("Valid password");
            } else {
                System.out.println("Invalid password");
            }
        }
    }
    
    private static boolean isValid(String password) {
        if (password.length() < 8 || password.length() > 16) {
            return false;
        }
        int categoriesCount = 0;
        if (password.matches(lower_case_regex)) {
            categoriesCount++;
        }
        if (password.matches(upper_case_regex)) {
            categoriesCount++;
        }
        if (password.matches(digit_regex)) {
            categoriesCount++;
        }
        if (password.matches(special_char_regex)) {
            categoriesCount++;
        }
        return categoriesCount >= 3;
    }
}