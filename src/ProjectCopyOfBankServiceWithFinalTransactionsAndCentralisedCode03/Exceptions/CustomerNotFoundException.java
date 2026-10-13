package ProjectCopyOfBankServiceWithFinalTransactionsAndCentralisedCode03.Exceptions;

public class CustomerNotFoundException extends Exception{

    String  massege;
    CustomerNotFoundException(String massege,String accountno){
        this.massege = massege;
        massege+=" "+accountno;
    }

    public String getMassege() {
        return massege;
    }

}
