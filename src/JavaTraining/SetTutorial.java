package JavaTraining;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class SetTutorial {
    public static void main(String[] args) {
//        Set<String> cuvinteSingulare = Arrays.asList(args)
//                .stream()
//                .collect(Collectors.toSet());
//        System.out.println(cuvinteSingulare.size() + " cuvinte fara dublicate " + cuvinteSingulare);
//
//        int count[] = {12,43,6565,32,43};
//        Set<Integer> set = new HashSet<Integer>();
//        try{
//            for (int i = 0; i < 5; i++)
//            {
//                set.add(count[i]);
//            }
//            System.out.println(" The sorted list is :" );
//            TreeSet sortedlist = new TreeSet<Integer>(set);
//            System.out.println(sortedlist);
//
//        }
//        catch (Exception e) {}
//    }

        //another set example
        Set<String> s1 = new HashSet<>();

        // Add a few elements
        s1.add("HTML");
        s1.add("SS");
        s1.add("SASA");

        Set<String> s2 = new HashSet<>();
//        s2.clear();
        s2.add(null);
    }
}
