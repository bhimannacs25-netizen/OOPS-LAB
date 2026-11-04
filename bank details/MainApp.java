import transaction.Account;
import reports.TransactionReport;

public class MainApp {
    public static void main(String[] args) {

        Account myAccount = new Account("SBI100098745", 5000.00);
        TransactionReport reporter = new TransactionReport();


        System.out.println("--- Initial State ---");
        reporter.generateReport(myAccount);


        System.out.println("\n--- Processing Deposit ---");
        myAccount.deposit(1500.50);
        reporter.generateReport(myAccount);


        System.out.println("\n--- Processing Withdrawal ---");
        myAccount.withdraw(2000.00);
        reporter.generateReport(myAccount);


        System.out.println("\n--- Processing Invalid Withdrawal ---");
        myAccount.withdraw(6000.00); 
    }
}
