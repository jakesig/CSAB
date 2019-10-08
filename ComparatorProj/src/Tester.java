import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Tester {
    public static void main(String[] args) {
        ArrayList<Laptop> compLab = new ArrayList<Laptop>(Arrays.asList(
            new Laptop("Dell", 6, 599.99),
            new Laptop("Lenovo", 14, 398.97),
            new Laptop("Apple", 10, 1299.99),
            new Laptop("Sony", 8, 500.00),
            new Laptop("Acer", 16, 999.99)));
        Comparator<Laptop> byBrand = new Comparator<Laptop>() {
            @Override public int compare(Laptop one, Laptop two) {
                return one.getBrand().compareTo(two.getBrand());
            }
        };
        Comparator<Laptop> byMemory = new Comparator<Laptop>() {
            @Override public int compare(Laptop one, Laptop two) {
                if (one.getMemory()>two.getMemory())
                    return 1;
                if (one.getMemory()<two.getMemory())
                    return -1;
                return 0;
            }
        };
        Comparator<Laptop> byPrice = new Comparator<Laptop>() {
            @Override public int compare(Laptop one, Laptop two) {
                if (one.getPrice()>two.getPrice())
                    return 1;
                if (one.getPrice()<two.getPrice())
                    return -1;
                return 0;
            }
        };
        System.out.println("\nOriginal List\n");
        for (Laptop l : compLab) {
            System.out.println(l);
        }
        Collections.sort(compLab, byBrand);
        System.out.println("\nBy Brand\n");
        for (Laptop l : compLab) {
            System.out.println(l);
        }
        Collections.sort(compLab, byMemory);
        System.out.println("\nBy Memory\n");
        for (Laptop l : compLab) {
            System.out.println(l);
        }
        Collections.sort(compLab, byPrice);;
        System.out.println("\nBy Price\n");
        for (Laptop l : compLab) {
            System.out.println(l);
        }
    }
}
