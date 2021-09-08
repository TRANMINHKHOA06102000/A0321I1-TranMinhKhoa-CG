package case_study.services;

import case_study.models.*;
import case_study.utils.BookingComparator;
import case_study.utils.ReadAndWriter;

import java.util.*;

public class BookingServiceImpl implements BookingService {
    private static Set<Booking> bookingSet = new TreeSet<>(new BookingComparator());
    static Scanner scanner = new Scanner(System.in);
    String pathFile = "D:\\A0321I1-TranMinhKhoa\\module2\\src\\case_study\\data\\booking.csv";

    static List<Customer> customerList = new ArrayList<>();
    static Map<Facility, Integer> facilityIntegerMap = new LinkedHashMap<>();

    static {
        customerList.add(new Customer("1", "khoa", "06/20/2000", "Male", 999, 0352,
                "khoa@gmail.com", "Diamond", "Quảng Ngãi"));
        customerList.add(new Customer("2", "minh", "07/20/2000", "Male", 464998, 0357,
                "minh@gmail.com", "Platinium", "Quảng Ngãi"));
        customerList.add(new Customer("3", "long", "08/20/2000", "Male", 2124, 0064,
                "long@gmail.com", "Diamond", "Quảng Ngãi"));

        facilityIntegerMap.put(new Villa("1", "Villa1", 5000, 3000, 4000, "Theo Ngày",
                "Vip", 1000, 10), 0);
        facilityIntegerMap.put(new Villa("2", "Villa2", 6000, 4000, 3000, "Theo Tháng",
                "Vip", 2000, 20), 0);

        bookingSet.add(new Booking(1, "07/10/2021", "20/10/2021",
                "001","SVVL-1111","Villa"));
        bookingSet.add(new Booking(2, "07/12/2022", "10/12/2021",
                "002","SVVL-1112","Villa"));
    }

    @Override
    public void display() {
        bookingSet = (Set<Booking>) ReadAndWriter.read(pathFile);
        System.out.println("---List Booking---");
        for (Booking booking : bookingSet) {
            System.out.println(booking.toString());
        }
    }

    @Override
    public void addNew() {
        int idBooking;
        System.out.println("Input id: ");
        idBooking = Integer.parseInt(scanner.nextLine());
        Customer idCustomer = chooseCustomer();
        Facility nameServiceFacility = chooseFacility();
        System.out.println("Input startDay booking: ");
        String startDay = scanner.nextLine();
        System.out.println("Input endDay booking: ");
        String endDay = scanner.nextLine();
        System.out.println("Input typeService booking (Villa, House, Room): ");
        String typeService = scanner.nextLine();

        Booking booking = new Booking(idBooking, startDay, endDay, idCustomer.getId(), nameServiceFacility.getName(), typeService);
        bookingSet.add(booking);
        System.out.println("Add " + booking + " successful");
        ReadAndWriter.write(bookingSet, pathFile);

        //số lần sử dụng của dịch vụ tăng 1
        /*for (Map.Entry<Facility, Integer> facilityIntegerEntry : facilityIntegerMap.entrySet()) {
            if (facilityIntegerEntry.getKey().getName().equals(nameServiceFacility)) {
                facilityIntegerMap.put(facilityIntegerEntry.getKey(), facilityIntegerEntry.getValue() + 1);
            }
        }*/
        FacilityServiceImpl facilityService=new FacilityServiceImpl();
        facilityService.updateRentedValue(nameServiceFacility.getId());
    }

    public static Customer chooseCustomer() {
        System.out.println("---List Customer---");
        for (Customer customer : customerList) {
            System.out.println(customer.toString());
        }

        System.out.println("Enter id customer");
        boolean check = true;
        String idCustomer = scanner.nextLine();
        while (check) {
            for (Customer customer : customerList) {
                if (idCustomer.equals(customer.getId())) {
                    check = false;
                    return customer;
                }
            }
            if (check) {
                System.out.println("you entered wrong, please re-enter");
                idCustomer = scanner.nextLine();
            }
        }
        return null;
    }

