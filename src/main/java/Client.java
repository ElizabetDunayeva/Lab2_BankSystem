public class Client {
    /**
     * имя клиента
     */
    String name;
    /**
     * цель,true - положить деньги false- снять
     */
    Boolean putMoney;
    /**
     * сумма
     */
    int money;

    private Integer time;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getPutMoney() {
        return putMoney;
    }

    public void setPutMoney(Boolean putMoney) {
        this.putMoney = putMoney;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }



    public Client(boolean isWithdrawMoney, int money, int time, String clientName) {
        this.putMoney = isWithdrawMoney;
        this.money = money;
        this.time = time;
        this.name = clientName;}
}
