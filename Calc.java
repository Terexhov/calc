import java.util.Scanner;

public class Calc {
    public static void main(String[] args) {

        Converter converter = new Converter();
        String[] actions = {"+", "-", "/", "*"};
        String[] regexActions = {"\\+", "-", "/", "\\*"};
        Scanner scn = new Scanner(System.in);
        System.out.print("Введите выражение, состоящее из 2 римских или 2 арабских чисе: ");
        String exp = scn.nextLine();

        int actionIndex=-1;
        for (int i = 0; i < actions.length; i++) {
            if(exp.contains(actions[i])){
                actionIndex = i;
                break;
            }
        }
        if(actionIndex==-1){
            System.out.println("Некорректное выражение");
            return;
        }

        String[] data = exp.split(regexActions[actionIndex]);
        if(converter.isRim(data[0]) == converter.isRim(data[1])){
            int a,b;
            boolean isRim = converter.isRim(data[0]);
            if(isRim){
                a = converter.rimToInt(data[0]);
                b = converter.rimToInt(data[1]);

            }else{

                a = Integer.parseInt(data[0]);
                b = Integer.parseInt(data[1]);
            }
            int result;
            switch (actions[actionIndex]){
                case "+":
                    result = a+b;
                    break;
                case "-":
                    result = a-b;
                    break;
                case "*":
                    result = a*b;
                    break;
                default:
                    result = a/b;
                    break;
            }
            if(isRim){
                System.out.println(converter.intToRim(result));
            }
            else{
                System.out.println(result);
            }
        }else{
            System.out.println("Числа должны быть в одном формате");
        }


    }
}