    public static Facility chooseFacility() {
        System.out.println("---List Service---");
        for (Map.Entry<Facility, Integer> facilityIntegerEntry : facilityIntegerMap.entrySet()) {
            System.out.println(facilityIntegerEntry.getKey().toString());
        }

        System.out.println("Enter id service");
        boolean check = true;
        String idService = scanner.nextLine();
        while (check) {
            for (Map.Entry<Facility, Integer> facilityIntegerEntry : facilityIntegerMap.entrySet()) {
                if (idService.equals(facilityIntegerEntry.getKey().getId())) {
                    check = false;
                    return facilityIntegerEntry.getKey();
                }
            }
            if (check) {
                System.out.println("you entered wrong, please re-enter");
                idService = scanner.nextLine();
            }
        }
        return null;
    }

    @Override
    public void edit() {
        Contract contract = new Contract();
        int choice = 0;
        try {
            choice = scanner.nextInt();
        } catch (NumberFormatException ex) {
            System.err.println(ex.getMessage());
        }
        do {
            System.out.println("Menu Edit");
            System.out.println("1.Edit numberContracts");
            System.out.println("2.Edit idBooking");
            System.out.println("3.Edit advanceDepositAmount");
            System.out.println("4.Edit totalPaymentAmount");
            System.out.println("5.Edit idCustomer");
            System.out.println("choose: ");
        } while (choice < 1 || choice > 5);
        switch (choice) {
            case 1:
                System.out.println("Input numberContracts: ");
                int numberContracts = 0;
                try {
                    numberContracts = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException ex) {
                    System.err.println(ex.getMessage());
                }
                contract.setNumberContracts(numberContracts);
                System.out.println("Edit " + contract + " successful");
                ReadAndWriter.write(bookingSet, pathFile);
                break;
            case 2:
                System.out.println("Input idBooking: ");
                String idBooking = scanner.nextLine();
                contract.setIdBooking(idBooking);
                System.out.println("Edit " + contract + " successful");
                ReadAndWriter.write(bookingSet, pathFile);
                break;
            case 3:
                System.out.println("Input advanceDepositAmount: ");
                double advanceDepositAmount = 0;
                try {
                    advanceDepositAmount = Double.parseDouble(scanner.nextLine());
                } catch (NumberFormatException ex) {
                    System.err.println(ex.getMessage());
                }
                contract.setAdvanceDepositAmount(advanceDepositAmount);
                System.out.println("Edit " + contract + " successful");
                ReadAndWriter.write(bookingSet, pathFile);
                break;
            case 4:
                System.out.println("Input totalPaymentAmount: ");
                double totalPaymentAmount = 0;
                try {
                    totalPaymentAmount = Double.parseDouble(scanner.nextLine());
                } catch (NumberFormatException ex) {
                    System.err.println(ex.getMessage());
                }
                contract.setTotalPaymentAmount(totalPaymentAmount);
                System.out.println("Edit " + contract + " successful");
                ReadAndWriter.write(bookingSet, pathFile);
                break;
            case 5:
                System.out.println("Input idCustomer: ");
                String idCustomer = scanner.nextLine();
                contract.setIdCustomer(idCustomer);
                System.out.println("Edit " + contract + " successful");
                ReadAndWriter.write(bookingSet, pathFile);
                break;
            default:
                System.out.println("Please enter options: 1 -> 5");
        }
    }

    public Set<Booking> sendBooking() {
        return bookingSet;
    }
/*    private void showListIdCustomer() {
        System.out.println("\n========List ID Customer========");
        int index = 0;
        for (Customer customer : customerList) {
            System.out.println("No." + index + ": " + customer);
            index++;
        }
    }
    private String chooseIdCustomer() {
        showListIdCustomer();

        System.out.print("Enter a number of list: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        boolean check = true;
        String idCustomer = null;
        while (check) {
            for (Customer customer : customerList) {
                if (choice == customerList.indexOf(customer)) {
                    idCustomer = customer.getId();
                    check = false;
                }
            }
            if (check) {
                System.out.print("Enter again, please: ");
                choice = scanner.nextInt();
            }
        }
        return idCustomer;
    }*/
}
