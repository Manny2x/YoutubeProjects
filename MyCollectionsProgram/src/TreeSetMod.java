//This class creates a tree set
//that will be separated with a ,(comma)


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Function;

class TreeSetMod<E>{

    String valStringType;
    String trimmedType;

    TreeSetMod(Class<E> clazz){
        valStringType = clazz.getName();

        switch (valStringType) {
            case "java.lang.String":
                trimmedType = "String";
                break;
            case "java.lang.Integer":
                trimmedType = "Integer";
                break;
            case "java.lang.Double":
                trimmedType = "Double";
                break;
        }
    }
    public TreeSet<Object> getValueInStr(Function<Object, E> function) {
        TreeSet<Object> returnedTreeSet =
                new TreeSet<>();

        switch (trimmedType) {
            case "String":
                try {
                    BufferedReader bufferedReader =
                            new BufferedReader(
                                    new InputStreamReader(
                                            System.in)
                            );

                    final int maxIntake = 20;

                    for (int i = 0; i < maxIntake; i++) {
                        returnedTreeSet.add(
                                bufferedReader.readLine());

                    }
                } catch (InputMismatchException | IOException e) {
                    System.out.println("Error in collecting input");
                    e.printStackTrace();
                }
                break;
            case "Integer":
                try {
                    Scanner scan =
                            new Scanner(
                                    System.in
                            );

                    final int maxIntake = 20;

                    for (int i = 0; i < maxIntake; i++) {
                        returnedTreeSet.add(
                                scan);

                    }
                } catch (InputMismatchException e) {
                    System.out.println("Error in collecting input");
                    e.printStackTrace();
                }
                break;
            case "Double":
                try {
                    Scanner scan =
                            new Scanner(
                                    System.in
                            );

                    final int maxIntake = 20;

                    for (int i = 0; i < maxIntake; i++) {
                        returnedTreeSet.add(
                                scan.nextDouble());

                    }
                } catch (InputMismatchException e) {
                    System.out.println("Error in collecting input");
                    e.printStackTrace();
                }
                break;
        }
            return returnedTreeSet;
    }



    public void editTreeSet(TreeSet<Object> eTreeSet) {

        switch (trimmedType) {
            case "String":
                TreeSet<Object> referenceTree =
                        new TreeSet<Object>();

                Iterator<Object> itr =
                        referenceTree.descendingIterator();
                while (itr.hasNext()) {
                    Object element = itr.next();

                    referenceTree.add(element + " + ");
                    eTreeSet = referenceTree;
                }


                break;
            case "Integer": {

                TreeSet<Object> referenceTreeInt =
                        new TreeSet<Object>();

                Iterator<Object> itrInt =
                        referenceTreeInt.descendingIterator();
                while (itrInt.hasNext()) {
                    Object element = itrInt.next();

                    referenceTreeInt.add(element + ", ");
                }
                eTreeSet = referenceTreeInt;
                break;
            }
            case "Double": {

                TreeSet<Object> referenceTreeDouble =
                        new TreeSet<Object>();

                Iterator<Object> itrInt =
                        referenceTreeDouble.descendingIterator();
                while (itrInt.hasNext()) {
                    Object element = itrInt.next();

                    referenceTreeDouble.add(element + "-- ");
                }
                eTreeSet = referenceTreeDouble;
                break;
            }
        }

    }
    public TreeSet<Object> createTreeSet(){
        Function<Object, E> function =
                o -> null;

        editTreeSet(getValueInStr(function));

        return getValueInStr(function);

    }

    @Override
    public String toString() {
        switch (trimmedType) {
            case "String":
                return "Your list of strings has been separated with \n" +
                        "addition signs: ";
            case "Integer":
                return "Your list of integers has been separated with \n" +
                        "commas: ";
            case "Double":
                return "Your list of decimals has been separated with \n" +
                        "double dashes: ";
            default:
                return "Error in receiving strings";
        }
    }


}