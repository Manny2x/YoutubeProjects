// Use this class to control a queue of numbers
// or a sentence. Based on the order.


import java.util.*;
import java.util.function.Function;

class LinkedListMod<T> {
    String valStringType;
    LinkedList classWideList;

    LinkedListMod(T val) {
        valStringType = val.getClass().getName();
    }

    public String getValue() {
        switch (valStringType) {
            case "java.lang.String":
                return "String";
            case "java.lang.Integer":
                return "Integer";
            case "java.lang.Double":
                return "Double";
            default:
                return null;
        }
    }

    public String getValueInStr(Function<String, T> function) {
        String returner = "";

        try {

            Scanner scanner = new Scanner(System.in);

            System.out.println("Separate these with a comma");
            returner = String.valueOf(function.apply(scanner.nextLine()));
        } catch (InputMismatchException e) {
            System.out.println("Error in getting input, incorrect input");
            e.printStackTrace();
        }
        return returner;
    }

    public void createLL(LinkedList<Object> linkedList) {
        switch (getValue()) {
            case "String": {
                Function<String, T> function =
                        s -> null;

                String str =
                        getValueInStr(function);

                ArrayList<String> addedValues
                        = new ArrayList<>();
                char[] myCharArray = str.toCharArray();


                for (int i = 0; i < myCharArray.length; i++) {
                    for (char c : myCharArray) {
                        addedValues.add(String.valueOf(c));
                        if (c == ',')
                            break;
                    }
                }

                int loop = 1;
                for (String ignored : addedValues) {
                    linkedList.add(addedValues.get(loop));
                    loop = loop + 1;
                }
                classWideList =
                        linkedList
                ;
                break;
            }
            case "Integer": {
                Function<String, T> function =
                        s -> null;

                String str =
                        getValueInStr(function);

                char[] myCharArray =
                        str.toCharArray();

                for (int i = 0; i < myCharArray.length; i++) {
                    for (char c : myCharArray) {
                        Integer newInt =
                                (int) myCharArray[c];
                        linkedList.add(newInt);
                        if (c == ',')
                            break;
                    }
                }
                classWideList =
                        linkedList;
                break;
            }
            case "Double": {
                Function<String, T> function =
                        new Function<String, T>() {
                            @Override
                            public T apply(String s) {
                                return null;
                            }
                        };

                String str =
                        getValueInStr(function);
                char[] myCharArray =
                        str.toCharArray();

                for (int i = 0; i < myCharArray.length; i++) {
                    for (char c : myCharArray) {
                        Double newInt =
                                (double) myCharArray[c];
                        linkedList.add(newInt);
                        if (c == ',')
                            break;
                    }
                }
                classWideList =
                        linkedList;
                break;
            }
        }
    }

    //Before use the List must be created!
    public void orderList(LinkedList<T> list, Comparator<T> comparator) {
        //Bubble sort algorithm
        boolean sorted;
        T temp;
        final int size = list.size() - 1;
        do {
            sorted = true;
            for (int i = 0; i < size; i++) {
                if (comparator.compare(list.get(i), list.get(i + 1)) > 0) {
                    temp = list.get(i);
                    list.set(i, list.get(i + 1));
                    list.set(i + 1, temp);
                    sorted = false;
                }
            }
        } while (!sorted);
    }

    public Object getNextQueue() {
        return "This is the next item in line" + classWideList.peek();
    }
}
