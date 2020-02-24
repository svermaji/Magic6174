package com.sv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Magic6174 {

    public static String MAGIC6174 = "6174";
    public static int ALLOW_DIGITS = 4;

    public static void main (String[] args) {
        new Magic6174 ();
    }

    public Magic6174 () {
        init ();
    }

    private void init () {
        String[] nums = {"2323", "0000", "abcd", "xx", "aa", "66", "111", "1111", "0023", "5923", "4675", "9998", "2378", "9888"};
        List<String> ignored = new ArrayList<> ();

        for (String num : nums) {
            if (validate (num)) {
                System.out.println ("----------------------------------");
                System.out.println ("Processing number: " + num);
                startProcessing (num);
            } else {
                ignored.add (num);
            }
        }

        if (ignored.size () > 0) {
            System.out.println ("----------------------------------");
            System.out.println ("Ignored inputs: " + ignored);
            System.out.println ("All inputs must follow below rules:");
            System.out.println ("* Only number should be present.");
            System.out.println ("* Number should be 4 digit in length.");
            System.out.println ("* Number must contain two different digits.");
            System.out.println ("* Any digit cannot be repeated more than two times.");
        }

    }

    private boolean validate (String num) {
        return isNumber (num) && lenCheck (num) && repeatCheck (num);
    }

    private boolean isNumber (String num) {
        try {
            Integer.parseInt (num);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean lenCheck (String num) {
        return num.length () == ALLOW_DIGITS;
    }

    private boolean repeatCheck (String num) {
        char[] chars = num.toCharArray ();
        for (char c : chars) {
            if (num.chars ().filter (ch -> ch == c).count () > 2)
                return false;
        }

        return true;
    }

    private void startProcessing (String num) {

        do {
            ArrangeNum arrangeNum = new ArrangeNum (num);
            System.out.println (arrangeNum.getDesc () + " - " + arrangeNum.getAsc () + " = " + arrangeNum.getDiff ());
            num = arrangeNum.getDiff ();
        } while (!num.equals (MAGIC6174));
        ArrangeNum arrangeNum = new ArrangeNum (num);
        System.out.println (arrangeNum.getDesc () + " - " + arrangeNum.getAsc () + " = " + arrangeNum.getDiff ());
    }
}

class ArrangeNum {
    private String asc, desc, diff;

    public ArrangeNum (String num) {
        splitNum (num);
    }

    private void splitNum (String numStr) {
        char[] chars = numStr.toCharArray ();
        Arrays.sort (chars);
        String sorted = new String (chars);
        asc = sorted;
        desc = new StringBuilder (sorted).reverse ().toString ();
        diff = String.valueOf (Integer.parseInt (desc) - Integer.parseInt (asc));
    }

    public String getAsc () {
        return asc;
    }

    public String getDesc () {
        return desc;
    }

    public String getDiff () {
        return diff;
    }
}
