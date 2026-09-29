public class Customer {
    private String Name;
    private Account account;

    public Customer(String n) {
        Name = n;
    }

    public String getName() {
        return Name;
    }

    public void setAccount(Account acct) {
        account = acct;
    }

    public Account getAccount() {
        return account;
    }
}