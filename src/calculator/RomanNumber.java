package calculator;

import java.util.TreeMap;
import java.lang.RuntimeException;

public class RomanNumber extends Number {
    private final static TreeMap<Integer, String> tree = new TreeMap<>(); //коллекция из

    static {

        tree.put(10, "X");
        tree.put(9, "IX");
        tree.put(5, "V");
        tree.put(4, "IV");
        tree.put(1, "I");
        tree.put(0, "0");
    }

    RomanNumber(String number) {
        if (number.matches("^(X|IX|IV|V?I{0,3})$")) { // проверяем совпадение вводимых данных,
                                                            //передаем аргумент типа String
            this.number = toArabic(number);
            type = "roman";
        } else {
            throw new RuntimeException("Неверное число");
        }
    }

    RomanNumber(int number) {           //передаем значение типа String в int
        this.number = number;
        type = "roman";
    }

    private static String toRoman(int number) {
        int l =  tree.floorKey(number);
        if (number == l) {
            return tree.get(number);
        }
        return tree.get(l) + toRoman(number-l);
    }

    private static int toArabic(String roman) {
        if (roman.isEmpty()) return 0;
        if (roman.startsWith("X")) return 10 + toArabic(roman.substring(1));
        if (roman.startsWith("IX")) return 9 + toArabic(roman.substring(2));
        if (roman.startsWith("V")) return 5 + toArabic(roman.substring(1));
        if (roman.startsWith("IV")) return 4 + toArabic(roman.substring(2));
        if (roman.startsWith("I")) return 1 + toArabic(roman.substring(1));
        throw new RuntimeException("Неверное значение");
    }

    @Override
    public String toString() { return toRoman(number); }
}