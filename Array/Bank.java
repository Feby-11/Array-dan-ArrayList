public class Bank {
    private Customer[] customers;
    private int numberOfCustomers;

    public Bank() {
        customers = new Customer[10];
        numberOfCustomers = 0;
    }

    public void addCustomer(String n) {
        if (numberOfCustomers < customers.length) {
            customers[numberOfCustomers] = new Customer(n);
            numberOfCustomers++;
        } else {
            System.out.println("Kapasitas nasabah penuh.");
        }
    }

    public int getNumOfCustomers() {
        return numberOfCustomers;
    }

    public Customer getCustomer(int index) {
        if (index >= 0 && index < numberOfCustomers) {
            return customers[index];
        }
        return null;
    }
}