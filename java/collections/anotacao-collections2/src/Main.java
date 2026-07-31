import java.util.*;

public class Main{
    public static void main(String[] args){
//        LinkedList<Integer> numberLinkedList = new LinkedList<>();
//        numberLinkedList.add(1);
//        numberLinkedList.add(2);
//        numberLinkedList.add(4);
//        numberLinkedList.add(2, 3);
//
//        System.out.println(numberLinkedList.get(0));
//        System.out.println(numberLinkedList.get(1));
//        System.out.println(numberLinkedList.get(2));

//        ArrayList<Integer> numberArrayList = new ArrayList<>();
//        for(int quantity = 0; quantity < 100; quantity++){
//            numberArrayList.add(quantity);
//        }
//
//        System.out.println(numberArrayList.get(99));

        HashMap<String, Integer> employeesIds = new HashMap<>();

        employeesIds.put("John", 12345);
        employeesIds.put("Carl", 54321);
        employeesIds.put("Jerry", 8675309);

        System.out.println(employeesIds);

        System.out.println(employeesIds.get("Carl"));

        System.out.println(employeesIds.containsKey("George"));

        System.out.println(employeesIds.containsValue(8675309));

        employeesIds.put("John", 98765);
        System.out.println(employeesIds);

        employeesIds.replace("John", 777);
        System.out.println(employeesIds);

        employeesIds.putIfAbsent("Steve", 2);
        System.out.println(employeesIds);

        Map<String, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
    }
}