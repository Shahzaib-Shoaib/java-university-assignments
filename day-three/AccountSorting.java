// Declare an array of size `n` to store account balances. Initialize with values 0 to 100000 and sort account numbers according to the highest balance values using quick sort. For example:
// Account No. 3547 Balance 28000
// Account No. 1245 Balance 12000

import java.util.Random;

public class AccountSorting {

    public static void main(String[] args) {
        int n = 10;
        Account[] accounts = new Account[n];

        initializeAccounts(accounts);

        System.out.println("Accounts before sorting:");
        printAccounts(accounts);

        quickSort(accounts, 0, accounts.length - 1);

        System.out.println("\nAccounts after sorting:");
        printAccounts(accounts);
    }

    public static void initializeAccounts(Account[] accounts) {
        Random random = new Random();
        for (int i = 0; i < accounts.length; i++) {
            int accountNumber = 1000 + i; // Simple account numbers for example
            int balance = random.nextInt(100001); // Random balance between 0 and 100000
            accounts[i] = new Account(accountNumber, balance);
        }
    }

    public static void printAccounts(Account[] accounts) {
        for (Account account : accounts) {
            System.out.println("Account No. " + account.getAccountNumber() + " Balance " + account.getBalance());
        }
    }

    public static void quickSort(Account[] accounts, int low, int high) {
        if (low < high) {
            int pi = partition(accounts, low, high);
            quickSort(accounts, low, pi - 1);
            quickSort(accounts, pi + 1, high);
        }
    }

    public static int partition(Account[] accounts, int low, int high) {
        Account pivot = accounts[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (accounts[j].getBalance() > pivot.getBalance()) { // Sort in descending order
                i++;
                Account temp = accounts[i];
                accounts[i] = accounts[j];
                accounts[j] = temp;
            }
        }
        Account temp = accounts[i + 1];
        accounts[i + 1] = accounts[high];
        accounts[high] = temp;
        return i + 1;
    }
}

class Account {
    private int accountNumber;
    private int balance;

    public Account(int accountNumber, int balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public int getBalance() {
        return balance;
    }
}
