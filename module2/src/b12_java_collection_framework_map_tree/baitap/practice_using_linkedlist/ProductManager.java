package b12_java_collection_framework_map_tree.baitap.practice_using_linkedlist;

import java.util.LinkedList;
import java.util.Scanner;

public class ProductManager {
    static LinkedList<Product> productLinkedList = new LinkedList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void displayMenu() {
        int choice;
        do {
            System.out.println("Menu");
            System.out.println("1.Add Product");
            System.out.println("2.Edit Product");
            System.out.println("3.Delete Product");
            System.out.println("4.Show Product");
            System.out.println("5.Find Product");
            System.out.println("6.Sort Product");
            System.out.println("7.Exit");
            System.out.println("Choice: ");
            choice = scanner.nextInt();
        } while (choice < 1 || choice > 7);
        switch (choice) {
            case 1:
                System.out.println("Add Product ");
                addProduct();
                break;
            case 2:
                System.out.println("Edit Product ");
                editProduct();
                break;
            case 3:
                System.out.println("Delete Product ");
                deleteProduct();
                break;
            case 4:
                System.out.println("Show Product ");
                showProduct();
                break;
            case 5:
                System.out.println("Find Product ");
                findProduct();
                break;
            case 6:
                System.out.println("Sort Product ");
                sortProduct();
                break;
            case 7:
                System.exit(0);
                break;
            default:
                System.out.println("Please enter options: 1 -> 7");
        }

    }

    public static Product searchById(int id) {
        for (Product product : productLinkedList) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public static void addProduct() {
        int id;
        do {
            System.out.println("Input Id: ");
            id = scanner.nextInt();
            if (searchById(id) != null) {
                System.out.println("id already exists");
            }
        } while (searchById(id) != null);
        scanner.skip("\\R");
        System.out.println("Input Name Product: ");
        String name = scanner.nextLine();
        System.out.println("Input Price: ");
        double price = scanner.nextDouble();
        Product product = new Product(id, name, price);
        productLinkedList.add(product);
        System.out.println("Add " + product + " successful");
        displayMenu();
    }

    public static void editProduct() {
        System.out.println("Input id to edit: ");
        int id;
        id = scanner.nextInt();
        Product product = searchById(id);
        if (product == null) {
            System.out.println("Id does not exist");
        } else {
            int choice;
            do {
                System.out.println("Menu Edit");
                System.out.println("1.Edit name product");
                System.out.println("2.Edit price");
                System.out.println("choose: ");
                choice = scanner.nextInt();
            } while (choice < 1 || choice > 2);
            switch (choice) {
                case 1:
                    scanner.skip("\\R");
                    System.out.println("Input new name product: ");
                    String newName = scanner.nextLine();
                    product.setProductName(newName);
                    System.out.println("Edit " + product + " successful");
                    break;
                case 2:
                    scanner.skip("\\R");
                    System.out.println("Input new price: ");
                    double newPrice = scanner.nextDouble();
                    product.setPrice(newPrice);
                    System.out.println("Edit " + product + " successful");
                    break;
                default:
                    System.out.println("Please enter options: 1 -> 2");
            }
        }
        displayMenu();
    }

    public static void deleteProduct() {
        int id;
        System.out.println("Input id to delete");
        id = scanner.nextInt();
        Product product = searchById(id);
        if (product == null) {
            System.out.println("Id does not exist");
        } else {
            productLinkedList.remove(product);
            System.out.println("Delete " + product + " successful");
            showProduct();
        }
        displayMenu();
    }

    public static void showProduct() {
        for (Product product : productLinkedList) {
            System.out.println(product);
        }
        displayMenu();
    }

    public static Product searchByName(String name) {
        for (Product product : productLinkedList) {
            if (product.getProductName().equals(name)) {
                return product;
            }
        }
        return null;
    }

    public static void findProduct() {
        System.out.println("Input name to find: ");
        scanner.skip("\\R");
        String name;
        name = scanner.nextLine();
        Product product = searchByName(name);
        if (product == null) {
            System.out.println("name product does not exist");
        } else {
            System.out.println("result: " + product);
        }
        displayMenu();
    }

    public static void sortProduct() {
        System.out.println("Input 1 Sort product ascending \nInput 2 Sort product descending\nchoose: ");
        int choice = scanner.nextInt();
        do {
            if (choice == 1) {
                System.out.println("Sort product ascending");
                sortProductAscending();
            } else if (choice == 2) {
                System.out.println("Sort product descending");
                sortProductDescending();
            }
        }
        while (choice < 1 || choice > 2);
        displayMenu();
    }

    private static void sortProductDescending() {
        SortProductDescending sortProductDescending = new SortProductDescending();
        productLinkedList.sort(sortProductDescending);
        showProduct();
    }

    private static void sortProductAscending() {
        SortProductAscending sortProductAscending = new SortProductAscending();
        productLinkedList.sort(sortProductAscending);
        showProduct();
    }

    public static void main(String[] args) {
        displayMenu();
    }
}
