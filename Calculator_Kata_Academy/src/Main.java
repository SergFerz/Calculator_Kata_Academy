import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("Калькулятор умеет выполнять операции сложения, вычитания, умножения и деления");
        System.out.println("с двумя арабскими или римскими цифрами от 1 до 10:");
        System.out.println("a + b, a - b, a * b, a / b");
        System.out.println("Введите выражение:");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String result = Main.calc(input);
        System.out.println(result);
    }

    public static String calc(String input) throws Exception {
        Integer result = 0;
        String[] split = input.trim().split(" ");
        if (split.length != 3) {
            throw new Exception("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
        Number operand1 = new Number(split[0]);
        Number operand2 = new Number(split[2]);
        if (operand1.isRome() != operand2.isRome()) {
            throw new Exception("Используются одновременно разные системы счисления");
        }
        if (operand1.getValue()<1 || operand1.getValue()>10 || operand2.getValue()<1 || operand2.getValue()>10) {
            throw new Exception("формат математической операции не удовлетворяет заданию");
        }
        switch (split[1]) {
            case "+" :
                result = operand1.getValue() + operand2.getValue();
                break;
            case "-" :
                result = operand1.getValue() - operand2.getValue();
                break;
            case "*" :
                result = operand1.getValue() * operand2.getValue();
                break;
            case "/" :
                result = operand1.getValue() / operand2.getValue();
                break;
            default: throw new Exception("строка не является математической операцией");
        }
        if (operand1.isRome()) {
            String romanResult = Utils.fromIntToRoman(result);
            return romanResult;
        }
        return result.toString();
    }
}
