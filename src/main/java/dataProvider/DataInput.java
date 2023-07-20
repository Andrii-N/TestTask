package dataProvider;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DataInput {
    private final String MALE = "MALE";
    private final String FEMALE = "FEMALE";

    private final String multiplier = "279146358279";
    private Person person;

    private long cnp;
    private String firstDigit;
    private String secondThirdDigits;
    private String fourthFifthDigits;
    private String sixthSeventhDigits;
    private String eightsNinthDigits;

    private String tenthEleventhTwelfthDigits;

    private String thirteenthDigit;

    public DataInput(Person person) {
        this.person = person;
        firstDigit = defineFirstNumber();
        secondThirdDigits = String.valueOf(person.getDateOfBirth().getYear()).substring(2);
        fourthFifthDigits = addLeadingZero(String.valueOf(person.getDateOfBirth().getMonthValue()));
        sixthSeventhDigits = addLeadingZero(String.valueOf(person.getDateOfBirth().getDayOfMonth()));
        eightsNinthDigits = addLeadingZero(String.valueOf(person.getAreaCode()));
        tenthEleventhTwelfthDigits = person.getOrderNumber();

        String twelveDigits = firstDigit + secondThirdDigits + fourthFifthDigits + sixthSeventhDigits + eightsNinthDigits + tenthEleventhTwelfthDigits;

        thirteenthDigit = String.valueOf(calculateLastDigit(twelveDigits) % 11 == 10 ? 1: calculateLastDigit(twelveDigits) % 11);

        cnp = Long.parseLong(twelveDigits + thirteenthDigit);
        System.out.println(String.format("Person CNP is: %d", cnp));
    }


    private int calculateLastDigit(String twelve) {
        char[] twelveChars = twelve.toCharArray();
        char[] multiplierChars = multiplier.toCharArray();
        List<Integer> multipliedChars = new ArrayList<>();
        for(int i = 0; i < twelveChars.length; i++ ) {
            multipliedChars.add(multiplyChars(twelveChars[i], multiplierChars[i]));
        }
        int sum = multipliedChars.stream().collect(Collectors.summingInt(Integer::intValue));
        return  sum % 11 == 10 ? 1 : sum;
    }

    private int multiplyChars( char one, char two) {
        return Character.getNumericValue(one) * Character.getNumericValue(two);
    }
    private String defineFirstNumber() {

        if (person.getGender().toUpperCase().equals(MALE)
                && person.isForeignResidentInRomania()) {
            return "7";
        } else if (person.getGender().toUpperCase().equals(FEMALE)
                && person.isForeignResidentInRomania()) {
            return "8";
        } else if (person.isNonResident()) {
            return "9";
        } else if(person.getGender().toUpperCase().equals(MALE)
                && person.getDateOfBirth().isAfter(LocalDate.of(1900, 01, 01))
                && person.getDateOfBirth().isBefore(LocalDate.of(1999, 12, 31))
        ){
            return "1";
        } else if (person.getGender().toUpperCase().equals(FEMALE)
                && person.getDateOfBirth().isAfter(LocalDate.of(1900, 01, 01))
                && person.getDateOfBirth().isBefore(LocalDate.of(1999, 12, 31))
        ) {
            return "2";
        } else if (person.getGender().toUpperCase().equals(MALE)
                && person.getDateOfBirth().isAfter(LocalDate.of(1800, 01, 01))
                && person.getDateOfBirth().isBefore(LocalDate.of(1899, 12, 31))
        ) {
            return "3";
        } else if (person.getGender().toUpperCase().equals(FEMALE)
                && person.getDateOfBirth().isAfter(LocalDate.of(1800, 01, 01))
                && person.getDateOfBirth().isBefore(LocalDate.of(1899, 12, 31))
        ) {
            return "4";
        } else if (person.getGender().toUpperCase().equals(MALE)
                && person.getDateOfBirth().isAfter(LocalDate.of(2000, 01, 01))
                && person.getDateOfBirth().isBefore(LocalDate.of(2099, 12, 31))
        ) {
            return "5";
        } else if (person.getGender().toUpperCase().equals(FEMALE)
                && person.getDateOfBirth().isAfter(LocalDate.of(2000, 01, 01))
                && person.getDateOfBirth().isBefore(LocalDate.of(2099, 12, 31))
        ) {
            return "6";
        } else {return "9";}
    }

    private String addLeadingZero( String text) {
        return text.length() == 2 ? text : "0" + text;
    }
    public long getCnp() {
        return cnp;
    }
}