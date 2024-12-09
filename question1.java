abstract class bankAccont{
    String name;
    double balance;
    String address;
    String accountNumber;


    bankAccont(String name,double balance,String address, String accountNumber){
        this.name = name;
        this.balance = balance;
        this.address = address;
        this.accountNumber = accountNumber;
    }

    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);

    public void display(){
        System.out.println("Account Name: " + this.name);
        System.out.println("Account Number: "+this.accountNumber);
        System.out.println("Address: "+ this.address);
        System.out.println("Balance: " + this.balance);
    }
}

class SavingsAccount extends bankAccont{
    double returnOnInvestment;
    SavingsAccount(String name,double balance,String address, String accountNumber,double returnOnInvestment){
        super(name, balance,address,accountNumber);
        this.returnOnInvestment = returnOnInvestment;
    }

    public void deposit(double amount){
        if (amount <= 0){
            System.out.println("Amount must be positive");
        }else{
            this.balance += amount;
            System.out.println("Amount added successfully.\nBalance : " + this.balance);
        }

        
    }

    @Override

    public void withdraw(double amount){
        if(amount >= 0){
            this.balance -= amount;
            System.out.println("Successfully amount debited.\nBalance: "+this.balance);
        }
        else{
            System.out.println("insufficient balance.");
        }
    }

    public void calcAmount(){
        double amountAfter1Year = this.balance + (this.balance * returnOnInvestment / 100);
        System.out.println("Amount in account after 1 year with " + returnOnInvestment + " % ROI: $: " + amountAfter1Year);
    }
    
}
// package java_sem;

public class question1 {
    public static void main(String[] args) {
        SavingsAccount person1 = new SavingsAccount("Jayavel", 10000, "Vadambacheri", "103901000024988", 45);
        person1.deposit(3000);
        person1.display();
        person1.calcAmount();
    }
    
}