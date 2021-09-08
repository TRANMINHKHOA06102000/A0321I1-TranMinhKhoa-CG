package b19_string_and_regex.baitap.validate_phone;

public class PhoneExampleMainTest {
    private static PhoneExample phoneExample;

    public static final String[] validPhone = new String[]{"(84)-(0978489648)", "(84)-(0978489658)"};
    public static final String[] invalidPhone = new String[]{"(a8)-(22222222)", "(84)-(0222222a)"};

    public static void main(String[] args) {
        phoneExample = new PhoneExample();
        for (String phone : validPhone) {
            boolean isvalid = phoneExample.validate(phone);
            System.out.println("Phone is " + phone + " is valid: " + isvalid);
        }
        for (String phone : invalidPhone) {
            boolean isvalid = phoneExample.validate(phone);
            System.out.println("Phone is " + phone + " is valid: " + isvalid);
        }
    }
}
