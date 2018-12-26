package JavaTraining;

import java.util.ArrayList;
import java.util.List;

public class ListTutorial {
    public static void main(String[] args){
        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(0, 1);
        list1.add(1,2);
        list1.add(2, 3);

        List<Integer> list2 = new ArrayList<Integer>();
        list2.add(0, 32);
        list2.add(1, 33);
        list2.add(2, 34);
        list2.add(3, 35);

        list1.addAll(1, list2);
        System.out.println(list1);
        list1.remove(2);
        System.out.println(list1);

        List<String> list3 = new ArrayList<String>();
        list3.add("test1");
        list3.add("test2");
        list3.add("test3");

        System.out.println(list3);
        System.out.println(list3.lastIndexOf("test1"));

//        List<String> list4 = new ArrayList<String>();
//        list4.add("")
    }
}
