package calculator;

abstract class Number {
    int number;
    String type;

    Number add(Number other) { return NumberFactory.setNumber(number + other.number, type); }
    Number sub(Number other) { return NumberFactory.setNumber(number - other.number, type); }
    Number mul(Number other) { return NumberFactory.setNumber(number * other.number, type); }
    Number div(Number other) { return NumberFactory.setNumber(number / other.number, type); }

    // метод возвращает int и принимает один аргумент типа Object, называемый other
}
