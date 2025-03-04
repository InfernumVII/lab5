package utility;
import java.util.Arrays;
import java.util.Scanner;

import managers.CommandManager;


/**
 * Класс для обработки ввода данных с консоли.
 * Предоставляет методы для запроса и валидации различных типов данных.
 */
public class ConsoleInputHandler {
    private Scanner scanner;
    private boolean inputIsIn;

    /**
     * Конструктор для инициализации объекта.
     *
     * @param commandManager объект {@link CommandManager}, используемый для управления командами и их составными.
     */
    public ConsoleInputHandler(CommandManager commandManager) {
        this.scanner = commandManager.getScanner();
        this.inputIsIn = commandManager.isInputIsIn();
    }

    /**
     * Выводит переданное сообщение в консоль, если флаг inputIsIn установлен в true.
     * Используется для вывода при вводе команд через отличные от (System.in) стримы.
     *
     * @param in строка, которая будет выведена в консоль, если inputIsIn == true.
     */
    public void printIfInputIsIn(String in){
        if (inputIsIn){
            System.out.println(in);
        }
        
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
            printIfInputIsIn(in);
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
            printIfInputIsIn(inString);
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
            printIfInputIsIn(inString);
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
     * Запрашивает у пользователя значение из перечисления (enum).
     * Аргумент может быть как строковым представлением значения перечисления (без учета регистра),
     * так и числовым представлением его порядкового номера (начиная с 1).
     *
     * @param <E> тип перечисления.
     * @param prompt сообщение, которое выводится пользователю.
     * @param enums массив значений перечисления.
     * @param allowNull разрешает ли метод возвращать значение по умолчанию (первый элемент перечисления), если ввод пустой.
     * @return введённое пользователем значение из перечисления.
     */
    public <E extends Enum<E>> E promptForEnum(String prompt, E[] enums, boolean allowNull){
        String joinedEnums = Arrays.toString(enums);
        while (true) {
            System.out.println(String.format(prompt, joinedEnums));
            String in = scanner.nextLine();
            printIfInputIsIn(in);
            if (in.isEmpty()){
                if (allowNull){
                    return enums[0];
                } else {
                    System.out.println("Значение поля не может быть пустым.");
                    continue;
                }
            }
            boolean isInEnums = false;
            for (E enu : enums) {
                if (in.equalsIgnoreCase(enu.name()) || in.equals(Integer.toString(enu.ordinal() + 1))) {
                    return enu;
                }
            }
            if (isInEnums == false){
                System.out.println(String.format("Поле должно быть одним из вариантов: (%s)", joinedEnums));
                continue;
            }
            


        }

    }

}
