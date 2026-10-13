package ProjectCopyOfBankServiceWithFinalTransactionsAndCentralisedCode03;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public abstract class AbstractBankService implements BankService {

    protected Scanner sc = new Scanner(System.in);
    protected Atm atm;

    protected abstract String getAccountPrefix();
    protected abstract String getBankName();

    @Override
    public void withdraw(int amount, String accountNo) {
        Customer c = findAccount(accountNo.trim());

        if (c == null) {
            System.out.println("Account not found.");
            return;
        }

        Transactions t = new Transactions();
        t.transactionId = t.hashCode() + "" + c.getAccountNo().substring(0, 4);
        t.amount = amount;
        t.transactionType = "Withdrawal";
        t.transactionDate = new Date().toString();
        t.accountNo = accountNo;
        t.name = c.getName();

        System.out.println("Withdrawal amount: " + amount);

        if (amount <= c.getBalance()) {
            c.setBalance(c.getBalance() - amount);
            System.out.println("Withdrawal successful.");
            System.out.println("Remaining balance: " + c.getBalance());

            if (accountNo.contains("BOB")) {
                if (!BankServiceImplOfBob.transactions.containsKey(accountNo)) {
                    BankServiceImplOfBob.transactions.put(accountNo, new ArrayList<>());
                }
                BankServiceImplOfBob.transactions.get(accountNo).add(t);
            } else if (accountNo.contains("PNB")) {
                if (!BankServiceImplOfPunjabNationalBank.transactions.containsKey(accountNo)) {
                    BankServiceImplOfPunjabNationalBank.transactions.put(accountNo, new ArrayList<>());
                }
                BankServiceImplOfPunjabNationalBank.transactions.get(accountNo).add(t);
            } else if (accountNo.contains("HDFC")) {
                if (!BankServiceImplOfHdfc.transactions.containsKey(accountNo)) {
                    BankServiceImplOfHdfc.transactions.put(accountNo, new ArrayList<>());
                }
                BankServiceImplOfHdfc.transactions.get(accountNo).add(t);
            } else if (accountNo.contains("SBI")) {
                if (!BankServiceImplOfSbi.transactions.containsKey(accountNo)) {
                    BankServiceImplOfSbi.transactions.put(accountNo, new ArrayList<>());
                }
                BankServiceImplOfSbi.transactions.get(accountNo).add(t);
            }
            c.setTransactions(t);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    @Override
    public void deposit(int amount, String accountNo) {
        Customer c = findAccount(accountNo.trim());

        if (c == null) {
            System.out.println("Account not found.");
            return;
        }

        Transactions t = new Transactions();
        t.transactionId = t.hashCode() + "" + c.getAccountNo().substring(0, 4);
        t.amount = amount;
        t.transactionType = "Deposite";
        t.transactionDate = new Date().toString();
        t.accountNo = accountNo;
        t.name = c.getName();

        System.out.println("Deposit amount: " + amount);

        c.setBalance(c.getBalance() + amount);

        if (accountNo.contains("BOB")) {
            if (!BankServiceImplOfBob.transactions.containsKey(accountNo)) {
                BankServiceImplOfBob.transactions.put(accountNo, new ArrayList<>());
            }
            BankServiceImplOfBob.transactions.get(accountNo).add(t);
        } else if (accountNo.contains("PNB")) {
            if (!BankServiceImplOfPunjabNationalBank.transactions.containsKey(accountNo)) {
                BankServiceImplOfPunjabNationalBank.transactions.put(accountNo, new ArrayList<>());
            }
            BankServiceImplOfPunjabNationalBank.transactions.get(accountNo).add(t);
        } else if (accountNo.contains("HDFC")) {
            if (!BankServiceImplOfHdfc.transactions.containsKey(accountNo)) {
                BankServiceImplOfHdfc.transactions.put(accountNo, new ArrayList<>());
            }
            BankServiceImplOfHdfc.transactions.get(accountNo).add(t);
        } else if (accountNo.contains("SBI")) {
            if (!BankServiceImplOfSbi.transactions.containsKey(accountNo)) {
                BankServiceImplOfSbi.transactions.put(accountNo, new ArrayList<>());
            }
            BankServiceImplOfSbi.transactions.get(accountNo).add(t);
        }
        c.setTransactions(t);

        System.out.println("Deposit successful.");
        System.out.println("Current balance: " + c.getBalance());
    }

    protected float checkBalance(String accountNo) {
        Customer c = findAccount(accountNo);
        if (c == null) {
            return 0;
        }
        return c.getBalance();
    }

    @Override
    public String openAccount(String name, String accountType, String AdharNo, int bal, String bankName) {
        Customer c1 = new Customer();
        c1.setName(name.toUpperCase());
        c1.setAdharNo(AdharNo);
        c1.setAccountType(accountType);
        c1.setBalance(bal);
        c1.setBankName(bankName);

        String hCode = c1.hashCode() + "";
        c1.setAccountNo(getAccountPrefix() + bankName + AdharNo.substring(5, 7) + hCode.substring(6, 9));

        Transactions t = new Transactions();
        t.transactionId = t.hashCode() + "" + c1.getAccountNo().substring(0, 4);
        t.amount = bal;
        t.transactionType = "Open Account";
        t.transactionDate = new Date().toString();
        t.accountNo = c1.getAccountNo();
        t.name = c1.getName();

        if (bankName.equals("BOB")) {
            if (!BankServiceImplOfBob.transactions.containsKey(c1.getAccountNo())) {
                BankServiceImplOfBob.transactions.put(c1.getAccountNo(), new ArrayList<>());
            }
            BankServiceImplOfBob.transactions.get(c1.getAccountNo()).add(t);
            BankServiceImplOfBob.customers.put(c1.getAccountNo(), c1);
        } else if (bankName.equals("PNB")) {
            if (!BankServiceImplOfPunjabNationalBank.transactions.containsKey(c1.getAccountNo())) {
                BankServiceImplOfPunjabNationalBank.transactions.put(c1.getAccountNo(), new ArrayList<>());
            }
            BankServiceImplOfPunjabNationalBank.transactions.get(c1.getAccountNo()).add(t);
            BankServiceImplOfPunjabNationalBank.customers.put(c1.getAccountNo(), c1);
        } else if (bankName.equals("HDFC")) {
            if (!BankServiceImplOfHdfc.transactions.containsKey(c1.getAccountNo())) {
                BankServiceImplOfHdfc.transactions.put(c1.getAccountNo(), new ArrayList<>());
            }
            BankServiceImplOfHdfc.transactions.get(c1.getAccountNo()).add(t);
            BankServiceImplOfHdfc.customers.put(c1.getAccountNo(), c1);
        } else if (bankName.equals("SBI")) {
            if (!BankServiceImplOfSbi.transactions.containsKey(c1.getAccountNo())) {
                BankServiceImplOfSbi.transactions.put(c1.getAccountNo(), new ArrayList<>());
            }
            BankServiceImplOfSbi.transactions.get(c1.getAccountNo()).add(t);
            BankServiceImplOfSbi.customers.put(c1.getAccountNo(), c1);
        }
        c1.setTransactions(t);

        return c1.getAccountNo();
    }

    @Override
    public Customer CloseAccount(String name, String accountNo) {
        if (accountNo.contains("BOB")) {
            return BankServiceImplOfBob.customers.remove(accountNo.trim());
        } else if (accountNo.contains("PNB")) {
            return BankServiceImplOfPunjabNationalBank.customers.remove(accountNo.trim());
        } else if (accountNo.contains("HDFC")) {
            return BankServiceImplOfHdfc.customers.remove(accountNo.trim());
        } else if (accountNo.contains("SBI")) {
            return BankServiceImplOfSbi.customers.remove(accountNo.trim());
        }
        return null;
    }

    @Override
    public String UpiTransaction(float amount, String upiId, String acountno) {
        Customer c = findAccount(acountno.trim());

        if (c == null) {
            return "Account not found.";
        }

        Transactions t = new Transactions();
        t.transactionId = t.hashCode() + "" + c.getAccountNo().substring(0, 4);
        t.amount = amount;
        t.transactionType = "Upi Transaction";
        t.transactionDate = new Date().toString();
        t.accountNo = acountno;
        t.name = c.getName();

        if (amount <= c.getBalance()) {
            c.setBalance(c.getBalance() - amount);

            if (acountno.contains("BOB")) {
                if (!BankServiceImplOfBob.transactions.containsKey(acountno)) {
                    BankServiceImplOfBob.transactions.put(acountno, new ArrayList<>());
                }
                BankServiceImplOfBob.transactions.get(acountno).add(t);
            } else if (acountno.contains("PNB")) {
                if (!BankServiceImplOfPunjabNationalBank.transactions.containsKey(acountno)) {
                    BankServiceImplOfPunjabNationalBank.transactions.put(acountno, new ArrayList<>());
                }
                BankServiceImplOfPunjabNationalBank.transactions.get(acountno).add(t);
            } else if (acountno.contains("HDFC")) {
                if (!BankServiceImplOfHdfc.transactions.containsKey(acountno)) {
                    BankServiceImplOfHdfc.transactions.put(acountno, new ArrayList<>());
                }
                BankServiceImplOfHdfc.transactions.get(acountno).add(t);
            } else if (acountno.contains("SBI")) {
                if (!BankServiceImplOfSbi.transactions.containsKey(acountno)) {
                    BankServiceImplOfSbi.transactions.put(acountno, new ArrayList<>());
                }
                BankServiceImplOfSbi.transactions.get(acountno).add(t);
            }
            c.setTransactions(t);

            return "Transaction successful.";
        } else {
            return "Insufficient balance.";
        }
    }

    @Override
    public String loan(String AdharNo, float amount, int time, float rate, String accountNo) {
        Customer c = findAccount(accountNo.trim());

        if (c == null) {
            return "Loan failed.";
        }

        float si = amount * time * rate / 100;
        float totalAmount = amount + si;

        c.setBalance(c.getBalance() + totalAmount);

        return "Loan successful With SI " + si + " totalAmount is " + totalAmount;
    }

    @Override
    public String insurance(String AdharNo, String accountNo, float amount, int time, float intrest, float rate, String insuranceType, String insuranceId, String insuranceName, String insuranceNo, String insuranceStartDate, String insuranceEndDate) {
        Customer c1 = findAccount(accountNo.trim());

        if (c1 == null) {
            return "Insurance failed.";
        }

        float si = amount * time * intrest / 100;
        float totalAmount = amount + si;

        c1.setBalance(c1.getBalance() + totalAmount);

        return "Insurance successful.";
    }

    @Override
    public String creditCard(String accountNo, String cardNo, String cardHolderName, String cardType, String cardStartDate, String cardEndDate, String cardCvv, String cardPin, String cardStatus) {
        Customer c1 = findAccount(accountNo.trim());

        if (c1 != null) {
            c1.setUpiId(cardNo);
            return "Credit card successful.";
        } else {
            return "Credit Card Not Approved";
        }
    }

    @Override
    public Customer findAccount(String accountId) {
        if (accountId.contains("BOB")) {
            return BankServiceImplOfBob.customers.get(accountId.trim());
        } else if (accountId.contains("PNB")) {
            return BankServiceImplOfPunjabNationalBank.customers.get(accountId.trim());
        } else if (accountId.contains("HDFC")) {
            return BankServiceImplOfHdfc.customers.get(accountId.trim());
        } else if (accountId.contains("SBI")) {
            return BankServiceImplOfSbi.customers.get(accountId.trim());
        }
        return null;
    }

    @Override
    public void showTransactions(String accountNo) {
        Customer c = null;
        ArrayList<Transactions> res = null;

        if (accountNo.contains("BOB")) {
            c = BankServiceImplOfBob.customers.get(accountNo.trim());
            res = BankServiceImplOfBob.transactions.get(accountNo.trim());
        } else if (accountNo.contains("PNB")) {
            c = BankServiceImplOfPunjabNationalBank.customers.get(accountNo.trim());
            res = BankServiceImplOfPunjabNationalBank.transactions.get(accountNo.trim());
        } else if (accountNo.contains("HDFC")) {
            c = BankServiceImplOfHdfc.customers.get(accountNo.trim());
            res = BankServiceImplOfHdfc.transactions.get(accountNo.trim());
        } else if (accountNo.contains("SBI")) {
            c = BankServiceImplOfSbi.customers.get(accountNo.trim());
            res = BankServiceImplOfSbi.transactions.get(accountNo.trim());
        }

        if (c == null || res == null) {
            System.out.println("Account not found.");
            return;
        } else {
            for (Transactions t : res) {
                System.out.println(t);
                System.out.println("\n");
            }
        }

        System.out.println("\n\n");
    }

    @Override
    public void TransferAmount(String senderAccountNo, String recAccoutnNo, float amount) {
        Customer sender = null;
        Customer reciver = null;

        if (senderAccountNo.contains("BOB")) {
            sender = BankServiceImplOfBob.customers.get(senderAccountNo.trim());
        } else if (senderAccountNo.contains("PNB")) {
            sender = BankServiceImplOfPunjabNationalBank.customers.get(senderAccountNo.trim());
        } else if (senderAccountNo.contains("HDFC")) {
            sender = BankServiceImplOfHdfc.customers.get(senderAccountNo.trim());
        } else if (senderAccountNo.contains("SBI")) {
            sender = BankServiceImplOfSbi.customers.get(senderAccountNo.trim());
        }

        if (recAccoutnNo.contains("BOB")) {
            reciver = BankServiceImplOfBob.customers.get(recAccoutnNo.trim());
        } else if (recAccoutnNo.contains("PNB")) {
            reciver = BankServiceImplOfPunjabNationalBank.customers.get(recAccoutnNo.trim());
        } else if (recAccoutnNo.contains("HDFC")) {
            reciver = BankServiceImplOfHdfc.customers.get(recAccoutnNo.trim());
        } else if (recAccoutnNo.contains("SBI")) {
            reciver = BankServiceImplOfSbi.customers.get(recAccoutnNo.trim());
        }

        if (reciver == null) {
            System.out.println("Reciver Account not found.");
            return;
        }

        if (sender == null) {
            System.out.println("Sender Account not found.");
            return;
        }

        if (sender.getBalance() < 0) {
            System.out.println("Sender Account has no balance.");
            return;
        }

        if (sender.getBalance() < amount) {
            System.out.println("Sender Account has less balance.");
            return;
        }

        System.out.println("Transfer amount is " + amount);
        System.out.println("\n=========================== Transfer Confirmation ============================");
        System.out.println("Sender: " + sender.getName() + " (" + senderAccountNo + ")");
        System.out.println("Receiver: " + reciver.getName() + " (" + recAccoutnNo + ")");
        System.out.println("Amount: Rs" + amount);
        System.out.print("Confirm transfer? (Y/N): ");
        sc.nextLine();
        String confirm = sc.nextLine();

        if (!confirm.equalsIgnoreCase("Y")) {
            System.out.println("Transfer cancelled......");
            return;
        }

        Transactions t = new Transactions();
        t.transactionId = t.hashCode() + "" + reciver.getAccountNo().substring(0, 4);
        t.amount = amount;
        t.transactionType = "Transfer Amount";
        t.transactionDate = new Date().toString();
        t.accountNo = "Sender Bank Name: " + sender.getBankName() +
                " | Sender Account No: " + senderAccountNo +
                "\nReceiver Bank Name: " + reciver.getBankName() +
                " | Receiver Account No: " + recAccoutnNo;
        t.name = "Sender  Name is " + sender.getName() + " Receiver Name is " + reciver.getName();

        sender.setBalance(sender.getBalance() - amount);
        reciver.setBalance(reciver.getBalance() + amount);

        if (reciver.getBankName() == "BOB") {
            if (!BankServiceImplOfBob.transactions.containsKey(recAccoutnNo)) {
                BankServiceImplOfBob.transactions.put(recAccoutnNo, new ArrayList<>());
            }
            BankServiceImplOfBob.transactions.get(recAccoutnNo).add(t);
            reciver.setTransactions(t);
        } else if (reciver.getBankName() == "PNB") {
            if (!BankServiceImplOfPunjabNationalBank.transactions.containsKey(recAccoutnNo)) {
                BankServiceImplOfPunjabNationalBank.transactions.put(recAccoutnNo, new ArrayList<>());
            }
            BankServiceImplOfPunjabNationalBank.transactions.get(recAccoutnNo).add(t);
            reciver.setTransactions(t);
        } else if (reciver.getBankName() == "HDFC") {
            if (!BankServiceImplOfHdfc.transactions.containsKey(recAccoutnNo)) {
                BankServiceImplOfHdfc.transactions.put(recAccoutnNo, new ArrayList<>());
            }
            BankServiceImplOfHdfc.transactions.get(recAccoutnNo).add(t);
            reciver.setTransactions(t);
        } else if (reciver.getBankName() == "SBI") {
            if (!BankServiceImplOfSbi.transactions.containsKey(recAccoutnNo)) {
                BankServiceImplOfSbi.transactions.put(recAccoutnNo, new ArrayList<>());
            }
            BankServiceImplOfSbi.transactions.get(recAccoutnNo).add(t);
            reciver.setTransactions(t);
        }

        if (sender.getBankName() == "BOB") {
            if (!BankServiceImplOfBob.transactions.containsKey(senderAccountNo)) {
                BankServiceImplOfBob.transactions.put(senderAccountNo, new ArrayList<>());
            }
            BankServiceImplOfBob.transactions.get(senderAccountNo).add(t);
            sender.setTransactions(t);
        } else if (sender.getBankName() == "PNB") {
            if (!BankServiceImplOfPunjabNationalBank.transactions.containsKey(senderAccountNo)) {
                BankServiceImplOfPunjabNationalBank.transactions.put(senderAccountNo, new ArrayList<>());
            }
            BankServiceImplOfPunjabNationalBank.transactions.get(senderAccountNo).add(t);
            sender.setTransactions(t);
        } else if (sender.getBankName() == "HDFC") {
            if (!BankServiceImplOfHdfc.transactions.containsKey(senderAccountNo)) {
                BankServiceImplOfHdfc.transactions.put(senderAccountNo, new ArrayList<>());
            }
            BankServiceImplOfHdfc.transactions.get(senderAccountNo).add(t);
            sender.setTransactions(t);
        } else if (sender.getBankName() == "SBI") {
            if (!BankServiceImplOfSbi.transactions.containsKey(senderAccountNo)) {
                BankServiceImplOfSbi.transactions.put(senderAccountNo, new ArrayList<>());
            }
            BankServiceImplOfSbi.transactions.get(senderAccountNo).add(t);
            sender.setTransactions(t);
        }

        System.out.println(t);
    }
}
