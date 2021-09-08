package b12_java_collection_framework_map_tree.thuchanh.binary_search_tree;

public interface Tree<E> {
    boolean insert(E e);

    void inorder();

    int getSize();
}
