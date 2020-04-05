import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args){


        Cash cash = new Cash();
        cash.setMoney(0);

        List<Operationist> operationistList = new ArrayList<Operationist>();
        Operationist op1 = new Operationist(cash, "first Operator");
        Operationist op2 = new Operationist(cash, "second Operator");
        Operationist op3 = new Operationist(cash, "third Operator");
        Operationist op4 = new Operationist(cash, "fourth Operator");
        operationistList.add(op1);
        operationistList.add(op2);
        operationistList.add(op3);
        operationistList.add(op4);

        for (Operationist operationist : operationistList) {
            operationist.start();
        }
        boolean flag;
        for (int i = 0; i < 10; i++) {
            flag = i % 2 != 0;
            Operationist operationist =  operationistList.get(0);
            operationist.addClients(new Client(flag, ((int) (Math.random() * 250) ), ((int) (Math.random() * 5000) ), ("Client№ " + (i+1))));

            Collections.sort(operationistList, new Comparator<Operationist>() {
                public int compare(Operationist o1, Operationist o2) {
                    return o1.getCountOfClients().compareTo(o2.getCountOfClients());
                }

            });
        }
    }
}
