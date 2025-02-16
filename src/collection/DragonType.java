package collection;

/**
 * Перечисление, представляющее возможные типы дракона.
 */
public enum DragonType {
    WATER,
    UNDERGROUND,
    AIR,
    FIRE;
    /**
     * Возвращает массив строковых представлений всех возможных типов дракона.
     *
     * @return массив строковых представлений типов дракона.
     */
    public static String[] getStringColors() {
        DragonType[] types = DragonType.values();
        String[] typeNames = new String[types.length];
        for (int i = 0; i < types.length; i++) {
            typeNames[i] = types[i].name();
        }
        return typeNames;
    }
}