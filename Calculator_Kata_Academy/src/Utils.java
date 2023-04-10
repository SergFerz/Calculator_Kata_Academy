import java.util.HashMap;
import java.util.Map;

public class Utils {

    public static String fromIntToRoman(Integer number) throws Exception {
        if (number <= 0) {
            throw new Exception("в римской системе нет отрицательных чисел");
        }
        String[] strings = {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] numbers = {100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            while (number >= numbers[i]) {
                number = number - numbers[i];
                result.append(strings[i]);
            }
        }
        return result.toString();
    }

    public static int fromRomanToInt(String roman) throws Exception {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        int result = 0;
        int prev = 0;
        for (int i = roman.length()-1; i >= 0; i--) {
            try {
                int current = map.get(roman.charAt(i));
            if (current >= prev) {
                result = result + current;
            } else {
                result = result - current;
            }
            prev = current;
            } catch (Exception ex) {
                throw new Exception("формат математической операции не удовлетворяет заданию");
            }
        }
        return result;
    }
}
