public class BankAccount {
    private  double  balance;
    
    public BankAccount(double initialBalance){
        this.balance = initialBalance;
    }
    public double getBalance(){
        return balance;
    }
    public void deposit(double amount){
        if(amount > 0){
            balance += amount;
            System.out.println("Successfully deposited: $"+amount);
        } else{
            System.out.println("Deposit amount must be positive.");
        }
    }
    public void withdraw(double amount){
        if(amount >0 && amount < balance){
            balance -= amount;
            System.out.println("Successfully withdrawn: $"+amount);
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");            
        }
        else{
            System.out.println("Withdrawal amount must be positive.");
        }
    }

    
}
