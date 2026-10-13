package ProjectCopyOfBankServiceWithFinalTransactionsAndCentralisedCode03;

import java.util.ArrayList;
import java.util.HashMap;

public class BankServiceImplOfSbi extends AbstractBankService {

    static HashMap<String, Customer> customers = new HashMap<>();
    static HashMap<String, ArrayList<Transactions>> transactions = new HashMap<>();

    private static String accountPref = "20870100061";

    @Override
    public void visitBank() {
        System.out.println("========== Welcome to Bank 🏦 Of Sbi ==========");
        BankMenu();
    }

    @Override
    public void BankMenu() {
        System.out.println();
        System.out.println("========== Sbi BANK MENU ==========");
        System.out.println("1. Withdraw 💵");
        System.out.println("2. Deposit 💵");
        System.out.println("3. Open Account");
        System.out.println("4. Close Account");
        System.out.println("5. UPI Transaction");
        System.out.println("6. Loan 💵");
        System.out.println("7. Insurance");
        System.out.println("8. Credit Card");
        System.out.println("9. Find Account");
        System.out.println("10. Use Atm Service of SBI");
        System.out.println("11. Check Balance");
        System.out.println("12. Transactions");
        System.out.println("13. Transfer Amount");
        System.out.println("14. Exit");
        System.out.println("====================================");
        System.out.print("Enter your choice: ");

        String choiceInput = sc.nextLine();

        while (choiceInput.trim().isEmpty()) {
            System.out.print("Please enter a valid choice: ");
            choiceInput = sc.nextLine();
        }

        int choice = Integer.parseInt(choiceInput);

        switch (choice) {

            case 1:

                System.out.print("Enter amount to withdraw 💵: ");
                int withdrawAmount = Integer.parseInt(sc.nextLine());

                System.out.print("Enter account number: ");
                String withdrawAccountNo = sc.nextLine();

                withdraw(withdrawAmount, withdrawAccountNo);
                BankMenu();
                break;

            case 2:

                System.out.print("Enter amount 💵 to deposit: ");
                int depositAmount = Integer.parseInt(sc.nextLine());

                System.out.print("Enter account number: ");
                String depositAccountNo = sc.nextLine();

                deposit(depositAmount, depositAccountNo);
                BankMenu();
                break;

            case 3:

                System.out.print("Enter customer name: ");
                String name = sc.nextLine();

//                System.out.println("Select Bank:");
//                System.out.println("1. BOB");
//                System.out.println("2. PNB");
//                System.out.println("3. HDFC");
//                System.out.println("4. SBI");
//
//                int choice3 = Integer.parseInt(sc.nextLine());

                String bankName = "SBI";

//                if (choice3 == 1) {
//                    bankName = "BOB";
//                } else if (choice3 == 2) {
//                    bankName = "PNB";
//                } else if (choice3 == 3) {
//                    bankName = "HDFC";
//                } else if (choice3 == 4) {
//                    bankName = "SBI";
//                } else {
//                    System.out.println("Invalid bank choice.");
//                    break;
//                }

                System.out.println("Enter Account Type:");
                System.out.println("1. Saving");
                System.out.println("2. Current");

                int choice2 = Integer.parseInt(sc.nextLine());

                String accountType;

                if (choice2 == 1) {
                    accountType = "saving";
                } else if (choice2 == 2) {
                    accountType = "current";
                } else {
                    System.out.println("Invalid account type.");
                    break;
                }

                System.out.print("Enter Aadhar number: ");
                String aadharNo = sc.nextLine();

                if (aadharNo.length() != 12) {
                    System.out.println("Invalid Aadhar number.");
                    break;
                }

                System.out.print("Enter initial balance: ");
                int balance = Integer.parseInt(sc.nextLine());

                String accountNo = openAccount(name, accountType, aadharNo, balance, bankName);

                System.out.println("Account created successfully.");
                System.out.println("Account Number: " + accountNo);

                BankMenu();
                break;

            case 4:

                System.out.print("Enter customer name: ");
                String closeName = sc.nextLine();

                System.out.print("Enter account number: ");
                String closeAccountNo = sc.nextLine();

                Customer customer = CloseAccount(closeName, closeAccountNo);

                if (customer != null) {
                    System.out.println("Account closed successfully. " + customer.getAccountNo());
                } else {
                    System.out.println("Account not found.");
                }

                BankMenu();
                break;

            case 5:

                System.out.print("Enter UPI amount 💵: ");
                float upiAmount = Float.parseFloat(sc.nextLine());

                System.out.print("Enter UPI ID: ");
                String upiId = sc.nextLine();

                System.out.print("Enter account number: ");
                String acNo = sc.nextLine();

                String upiResult = UpiTransaction(upiAmount, upiId, acNo);

                System.out.println(upiResult);

                BankMenu();
                break;

            case 6:

                System.out.print("Enter loan amount: ");
                float loanAmount = Float.parseFloat(sc.nextLine());

                System.out.print("Enter time (years): ");
                int loanTime = Integer.parseInt(sc.nextLine());

                System.out.print("Enter rate: ");
                float loanRate = Float.parseFloat(sc.nextLine());

                System.out.print("Enter Aadhar number: ");
                String loanAadhar = sc.nextLine();

                if (loanAadhar.length() != 12) {
                    System.out.println("Invalid Aadhar number.");
                    BankMenu();
                    break;
                }

                System.out.print("Enter account number: ");
                String loanAccountNo = sc.nextLine();

                String loanResult = loan(loanAadhar, loanAmount, loanTime, loanRate, loanAccountNo);

                System.out.println(loanResult);

                BankMenu();
                break;

            case 7:

                System.out.print("Enter Aadhar number: ");
                String insuranceAadhar = sc.nextLine();

                System.out.print("Enter account number: ");
                String insuranceAccountNo = sc.nextLine();

                System.out.print("Enter insurance amount: ");
                float insuranceAmount = Float.parseFloat(sc.nextLine());

                System.out.print("Enter time: ");
                int insuranceTime = Integer.parseInt(sc.nextLine());

                System.out.print("Enter interest: ");
                float insuranceInterest = Float.parseFloat(sc.nextLine());

                System.out.print("Enter rate: ");
                float insuranceRate = Float.parseFloat(sc.nextLine());

                System.out.print("Enter insurance type: ");
                String insuranceType = sc.nextLine();

                System.out.print("Enter insurance ID: ");
                String insuranceId = sc.nextLine();

                System.out.print("Enter insurance name: ");
                String insuranceName = sc.nextLine();

                System.out.print("Enter insurance number: ");
                String insuranceNo = sc.nextLine();

                System.out.print("Enter start date: ");
                String startDate = sc.nextLine();

                System.out.print("Enter end date: ");
                String endDate = sc.nextLine();

                String insuranceResult = insurance(insuranceAadhar, insuranceAccountNo, insuranceAmount, insuranceTime, insuranceInterest, insuranceRate, insuranceType, insuranceId, insuranceName, insuranceNo, startDate, endDate);

                System.out.println(insuranceResult);

                BankMenu();
                break;

            case 8:

                System.out.print("Enter account number: ");
                String cardAccountNo = sc.nextLine();

                System.out.print("Enter card number: ");
                String cardNo = sc.nextLine();

                System.out.print("Enter card holder name: ");
                String cardHolderName = sc.nextLine();

                System.out.print("Enter card type: ");
                String cardType = sc.nextLine();

                System.out.print("Enter card start date: ");
                String cardStartDate = sc.nextLine();

                System.out.print("Enter card end date: ");
                String cardEndDate = sc.nextLine();

                System.out.print("Enter CVV: ");
                String cardCvv = sc.nextLine();

                System.out.print("Enter card PIN: ");
                String cardPin = sc.nextLine();

                System.out.print("Enter card status: ");
                String cardStatus = sc.nextLine();

                String cardResult = creditCard(cardAccountNo, cardNo, cardHolderName, cardType, cardStartDate, cardEndDate, cardCvv, cardPin, cardStatus);

                System.out.println(cardResult);

                BankMenu();
                break;

            case 9:

                System.out.print("Enter account ID: ");
                String accountId = sc.nextLine();

                Customer foundCustomer = findAccount(accountId);

                if (foundCustomer != null) {
                    System.out.println("Account Found:");
//                    System.out.println(foundCustomer.getName());
                    System.out.println(foundCustomer);
                    BankMenu();
                } else {
                    System.out.println("Account not found.");
                    BankMenu();
                }

                break;

            case 10:

                System.out.print("Enter account number:- ");
                String accountNo2 = sc.nextLine();

                Customer c = findAccount(accountNo2);

                if (c == null) {
                    System.out.println("Account not found.");
                    BankMenu();
                    break;
                }

                atm = new Atm(c);
                atm.checkPin();
                atm.menu();

                break;

            case 11:

                System.out.print("Enter account number:- ");
                String accountNo3 = sc.nextLine();

                Customer c3 = findAccount(accountNo3);

                if (c3 == null) {
                    System.out.println("Account not found.");
                    BankMenu();
                    break;
                }

                System.out.println("Your Net Balance is " + checkBalance(accountNo3));
                BankMenu();
                break;

            case 12:
                System.out.print("\n========== TRANSACTION HISTORY ==========\n");
                System.out.print("Enter Your Account No: ");
                String accountNo4 = sc.next();
                showTransactions(accountNo4);
                BankMenu();
                break;

            case 13:
                System.out.println("\n================= TRANSFER AMOUNT =================\n");
                System.out.print("Enter the Sender Account No:- ");
                String senderAccountNo = sc.next();

                System.out.print("Enter reciver Account  No:- ");
                String reciverAccountNo = sc.next();

                System.out.print("Enter The Amount To be Transfered:- ");
                float amount = sc.nextFloat();

                TransferAmount(senderAccountNo,reciverAccountNo,amount);
                BankMenu();
                break;

            case 14:

                System.out.println("============= Thank you for visiting Sbi Bank.==================");
                return;

            default:

                System.out.println("Invalid choice. Please enter 1-12.");
                BankMenu();
        }
    }


    @Override
    protected String getAccountPrefix() {
        return accountPref;
    }

    @Override
    protected String getBankName() {
        return "SBI";
    }
}