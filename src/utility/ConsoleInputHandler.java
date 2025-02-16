package utility;
import java.util.Scanner;


/**
 * Класс для обработки ввода данных с консоли.
 * Предоставляет методы для запроса и валидации различных типов данных.
 */
public class ConsoleInputHandler {
    private final Scanner scanner;

    /**
     * Конструктор для инициализации объекта.
     *
     * @param scanner объект {@link Scanner}, используемый для чтения ввода.
     */
    public ConsoleInputHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Запрашивает у пользователя строковое значение.
     *
     * @param prompt сообщение, которое выводится пользователю.
     * @param allowNull разрешает ли метод возвращать пустую строку.
     * @return введённое пользователем строковое значение.
     */
    public String promtForString(String prompt, boolean allowNull){
        while (true){
            System.out.println(prompt);
            String in = scanner.nextLine();
            if (!allowNull && in.isEmpty()) {
                System.out.println("Значение поля не может быть пустым.");
                continue;
            }
            return in;
        }
        
        
    }

    /**
     * Запрашивает у пользователя целочисленное значение.
     *
     * @param prompt сообщение, которое выводится пользователю.
     * @param allowNull разрешает ли метод возвращать значение по умолчанию (0), если ввод пустой.
     * @param min минимальное допустимое значение (исключительно).
     * @param max максимальное допустимое значение (включительно).
     * @return введённое пользователем целочисленное значение.
     */
    public long promptForLong(String prompt, boolean allowNull, long min, long max){
        while (true) {
            System.out.printf(prompt + "\n", min, max);
            String inString = scanner.nextLine();
            if (inString.isEmpty()) {
                if (allowNull) {
                    return 0; 
                } else {
                    System.out.println("Значение поля не может быть пустым.");
                    continue;
                }
            }
            try {
                long in = Long.parseLong(inString);

                if (in <= min || in > max) {
                    System.out.printf("Число должно быть между %s и %s.\n", min, max);
                } else {
                    return in; 
                }
            } catch (NumberFormatException e) {
                System.out.println("Поле должно быть числом.");
            }
        }
    }

    /**
     * Запрашивает у пользователя значение с плавающей точкой.
     *
     * @param prompt сообщение, которое выводится пользователю.
     * @param allowNull разрешает ли метод возвращать значение по умолчанию (0f), если ввод пустой.
     * @param min минимальное допустимое значение (исключительно).
     * @param max максимальное допустимое значение (включительно).
     * @return введённое пользователем значение с плавающей точкой.
     */
    public Float promptForFloat(String prompt, boolean allowNull, Float min, Float max){
        while (true) {
            System.out.println(prompt);
            String inString = scanner.nextLine();
            if (inString.isEmpty()) {
                if (allowNull) {
                    return 0f; 
                } else {
                    System.out.println("Значение поля не может быть пустым.");
                    continue;
                }
            }
            try {
                Float in = Float.parseFloat(inString);

                if (in <= min || in > max) {
                    System.out.printf("Число должно быть между %s и %s.\n", min, max);
                } else {
                    return in; 
                }
            } catch (NumberFormatException e) {
                System.out.println("Поле должно быть числом.");
            }
        }
    }

    /**
     * Запрашивает у пользователя значение из перечисления.
     *
     * @param prompt сообщение, которое выводится пользователю.
     * @param enums массив строк, представляющих допустимые значения.
     * @param allowNull разрешает ли метод возвращать первое значение из перечисления, если ввод пустой.
     * @return введённое пользователем значение из перечисления.
     */
    public String promptForEnum(String prompt, String[] enums, boolean allowNull){
        String joinedEnums = String.join(", ", enums);
        while (true){
            System.out.println(String.format(prompt, joinedEnums));
            String in = scanner.nextLine();

            if (in.isEmpty()){
                if (allowNull){
                    in = enums[0];
                } else {
                    System.out.println("Значение поля не может быть пустым.");
                    continue;
                }
            }

            boolean isInEnums = false;
            for (String string : enums) {
                if (in.equals(string)){
                    isInEnums = true;
                }
            }
            if (isInEnums == false){
                System.out.println(String.format("Поле должно быть одним из вариантов: (%s)", joinedEnums));
                continue;
            }
            return in;
        }

    }

}
