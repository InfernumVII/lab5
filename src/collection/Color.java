package collection;

/**
 * Перечисление, представляющее возможные цвета дракона.
 */
public enum Color {
    YELLOW,
    ORANGE,
    WHITE,
    BROWN;
    /**
     * Возвращает массив строковых представлений всех возможных цветов.
     *
     * @return массив строковых представлений цветов.
     */
    public static String[] getStringColors(){
        Color[] colors = Color.values();
        String[] colorNames = new String[colors.length];
        for (int i = 0; i < colors.length; i++) {
            colorNames[i] = colors[i].name();
        }
        return colorNames;
    }
}