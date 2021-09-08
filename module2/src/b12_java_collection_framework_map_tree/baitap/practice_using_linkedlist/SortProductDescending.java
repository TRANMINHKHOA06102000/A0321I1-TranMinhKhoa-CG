package b12_java_collection_framework_map_tree.baitap.practice_using_linkedlist;

import java.util.Comparator;

public class SortProductDescending implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return ((o1.getPrice() < o2.getPrice()) ? 1 : -1);
    }
}
