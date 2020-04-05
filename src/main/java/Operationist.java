import java.util.ArrayList;
import java.util.List;

public class Operationist extends Thread{

    private final List<Client> clients = new ArrayList<Client>();

    public List<Client> getClients() {
        return clients;
    }

    private Cash cash;
    private String operatorName;
    private Integer countOfClients = 0;

    public String getOperatorName() {
        return operatorName;
    }

    public Operationist(Cash cash, String operatorName) {
        this.cash = cash;
        this.operatorName = operatorName;
    }
    public void addClients(Client client) {
        synchronized (clients) {
            clients.add(client);
            countOfClients = countOfClients + 1;
            clients.notify();
        }
    }

    public Integer getCountOfClients() {
        return countOfClients;
    }

    @Override
    public void run() {
        while (true) {
            if (clients.isEmpty()) {
                synchronized (clients) {
                    try {
                        clients.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                Client currentClient = clients.remove(0);
                countOfClients = countOfClients - 1;
                synchronized (cash) {
                    if (!currentClient.getPutMoney()) {
                        if (currentClient.getMoney() > cash.getMoney()) {
                            this.clients.add(currentClient);
                        } else {
                            System.out.println("Клиент " + currentClient.getName() + " снял деньги у оператора " + operatorName + currentClient.getMoney());
                            cash.withdrawMoney(currentClient.getMoney());
                            try {
                                Thread.sleep(currentClient.getTime());

                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
                if (currentClient.getPutMoney()) {
                    System.out.println("Клиент " + currentClient.getName() + " положил деньги в банк у операционистки " + operatorName + " на сумму " + currentClient.getMoney());
                    cash.putMoney(currentClient.getMoney());
                    try {
                        Thread.sleep(currentClient.getTime());

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
