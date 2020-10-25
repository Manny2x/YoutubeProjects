import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.function.Function;
// This class will be used for adding the name or numbers or decimal values
// of the user

class ArrayListMod<T> {

    int definedCapacity;
    String valStringType;

    ArrayListMod(T val, int defineCapacity){
        valStringType = val.getClass().getName();
        definedCapacity = defineCapacity;
    }
    public Object getValue(){
        if(valStringType.equals("java.lang.String")){
            return "String";
        }else if (valStringType.equals("java.lang.Integer")){
            return "Integer";
        } else if (valStringType.equals("java.lang.Double")){
            return "Double";
        }

        else{
            return null;
        }
    }

    public T getValueInStr(Function<String, T> function) {
        T returner = null;
        try{
        Scanner scanner = new Scanner(System.in);

        System.out.println("Separate these with a comma");
        returner = function.apply(scanner.nextLine());
        } catch(InputMismatchException e){
            System.out.println("Error in getting input, incorrect type");
        }
        return returner;
    }


    @SafeVarargs
    public final ArrayList<T> createALJ(T... a){
        ArrayList<T> arrayList
                = new ArrayList<>(definedCapacity);

        for(T lx: a){
            T val = a[(int) lx];

            arrayList.add(val);
        }
        return arrayList;
    }

    @Override
    public String toString() {
        return "Your value was a " + valStringType +
                "You put in: ";
    }
}
