package it.scantamburloenrico.proxy;

import java.util.Locale;

/**
 *
 * @author Enrico Scantamburlo
 */
public class Main {

    public static void main(String... args) {
        System.out.println("Run the tests!!!");

    }

    public static String cheer(Person p) {
        return String.format(Locale.US, "Hello %s!", p.getName());
    }

}
