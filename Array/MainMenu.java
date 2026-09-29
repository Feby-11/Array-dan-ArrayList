import java.util.Scanner;

public class MainMenu {

    static Bank bank = new Bank();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        isiDataAwal();

        int pilihan;
        do {
            tampilkanMenu();
            pilihan = sc.nextInt();
            sc.nextLine();

            switch (pilihan) {
                case 1: tambahNasabah(); break;
                case 2: daftarNasabah(); break;
                case 3: cekSaldo();      break;
                case 4: setorTunai();    break;
                case 5: tarikTunai();    break;
                case 0: System.out.println("Terima kasih."); break;
                default: System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 0);

        sc.close();
    }

    static void isiDataAwal() {
        bank.addCustomer("Febylia");
        bank.getCustomer(0).setAccount(new Account(500000));
    }

    static void tampilkanMenu() {
        System.out.println("\n=== MENU ATM ===");
        System.out.println("1. Tambah nasabah");
        System.out.println("2. Daftar nasabah");
        System.out.println("3. Cek saldo");
        System.out.println("4. Setor tunai");
        System.out.println("5. Tarik tunai");
        System.out.println("0. Keluar");
        System.out.print("Pilih: ");
    }

    static void tambahNasabah() {
        System.out.print("Nama    : ");
        String depan = sc.nextLine();
        System.out.print("Saldo awal    : ");
        double saldoAwal = sc.nextDouble();
        sc.nextLine();

        bank.addCustomer(depan);
        Customer baru = bank.getCustomer(bank.getNumOfCustomers() - 1);
        baru.setAccount(new Account(saldoAwal));
        System.out.println("Nasabah ditambahkan.");
    }

    static void daftarNasabah() {
        for (int i = 0; i < bank.getNumOfCustomers(); i++) {
            Customer c = bank.getCustomer(i);
            System.out.println(i + ". " + c.getName() + " " );
        }
    }

    static Customer pilihNasabah() {
        System.out.print("Index nasabah: ");
        Customer c = bank.getCustomer(sc.nextInt());
        if (c == null) {
            System.out.println("Nasabah tidak ditemukan.");
        }
        return c;
    }

    static void cekSaldo() {
        Customer c = pilihNasabah();
        if (c != null) {
            System.out.println("Saldo " + c.getName() + ": " + c.getAccount().getBalance());
        }
    }

    static void setorTunai() {
        Customer c = pilihNasabah();
        if (c != null) {
            System.out.print("Jumlah: ");
            boolean ok = c.getAccount().deposit(sc.nextDouble());
            tampilkanHasil(ok, c.getAccount());
        }
    }

    static void tarikTunai() {
        Customer c = pilihNasabah();
        if (c != null) {
            System.out.print("Jumlah: ");
            boolean ok = c.getAccount().withdraw(sc.nextDouble());
            tampilkanHasil(ok, c.getAccount());
        }
    }

    static void tampilkanHasil(boolean ok, Account a) {
        if (ok) {
            System.out.println("Transaksi berhasil. Saldo: " + a.getBalance());
        } else {
            System.out.println("Transaksi gagal (jumlah tidak valid / saldo kurang).");
        }
    }
}