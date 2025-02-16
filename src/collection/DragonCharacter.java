package collection;

/**
 * Перечисление, представляющее возможные характеры дракона.
 */
public enum DragonCharacter {
    WISE,
    EVIL,
    CHAOTIC_EVIL,
    FICKLE;

    /**
     * Возвращает массив строковых представлений всех возможных характеров.
     *
     * @return массив строковых представлений характеров.
     */
    public static String[] getStringColors() {
        DragonCharacter[] characters = DragonCharacter.values();
        String[] characterNames = new String[characters.length];
        for (int i = 0; i < characters.length; i++) {
            characterNames[i] = characters[i].name();
        }
        return characterNames;
    }
}