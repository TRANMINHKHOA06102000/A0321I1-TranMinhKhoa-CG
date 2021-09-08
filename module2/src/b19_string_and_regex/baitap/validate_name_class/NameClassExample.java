package b19_string_and_regex.baitap.validate_name_class;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameClassExample {
    private static final String ACCOUNT_REGEX = "^[CAP][0-9]{4}[GHIKLM]$";

    public NameClassExample() {
    }

    public boolean validate(String regex) {
        Pattern pattern = Pattern.compile(ACCOUNT_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
