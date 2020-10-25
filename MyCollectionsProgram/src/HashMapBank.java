import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class HashMapBank<E, T> {
    T balance;
    E name;

    String balanceString;
    String stringRepT;

    HashMapBank(T balance,
                E name,
                Class<T> clazz){
        this.balance = balance;
        this.name = name;

        this.balanceString = clazz.getName();

        if ("java.lang.Integer".equals(balance)) {
            this.stringRepT = "Integer";
        } else if ("java.lang.Double".equals(balance)) {
            this.stringRepT = "Double";
        }

    }
    HashMap<String, Object> hashMapBank =
            new HashMap<>();

    public void createBank(HashMap<String, Object> hashMapBank){
        try{
            BufferedReader br =
                    new BufferedReader(
                            new InputStreamReader(
                                    System.in
                            )
                    );
            Scanner scan =
                    new Scanner(
                            System.in
                    );

            String Name;
            Object balance;

            for(int i = 0; ; i++){
                Name = br.readLine();

                if(stringRepT.equals("Integer")){
                   balance = scan.nextInt();

                   hashMapBank.put(Name,
                           balance);
                } else if(stringRepT.equals("Double")){
                    balance = scan.nextDouble();

                    hashMapBank.put(Name,
                            balance);
                }
                if(br.readLine().equals(" "))
                    break;
            }
        }catch(InputMismatchException | IOException e){
            e.printStackTrace();
        }
    }

    public void deposit(HashMap<String, Object> hashMapBank,
                        String keyName,
                        Integer depositAmount,
                        Double depositAmountDouble){
        if(stringRepT.equals("Integer")) {
                Integer balance = (Integer) hashMapBank.get(keyName);

                hashMapBank.put(keyName, balance + depositAmount);
        } else if (stringRepT.equals("Double")){
            Double balance = (Double) hashMapBank.get(keyName);

            hashMapBank.put(keyName, balance + depositAmountDouble);
        }
    }

    public void withdraw(HashMap<String, Object> hashMapBank,
                        String keyName,
                        Integer withdrawAmount,
                        Double withdrawAmountDouble){
        if(stringRepT.equals("Integer")) {
            Integer balance = (Integer) hashMapBank.get(keyName);

            hashMapBank.put(keyName, balance - withdrawAmount);
        } else if (stringRepT.equals("Double")){
            Double balance = (Double) hashMapBank.get(keyName);

            hashMapBank.put(keyName, balance - withdrawAmountDouble);
        }
    }

    // So the values can be safely displayed
    public Set<Map.Entry<String, Object>> getSet(HashMap<String, Object> hashMapBank){
        return hashMapBank.entrySet();
    }
}
