public class BankAccountTest {
    public static void main(String[] args) {
        BankAccount one = new BankAccount();
        System.out.println(one.getAccountNumber());
        one.deposit('c', 100);
        one.deposit('s', 200);
        System.out.println(one.getCheckingBalance());
        System.out.println(one.getSavingsBalance());
        one.withdraw(50);
        System.out.println(one.getCheckingBalance());
        System.out.println(one.showTotal());
    }
}