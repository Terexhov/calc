import java.util.TreeMap;

class Converter {
    TreeMap<Character, Integer> rimKeyMap = new TreeMap<>();
    TreeMap<Integer, String> arabKeyMap = new TreeMap<>();

    public Converter() {
        rimKeyMap.put('0', 0);
        rimKeyMap.put('I', 1);
        rimKeyMap.put('V', 5);
        rimKeyMap.put('X', 10);
        rimKeyMap.put('L', 50);
        rimKeyMap.put('C', 100);
        rimKeyMap.put('D', 500);

        arabKeyMap.put(1000, "M");
        arabKeyMap.put(900, "CM");
        arabKeyMap.put(500, "D");
        arabKeyMap.put(400, "CD");
        arabKeyMap.put(100, "C");
        arabKeyMap.put(90, "XC");
        arabKeyMap.put(50, "L");
        arabKeyMap.put(40, "XL");
        arabKeyMap.put(10, "X");
        arabKeyMap.put(9, "IX");
        arabKeyMap.put(5, "V");
        arabKeyMap.put(4, "IV");
        arabKeyMap.put(1, "I");
    }
    public boolean isRim(String number) {
        return rimKeyMap.containsKey(number.charAt(0));
    }
    public String intToRim(int number) {
        if (number <= 0) {
            throw new
                    IllegalArgumentException("В римской системе нет нуля и отрицательных чисел. Попробуйте еще раз!");
        }
        String rim = "";
        int arabKey;
        do {
            arabKey = arabKeyMap.floorKey(number);
            rim += arabKeyMap.get(arabKey);
            number -= arabKey;
        } while (number != 0);
        return rim;
    }
    public int rimToInt(String s) {
        int end = s.length() - 1;
        char[] arr = s.toCharArray();
        int arab;
        int result = rimKeyMap.get(arr[end]);

        if (result <= 0 || result > 10) {
            throw new IllegalArgumentException("В римской системе числа должны быть от 1 до 10.");
        }
        for (int i = end - 1; i >= 0; i--) {
            arab = rimKeyMap.get(arr[i]);
            if (arab < rimKeyMap.get(arr[i + 1])) {
                result -= arab;
            } else {
                result += arab;
            }
        }
        return result;
    }
}
