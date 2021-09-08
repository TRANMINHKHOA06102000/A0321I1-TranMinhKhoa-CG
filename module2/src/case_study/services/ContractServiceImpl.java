package case_study.services;


import case_study.models.Booking;
import case_study.models.Contract;
import case_study.utils.ReadAndWriter;

import java.util.*;

public class ContractServiceImpl implements ContractService {
    static List<Contract> contractList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    String pathFile= "D:\\A0321I1-TranMinhKhoa\\module2\\src\\case_study\\data\\contract.csv";

    @Override
    public void addNew() {
        Queue<Booking> bookingQueue = new LinkedList<>();
        Set<Booking> bookingSet = new BookingServiceImpl().sendBooking();

        for (Booking booking : bookingSet) {
            bookingQueue.add(booking);
        }
        while (!bookingQueue.isEmpty()) {
            Booking booking = bookingQueue.poll();
            String customer = booking.getIdCustomer();

            System.out.println("creating contract for booking with information: " + booking.toString());
            System.out.println("creating contract for customer with information: " + customer.toString());

            int numberContracts = 0;
            double advanceDepositAmount = 0;
            double totalPaymentAmount = 0;
            try {
                System.out.println("input numberContracts:");
                numberContracts = Integer.parseInt(scanner.nextLine());
                System.out.println("input advanceDepositAmount:");
                advanceDepositAmount = Double.parseDouble(scanner.nextLine());
                System.out.println("input totalPaymentAmount:");
                totalPaymentAmount = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException ex) {
                System.err.println(ex.getMessage());
            }
            Contract contract = new Contract(numberContracts, booking.toString(), advanceDepositAmount, totalPaymentAmount, customer);
            contractList.add(contract);
            System.out.println("Add " + contract + " successful");
            ReadAndWriter.write(contractList,pathFile);
        }
    }

    @Override
    public void display() {
        contractList= (List<Contract>) ReadAndWriter.read(pathFile);
        for (Contract contract : contractList) {
            System.out.println(contract.toString());
        }
    }

    @Override
    public void edit() {

    }
}
