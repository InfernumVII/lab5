package utility;

/**
 * Класс для проверки и обработки аргументов команд.
 * Предоставляет методы для проверки типов и диапазонов значений аргументов.
 */
public class ArgHandler {

    /**
     * Проверяет, является ли аргумент целым числом в заданном диапазоне.
     *
     * @param arg строка, содержащая аргумент.
     * @param min минимальное допустимое значение (исключительно).
     * @param max максимальное допустимое значение (включительно).
     * @return {@code true}, если аргумент является целым числом в заданном диапазоне, иначе {@code false}.
     */
    public static boolean checkArgForInt(String arg, int min, int max){
        try {
            int in = Integer.parseInt(arg);

            if (in <= min || in > max) {
                System.out.printf("Число должно быть между %s и %s.\n", min, max);
            } else {
                return true;
            }
        } catch (NumberFormatException e) {
            System.out.println("Аргумент должен быть числом.");
            
        }
        return false;
    }

    /**
     * Проверяет, является ли аргумент целым числом.
     *
     * @param arg строка, содержащая аргумент.
     * @return {@code true}, если аргумент является целым числом, иначе {@code false}.
     */
    public static boolean checkArgForInt(String arg){
        return checkArgForInt(arg, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /**
     * Проверяет, соответствует ли аргумент одному из допустимых значений перечисления.
     *
     * @param arg строка, содержащая аргумент.
     * @param enums массив строк, представляющих допустимые значения.
     * @return {@code true}, если аргумент соответствует одному из допустимых значений, иначе {@code false}.
     */
    public static boolean checkArgForEnumString(String arg, String[] enums){
        String joinedEnums = String.join(", ", enums);
        boolean isInEnums = false;
        for (String string : enums) {
            if (arg.equals(string)){
                isInEnums = true;
            }
        }
        if (isInEnums == false){
            System.out.println(String.format("Аргумент должен быть одним из вариантов: (%s)", joinedEnums));
            return false;
        }
        return true;
        

    }

    /**
     * Проверяет, является ли аргумент числом с плавающей точкой в заданном диапазоне.
     *
     * @param arg строка, содержащая аргумент.
     * @param min минимальное допустимое значение (исключительно).
     * @param max максимальное допустимое значение (включительно).
     * @return {@code true}, если аргумент является числом с плавающей точкой в заданном диапазоне, иначе {@code false}.
     */
    public static boolean checkArgForFloat(String arg, float min, float max){
        try {
            float in = Float.parseFloat(arg);

            if (in <= min || in > max) {
                System.out.printf("Число должно быть между %s и %s.\n", min, max);
            } else {
                return true;
            }
        } catch (NumberFormatException e) {
            System.out.println("Аргумент должен быть числом.");
            
        }
        return false;
    }

    /**
     * Проверяет, является ли аргумент числом с плавающей точкой.
     *
     * @param arg строка, содержащая аргумент.
     * @return {@code true}, если аргумент является числом с плавающей точкой, иначе {@code false}.
     */
    public static boolean checkArgForFloat(String arg){
        return checkArgForFloat(arg, -Float.MAX_VALUE, Float.MAX_VALUE);
    }


} 
