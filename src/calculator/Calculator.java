package test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.lang.RuntimeException;

public class Calculator {
    private static Number calculate(Number a, String op, Number b) {
        if (a.type.equals(b.type)) {
            switch (op) {
                case "+":
                    return a.add(b);
                case "-":
                    return a.sub(b);
                case "*":
                    return a.mul(b);
                case "/":
                    return a.div(b);
                default:
                    throw new RuntimeException("Неизвестная операция");
            }
        } else {
            throw new RuntimeException("Разные типы цифр");
        }
    }

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str;

        while (true) {
            try {
                str = reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException("Неверный ввод");
            }

            String[] expr = str.split("\\s+");

            if (expr.length != 3) {
                throw new RuntimeException("Неверный формат выражения");
            }

            Number a = NumberFactory.getNumber(expr[0]);
            String op = expr[1];
            Number b = NumberFactory.getNumber(expr[2]);

            Number c = calculate(a, op, b);

            System.out.println(c);
        }
    }
}
