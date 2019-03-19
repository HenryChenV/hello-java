package cn.chenhenry.java;

public class StringTest {

    public void testSubString() {
        String phone = null;

        phone = "13912345678";
        System.out.println("0-11: " + phone.substring(0, 11));
        System.out.println("11-: " + phone.substring(11));

        phone = "13912345678123";
        System.out.println("0-11: " + phone.substring(0, 11));
        System.out.println("11-: " + phone.substring(11));
    }

    public static void main(String[] args) {
        StringTest stringTest = new StringTest();
        stringTest.testSubString();
    }

}
