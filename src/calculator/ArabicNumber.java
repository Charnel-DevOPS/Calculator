package calculator;

class ArabicNumber extends Number { //расширяемся от абстрактного класса Number
    ArabicNumber(String number) {
        this.number = Integer.parseInt(number); //получаем арабские цифры
        type = "arabic"; // определяем тип для арабских цифр
    }

    ArabicNumber(int number) {
        this.number = number;
        type = "arabic"; //переводим в int значение String типа arabic
    }

    @Override
    public String toString() { return Integer.toString(number); }
}
