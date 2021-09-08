package b19_string_and_regex.baitap.validate_name_class;

public class NamClassExampleMainTest {
    private static NameClassExample nameClassExample;

    public static final String[] validNameClass = new String[]{"C1234K", "A1234H", "P1234I"};
    public static final String[] invalidAccount = new String[]{"Z1234T", "C111I", "P112J"};

    public static void main(String args[]) {
        nameClassExample = new NameClassExample();
        for (String nameClass : validNameClass) {
            boolean isvalid = nameClassExample.validate(nameClass);
            System.out.println("Name Class is " + nameClass + " is valid: " + isvalid);
        }
        for (String nameClass : invalidAccount) {
            boolean isvalid = nameClassExample.validate(nameClass);
            System.out.println("Name Class  is " + nameClass + " is valid: " + isvalid);
        }
    }

}
