package case_study.controllers;

import case_study.services.*;

import java.util.Scanner;

public class FuramaController {
    static Scanner input = new Scanner(System.in);

    public void displayMainMenu() {
        System.out.println("---------- MAIN MENU ----------");
        System.out.println("1. Employee Management");
        System.out.println("2. Customer Management");
        System.out.println("3. Facility Management ");
        System.out.println("4. Booking Managerment");
        System.out.println("5. Promotion Management");
        System.out.println("6. Exit");
        System.out.println("------------------------------");
        System.out.print("Your choose: ");
        int choose = 0;
        try {
            choose = Integer.parseInt(input.nextLine());
        } catch (NumberFormatException ex) {
            System.err.println(ex.getMessage());
        }

        switch (choose) {
            case 1: {
                employee();
                break;
            }
            case 2: {
                customer();
                break;
            }
            case 3: {
                facility();
                break;
            }
            case 4: {
                booking();
                break;
            }
            case 5: {
                promotion();
                break;
            }
            case 6: {
                System.exit(0);
                break;
            }
            default: {
                System.out.println("Fail! Please choose again! Enter to continue.");
                displayMainMenu();
            }
        }
    }

    public void employee() {
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        System.out.println("---------- Employee Management ----------");
        System.out.println("1. Display list employees");
        System.out.println("2. Add new employee");
        System.out.println("3. Edit employee ");
        System.out.println("4. Return main menu");
        System.out.println("5. Exit");
        System.out.println("6. Delete");
        System.out.println("7. Find");
        System.out.println("------------------------------");
        System.out.print("Your choose: ");
        int choose = 0;
        try {
            choose = Integer.parseInt(input.nextLine());
        } catch (NumberFormatException ex) {
            System.err.println(ex.getMessage());
        }

        switch (choose) {
            case 1: {
                employeeService.display();
                employee();
                break;
            }
            case 2: {
                employeeService.addNew();
                employee();
                break;
            }
            case 3: {
                employeeService.edit();
                employee();
                break;
            }
            case 4: {
                displayMainMenu();
                break;
            }
            case 5: {
                System.exit(0);
                break;
            }
            case 6: {
                employeeService.delete();
                employee();
                break;
            }
            case 7: {
                employeeService.find();
                employee();
                break;
            }
            default: {
                System.out.println("Fail! Please choose again! Enter to continue.");
                employee();
            }
        }
    }

    public void customer() {
        CustomerServiceImpl customerService = new CustomerServiceImpl();
        System.out.println("---------- Customer Management ----------");
        System.out.println("1. Display list customers");
        System.out.println("2. Add new customer");
        System.out.println("3. Edit customer ");
        System.out.println("4. Return main menu");
        System.out.println("5. Exit");
        System.out.println("------------------------------");
        System.out.print("Your choose: ");
        int choose = 0;
        try {
            choose = Integer.parseInt(input.nextLine());
        } catch (NumberFormatException ex) {
            System.err.println(ex.getMessage());
        }

        switch (choose) {
            case 1: {
                customerService.display();
                customer();
                break;
            }
            case 2: {
                customerService.addNew();
                customer();
                break;
            }
            case 3: {
                customerService.edit();
                customer();
                break;
            }
            case 4: {
                displayMainMenu();
                break;
            }
            case 5: {
                System.exit(0);
                break;
            }
            default: {
                System.out.println("Fail! Please choose again! Enter to continue.");
                customer();
            }
        }
    }

    public void facility() {
        FacilityServiceImpl facilityService = new FacilityServiceImpl();
        System.out.println("---------- Facility Management ----------");
        System.out.println("1. Display list facility");
        System.out.println("2. Add new facility");
        System.out.println("3. Display list facility maintenance ");
        System.out.println("4. Return main menu");
        System.out.println("5. Exit");
        System.out.println("------------------------------");
        System.out.print("Your choose: ");
        int choose = 0;
        try {
            choose = Integer.parseInt(input.nextLine());
        } catch (NumberFormatException ex) {
            System.err.println(ex.getMessage());
        }

        switch (choose) {
            case 1: {
                facilityService.display();
                facility();
                break;
            }
            case 2: {
                facilityService.addNew();
                facility();
                break;
            }
            case 3: {
                facilityService.displayFacilityNeedingMaintenance();
                facility();
                break;
            }
            case 4: {
                displayMainMenu();
                break;
            }
            case 5: {
                System.exit(0);
                break;
            }
            default: {
                System.out.println("Fail! Please choose again! Enter to continue.");
                facility();
            }
        }
    }

    public void booking() {
        BookingServiceImpl bookingService = new BookingServiceImpl();
        ContractServiceImpl contractService = new ContractServiceImpl();
        System.out.println("---------- Booking Management ----------");
        System.out.println("1. Add new booking");
        System.out.println("2. Display list booking");
        System.out.println("3. Create new constracts ");
        System.out.println("4. Display list contracts");
        System.out.println("5. Edit contracts");
        System.out.println("6. Return main menu");
        System.out.println("------------------------------");
        System.out.print("Your choose: ");
        int choose = 0;
        try {
            choose = Integer.parseInt(input.nextLine());
        } catch (NumberFormatException ex) {
            System.err.println(ex.getMessage());
        }

        switch (choose) {
            case 1: {
                bookingService.addNew();
                booking();
                break;
            }
            case 2: {
                bookingService.display();
                booking();
                break;
            }
            case 3: {
                contractService.addNew();
                booking();
                break;
            }
            case 4: {
                contractService.display();
                booking();
                break;
            }
            case 5: {
                contractService.edit();
                break;
            }
            case 6: {
                displayMainMenu();
                break;
            }
            case 7: {
                System.exit(0);
                break;
            }
            default: {
                System.out.println("Fail! Please choose again! Enter to continue.");
                booking();
            }
        }
    }

    public void promotion() {
        PromotionServiceImpl promotionService = new PromotionServiceImpl();
        System.out.println("---------- Promotion Management ----------");
        System.out.println("1. Display list customers use service");
        System.out.println("2. Display list customers get voucher");
        System.out.println("3. Return main menu");
        System.out.println("4. Exit");
        System.out.println("------------------------------");
        System.out.print("Your choose: ");
        int choose = 0;
        try {
            choose = Integer.parseInt(input.nextLine());
        } catch (NumberFormatException ex) {
            System.err.println(ex.getMessage());
        }

        switch (choose) {
            case 1: {
                promotionService.displayListCustomersUseService();
                break;
            }
            case 2: {
                promotionService.displayListCustomersGetVoucher();
                break;
            }
            case 3: {
                displayMainMenu();
                break;
            }
            case 4: {
                System.exit(0);
                break;
            }
            default: {
                System.out.println("Fail! Please choose again! Enter to continue.");
                promotion();
            }
        }
    }
}
