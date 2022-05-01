package game.balance;

public class Wallet {
    private int balance = 0;

    /***
     * init balance is zero
     */
    public Wallet(){}

    /***
     * it can set balance
     * @param balance
     */

    public Wallet(int balance){
        this.balance = balance;
    }

    public void depositBalance(int value){
        this.balance += value;
    }

    public void withdrawBalance(int value){
        this.balance -= value;
    }

    public int getBalance(){
        return this.balance;
    }

}
