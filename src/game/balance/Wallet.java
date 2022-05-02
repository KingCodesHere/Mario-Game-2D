package game.balance;
/**
 * Wallet of the actor
 * @author Junhao Li
 * @version 1.0.0
 */
public class Wallet {
    private int balance = 0;

    /**
     * init balance is zero
     */
    public Wallet(){}

    /**
     * constructor for wallet
     * @param balance   value
     */
    public Wallet(int balance){
        this.balance = balance;
    }

    /**
     * increasing the deposit
     * @param value balance
     */
    public void depositBalance(int value){
        this.balance += value;
    }

    /**
     * decreasing the deposit
     * @param value price
     */
    public void withdrawBalance(int value){
        this.balance -= value;
    }

    /**
     * Check the balance
     * @return balance
     */
    public int getBalance(){
        return this.balance;
    }

}
