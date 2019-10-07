import java.util.*;

public class IteratorDemo {
    public static void main(String[] args) {
        ArrayList<String> data = new ArrayList<String>();
        data.add("Apple");
        data.add("Pear");
        data.add("Banana");
        data.add("Cherry");
        data.add("Cucumber");
        data.add("Eggplant");
        data.add("Berries");
        /*System.out.println("-------------");
        System.out.println("Removing without Iterator...");
        System.out.println("-------------");
        for (int i = data.size()-1; i>=0; --i) {
            if (data.get(i).startsWith("C"))
                data.remove(i);
        }
        System.out.println("------------");
        System.out.println("Final Result");
        System.out.println("------------");
        System.out.println(data);*/
        /*data.add(3,"Cherry");
        data.add(4,"Cucumber");*/
        ListIterator it = data.listIterator();
        //Iterator it = data.iterator();
        //System.out.println(data);
        /*System.out.println("-------------");
        System.out.println("Removing with ListIterator...");
        System.out.println("-------------");*/
        /*while (it.hasNext()) {
            String s = (String)it.next();
            if (s.startsWith("C"))
                it.remove();
        }*/
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println();
        while (it.hasPrevious()) {
            System.out.println(it.previous());
        }
        /*System.out.println("------------");
        System.out.println("Final Result");
        System.out.println("------------");
        System.out.println(data);*/
    }
}
