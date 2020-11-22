package calculator;

import java.lang.RuntimeException;

class NumberFactory {
    // Метод определяет тип цифр

    static Number getNumber(String number) {
        Number num;

        try {
            num = new ArabicNumber(number);
        } catch (NumberFormatException e) {
            num = new RomanNumber(number);
        }

        if (num.number < 1 || num.number > 9) {            // условие итоговое число не больше 10
            throw new RuntimeException("Неподходящее число");
        }

        return num;
    }

    static Number setNumber(int number, String type) {
                                                        // Метод проверяет типы вводимых
                                                        // данных принудительно через аргументы
        switch (type) {                                 //сравниваем типы
            case "arabic":
                return new ArabicNumber(number);        // все арабские цифры
            case "roman":
                return new RomanNumber(number);         // все цифры римские
            default:
                throw new RuntimeException("Неизвестный тип цифр"); //исключение
        }
    }
}
