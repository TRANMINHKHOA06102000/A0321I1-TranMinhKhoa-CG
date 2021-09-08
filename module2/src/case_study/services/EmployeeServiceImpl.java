package case_study.services;


import case_study.models.Employee;
import case_study.utils.ReadAndWriter;
import case_study.utils.RegexData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements EmployeeService {
    private static final String REGEX_AGE_DATEOFBIRTH = "^([0-2][0-9]|3[0-1])\\/(0[0-9]|1[0-2])\\/([0-9][0-9])?[0-9][0-9]$";
    private static List<Employee> employeeArrayList;
    static Scanner scanner = new Scanner(System.in);
    String pathFile = "D:\\A0321I1-TranMinhKhoa\\module2\\src\\case_study\\data\\employee.csv";

    static {
        employeeArrayList = new ArrayList<>();
        employeeArrayList.add(new Employee("1", "khoa", "06/10/2000", "Nam", 212,
                135, "khoa4755", "aa", "bb", 2000));
    }

    @Override
    public void display() {
        employeeArrayList = (List<Employee>) ReadAndWriter.read(pathFile);
        System.out.println("--List Employee--\n");
        for (Employee employee : employeeArrayList) {
            System.out.println(employee);
        }
    }

    public Employee searchById(String id) {
        for (Employee employee : employeeArrayList) {
            if (employee.getId().equals(id)) {
                return employee;
            }
        }
        return null;
    }

    @Override
    public void addNew() {
        String id;
        do {
            System.out.println("Input Id: ");
            id = scanner.nextLine();
            if (searchById(id) != null) {
                System.out.println("id already exists");
            }
        } while (searchById(id) != null);
        System.out.println("Input name employee: ");
        String name = scanner.nextLine();
        System.out.println("Input dateOfBirth employee: ");
        String dateOfBirth = checkDoB();
        System.out.println("Input gender employee: ");
        String gender = scanner.nextLine();
        int numberCMND = 0;
        int phone = 0;
        try {
            System.out.println("Input number CMND employee: ");
            numberCMND = Integer.parseInt(scanner.nextLine());
            System.out.println("Input phone employee: ");
            phone = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException ex) {
            System.err.println(ex.getMessage());
        }
        System.out.println("Input email employee: ");
        String email = scanner.nextLine();
        System.out.println("Input level employee(Intermediate, College, Undergraduate and Graduate): ");
        String level = scanner.nextLine();
        System.out.println("Input location employee(Receptionist, waiter, specialist, supervisor, manager, director): ");
        String location = scanner.nextLine();
        double salary = 0;
        try {
            System.out.println("Input salary employee: ");
            salary = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException ex) {
            System.err.println(ex.getMessage());
        }
        Employee employee = new Employee(id, name, dateOfBirth, gender, numberCMND, phone, email, level, location, salary);
        employeeArrayList.add(employee);
        System.out.println("Add " + employee + " successful");

        ReadAndWriter.write(employeeArrayList, pathFile);
    }

    private String checkDoB() {
        return RegexData.regexAge(scanner.nextLine(), REGEX_AGE_DATEOFBIRTH);
    }

    @Override
    public void edit() {
        System.out.println("Input id to edit: ");
        String id;
        id = scanner.nextLine();
        Employee employee = searchById(id);
        if (employee == null) {
            System.out.println("Id does not exist");
        } else {
            int choice = 0;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException ex) {
                System.err.println(ex.getMessage());
            }
            do {
                System.out.println("Menu Edit");
                System.out.println("1.Edit name employee");
                System.out.println("2.Edit dateOfBirth employee");
                System.out.println("3.Edit gender employee");
                System.out.println("4.Edit numberCMND employee");
                System.out.println("5.Edit phone employee");
                System.out.println("6.Edit email employee");
                System.out.println("7.Edit level employee");
                System.out.println("8.Edit location employee");
                System.out.println("9.Edit salary employee");
                System.out.println("choose: ");

            } while (choice < 1 || choice > 9);
            switch (choice) {
                case 1:
                    System.out.println("Input new name employee: ");
                    String newName = scanner.nextLine();
                    employee.setName(newName);
                    System.out.println("Edit " + employee + " successful");
                    ReadAndWriter.write(employeeArrayList, pathFile);
                    break;
                case 2:
                    System.out.println("Input new dateOfBirth employee: ");
                    String newDateOfBirth = scanner.nextLine();
                    employee.setDateOfBirth(newDateOfBirth);
                    System.out.println("Edit " + employee + " successful");
                    ReadAndWriter.write(employeeArrayList, pathFile);
                    break;
                case 3:
                    System.out.println("Input new gender employee: ");
                    String newGender = scanner.nextLine();
                    employee.setGender(newGender);
                    System.out.println("Edit " + employee + " successful");
                    ReadAndWriter.write(employeeArrayList, pathFile);
                    break;
                case 4:
                    System.out.println("Input new numberCMND employee: ");
                    int newNumberCMND = 0;
                    try {
                        newNumberCMND = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException ex) {
                        System.err.println(ex.getMessage());
                    }
                    employee.setNumberCMND(newNumberCMND);
                    System.out.println("Edit " + employee + " successful");
                    ReadAndWriter.write(employeeArrayList, pathFile);
                    break;
                case 5:
                    System.out.println("Input new phone employee: ");
                    int newPhone = 0;
                    try {
                        newPhone = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException ex) {
                        System.err.println(ex.getMessage());
                    }
                    employee.setPhone(newPhone);
                    System.out.println("Edit " + employee + " successful");
                    ReadAndWriter.write(employeeArrayList, pathFile);
                    break;
                case 6:
                    System.out.println("Input new email employee: ");
                    String newEmail = scanner.nextLine();
                    employee.setEmail(newEmail);
                    System.out.println("Edit " + employee + " successful");
                    ReadAndWriter.write(employeeArrayList, pathFile);
                    break;
                case 7:
                    System.out.println("Input new level employee(Intermediate, College, Undergraduate and Graduate): ");
                    String newLevel = scanner.nextLine();
                    employee.setLevel(newLevel);
                    System.out.println("Edit " + employee + " successful");
                    ReadAndWriter.write(employeeArrayList, pathFile);
                    break;
                case 8:
                    System.out.println("Input new location employee(Receptionist, waiter, specialist, supervisor, manager, director): ");
                    String newLocation = scanner.nextLine();
                    employee.setLocation(newLocation);
                    System.out.println("Edit " + employee + " successful");
                    ReadAndWriter.write(employeeArrayList, pathFile);
                    break;
                case 9:
                    System.out.println("Input new salary employee: ");
                    double newSalary = 0;
                    try {
                        newSalary = Double.parseDouble(scanner.nextLine());
                    } catch (NumberFormatException ex) {
                        System.err.println(ex.getMessage());
                    }
                    employee.setSalary(newSalary);
                    System.out.println("Edit " + employee + " successful");
                    ReadAndWriter.write(employeeArrayList, pathFile);
                    break;
                default:
                    System.out.println("Please enter options: 1 -> 9");
            }
        }
    }

    @Override
    public void delete() {
        System.out.println("Nhập id cần xóa: ");
        String id = scanner.nextLine();
        Employee employee = searchById(id);
        if (employee == null) {
            System.out.println("Id does not exist");
        } else {
            employeeArrayList.remove(employee);
            System.out.println("Delete " + employee + " successful");
            ReadAndWriter.write(employeeArrayList, pathFile);
        }
    }

    @Override
    public void find() {
        System.out.println("Input id to find: ");
        String id = scanner.nextLine();
        Employee employee = searchById(id);
        if (employee == null) {
            System.out.println("id product does not exist");
        } else {
            System.out.println("result: " + employee);
        }
//        System.out.println("Input id to find: ");
//        String id = scanner.nextLine();
//        System.out.println("List customer use service in " + id);
//        for (Employee employee : employeeArrayList) {
//            if (employee.getId().equals(id)){
//                System.out.println(employee.toString());
//            }
//        }
    }
}
