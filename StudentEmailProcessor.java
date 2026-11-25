import java.util.Scanner;

public class StudentEmailProcessor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student email address: ");
        String rawEmail = scanner.nextLine();

        String trimmedEmail = rawEmail.trim();
        System.out.println("\n9. Trimmed Email: '" + trimmedEmail + "'");

        System.out.println("1. Length of Email: " + trimmedEmail.length());

        String lowerEmail = trimmedEmail.toLowerCase();
        System.out.println("4. Lowercase Email: " + lowerEmail);

        int atIndex = lowerEmail.indexOf('@');
        if (atIndex > 0 && atIndex < lowerEmail.length() - 1) {
            String username = lowerEmail.substring(0, atIndex);
            System.out.println("2. Username: " + username);

            String domain = lowerEmail.substring(atIndex + 1);
            System.out.println("3. Domain Name: " + domain);
            if (domain.equals("bmsce.ac.in")) {
                System.out.println("   -> Verification: Valid BMSCE institutional email.");
            } else {
                System.out.println("   -> Verification: Not a BMSCE institutional email.");
            }
        } else {
            System.out.println("2 & 3. Invalid email format (missing or misplaced '@' symbol).");
        }

        System.out.print("\nEnter prefix to check (e.g., registration number like 1bm23): ");
        String prefix = scanner.nextLine().toLowerCase();
        if (lowerEmail.startsWith(prefix)) {
            System.out.println("5. Prefix Check: The email starts with '" + prefix + "'.");
        } else {
            System.out.println("5. Prefix Check: The email does NOT start with '" + prefix + "'.");
        }

        boolean endsWithValidDomain = lowerEmail.endsWith("bmsce.ac.in");
        System.out.println("6. Ends with 'bmsce.ac.in': " + endsWithValidDomain);

        String updatedEmail = lowerEmail.replace("bmsce.ac.in", "cse.bmsce.ac.in");
        System.out.println("7. Updated Email (Domain Replaced): " + updatedEmail);

        System.out.print("\nEnter character or sequence to search (e.g., cse or 2025): ");
        String sequence = scanner.nextLine().toLowerCase();
        if (lowerEmail.contains(sequence)) {
            System.out.println("8. Contains Check: The email contains '" + sequence + "'.");
        } else {
            System.out.println("8. Contains Check: The email does NOT contain '" + sequence + "'.");
        }

        System.out.print("\nEnter a second email address to compare: ");
        String secondEmail = scanner.nextLine().trim();
        if (trimmedEmail.equalsIgnoreCase(secondEmail)) {
            System.out.println("10. Comparison Result: Both email addresses are identical (ignoring case).");
        } else {
            System.out.println("10. Comparison Result: The email addresses are different.");
        }

        scanner.close();
    }
}
