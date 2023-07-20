package UnitTests;

import dataProvider.DataInput;
import dataProvider.Person;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DataInputTest {

    @Test
    public void testOne() {
        DataInput dataInputOne =
                new DataInput(new Person("male", LocalDate.of(1999,02,25),false,false,33,"001"));
        SoftAssert softAssert = new SoftAssert();
        List<Integer> cnp = fromLettersToIntList(String.valueOf(dataInputOne.getCnp()));

        boolean firstDigitCheck = cnp.get(0) == 1;
        boolean secondDigitCheck = cnp.get(1) == 9;
        boolean thirdDigitCheck = cnp.get(2) == 9;
        boolean fourthDigitCheck = cnp.get(3) == 0;
        boolean fifthDigitCheck = cnp.get(4) == 2;
        boolean sixthDigitCheck = cnp.get(5) == 2;
        boolean seventhDigitCheck = cnp.get(6) == 5;
        boolean eightsDigitCheck = cnp.get(7) == 3;
        boolean ninthDigitCheck = cnp.get(8) == 3;
        boolean tenthDigitCheck = cnp.get(9) == 0;
        boolean eleventhDigitCheck = cnp.get(10) == 0;
        boolean twelfthDigitCheck = cnp.get(11) == 1;
        boolean thirteenthDigitCheck = calculateRemain(229) == 9;



        softAssert.assertTrue(firstDigitCheck, String.format("%s number equals to %d: %s", "First", 1, firstDigitCheck));
        softAssert.assertTrue(secondDigitCheck, String.format("%s number equals to %d: %s", "Second", 9, secondDigitCheck));
        softAssert.assertTrue(thirdDigitCheck, String.format("%s number equals to %d: %s", "Third", 9, thirdDigitCheck));
        softAssert.assertTrue(fourthDigitCheck, String.format("%s number equals to %d: %s", "Fourth", 0, fourthDigitCheck));
        softAssert.assertTrue(fifthDigitCheck, String.format("%s number equals to %d: %s", "Fifth", 2, fifthDigitCheck));
        softAssert.assertTrue(sixthDigitCheck, String.format("%s number equals to %d: %s", "Sixth", 2, sixthDigitCheck));
        softAssert.assertTrue(seventhDigitCheck, String.format("%s number equals to %d: %s", "Seventh", 5, seventhDigitCheck));
        softAssert.assertTrue(eightsDigitCheck, String.format("%s number equals to %d: %s", "Eighths", 3, eightsDigitCheck));
        softAssert.assertTrue(ninthDigitCheck, String.format("%s number equals to %d: %s", "Ninth", 3, ninthDigitCheck));
        softAssert.assertTrue(tenthDigitCheck, String.format("%s number equals to %d: %s", "Tenth", 0, tenthDigitCheck));
        softAssert.assertTrue(eleventhDigitCheck, String.format("%s number equals to %d: %s", "Eleventh", 0, eleventhDigitCheck));
        softAssert.assertTrue(twelfthDigitCheck, String.format("%s number equals to %d: %s", "Twelfth", 1, twelfthDigitCheck));
        softAssert.assertTrue(thirteenthDigitCheck, String.format("%s number equals to %d: %s", "Thirteenth", 6, thirteenthDigitCheck));

        softAssert.assertAll();

    }

    @Test
    public void testTwo() {
        DataInput dataInputTwo =
                new DataInput(new Person("Female", LocalDate.of(2000,01,02),false,false,18,"002"));
        System.out.println(dataInputTwo.getCnp());
    }

    @Test
    public void testThree() {
        DataInput dataInputThree =
                new DataInput(new Person("Female", LocalDate.of(1899,12,30),false,false,52,"003"));
        System.out.println(dataInputThree.getCnp());
    }


    @Test
    public void testFour() {
        DataInput dataInputFour =
                new DataInput(new Person("male", LocalDate.of(1900,01,02),true,false,1,"004"));
        System.out.println(dataInputFour.getCnp());
    }

    @Test
    public void testFive() {
        DataInput dataInputFour =
                new DataInput(new Person("male", LocalDate.of(1800,01,02),false,true,4,"005"));
        System.out.println(dataInputFour.getCnp());
    }

    public List<Integer> fromLettersToIntList(String text) {
        int start = 1;
        List<Integer> intList = new ArrayList<>();
        String[] letterArray = text.split("");
        for (int i = 0; i < letterArray.length; i++) {
            System.out.println(letterArray[i]);
            intList.add(Integer.parseInt(letterArray[i]));
        }
        return intList;
    }

    public int calculateRemain(int l){
        System.out.println( "Remain is: " + l % 11);
        return l % 11 == 10 ? 1 : l % 11;
    }
}
