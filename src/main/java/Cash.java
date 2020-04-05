public class Cash {

    private int money;

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public synchronized void putMoney(int value){
        money = money + value;
        System.out.println("Счет банка: " + money);
    }

    public synchronized void  withdrawMoney(int value){
        money = money - value;
        System.out.println("Счет банка: " + money);

    }




}
