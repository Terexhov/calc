import java.util.Scanner;

public class Calc {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Введите выражение из 2 римских или 2 арабских чисел: ");
        String exp = scn.nextLine();

        try {
            String result = calc(exp);
            System.out.println("Результат: " + result);
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
    public static String calc(String input) {
        Converter converter = new Converter();
        String[] operands = input.split("[+\\-*/]");

        if (operands.length != 2) {
            throw new IllegalArgumentException("Допустимо только два числа.");
        }
        String[] data = input.split("[+\\-*/]");
        if (converter.isRim(data[0]) == converter.isRim(data[1])) {
            int a, b;
            boolean isRim = converter.isRim(data[0]);
            if (isRim) {
                a = converter.rimToInt(data[0]);
                b = converter.rimToInt(data[1]);
            } else {
                a = Integer.parseInt(data[0]);
                b = Integer.parseInt(data[1]);
            }
            int result;
            switch (input.replaceAll("[^+\\-*/]", "")) {
                case "+":
                    result = a + b;
                    break;
                case "-":
                    result = a - b;
                    break;
                case "*":
                    result = a * b;
                    break;
                default:
                    if (b == 0) {
                        throw new IllegalArgumentException("Делить на 0 нельзя.");
                    }
                    result = a / b;
                    break;
            }
            if (isRim) {
                if (result <= 0) {
                    throw new IllegalArgumentException("В римской системе нет нуля и отрицательных чисел. Попробуйте еще раз!");
                }
                return converter.intToRim(result);
            } else {
                return String.valueOf(result);
            }
        } else {
            throw new IllegalArgumentException("Числа должны быть в одном формате");
        }
    }
}
