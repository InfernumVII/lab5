package collection;
import java.time.LocalDate;

/**
 * Класс, представляющий сущность дракона.
 * Реализует интерфейс {@link Comparable<Dragon>} для сортировки по ID.
 */
public class Dragon implements Comparable<Dragon> {
    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Long age; //Значение поля должно быть больше 0, Поле не может быть null
    private Color color; //Поле не может быть null
    private DragonType type; //Поле не может быть null
    private DragonCharacter character; //Поле не может быть null
    private DragonHead head;

    /**
     * Конструктор для создания объекта дракона.
     *
     * @param id уникальный идентификатор дракона (должен быть больше 0 и не null).
     * @param name имя дракона (не может быть null или пустой строкой).
     * @param coordinates координаты дракона (не могут быть null).
     * @param creationDate дата создания дракона (не может быть null).
     * @param age возраст дракона (должен быть больше 0 и не null).
     * @param color цвет дракона (не может быть null).
     * @param type тип дракона (не может быть null).
     * @param character характер дракона (не может быть null).
     * @param head голова дракона.
     */
    public Dragon(int id, String name, Coordinates coordinates, LocalDate creationDate, Long age, Color color, DragonType type, DragonCharacter character, DragonHead head) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.age = age;
        this.color = color;
        this.type = type;
        this.character = character;
        this.head = head;
    }

    /**
     * Сравнивает драконов по их ID.
     *
     * @param other другой дракон, с которым сравнивается текущий.
     * @return отрицательное число, если текущий дракон меньше, положительное, если больше, и 0, если равны.
     */
    @Override
    public int compareTo(Dragon other) {
        return Integer.compare(this.id, other.id);
    }

    /**
     * Проверяет, равен ли текущий дракон другому объекту.
     *
     * @param o объект для сравнения с текущим драконом.
     * @return {@code true}, если объекты равны, иначе {@code false}.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dragon dragon = (Dragon) o;

        return id == dragon.id;
    }

    /**
     * Возвращает хэш-код дракона.
     *
     * @return хэш-код дракона.
     */
    @Override
    public int hashCode() {
        return id;
    }

    /**
     * Возвращает строковое представление дракона.
     *
     * @return строковое представление дракона.
     */
    @Override
    public String toString() {
        return String.format("Dragon{id=%d, name='%s', coordinates=%s, creationDate=%s, age=%d, color=%s, type=%s, character=%s, head=%s}",
                id, name, coordinates, creationDate, age, color, type, character, head);
    }
    
    /**
     * Возвращает ID дракона.
     *
     * @return ID дракона.
     */
    public int getId(){
        return id;
    }

    /**
     * Возвращает имя дракона.
     *
     * @return имя дракона.
     */
    public String getName(){
        return name;
    }

    /**
     * Устанавливает ID дракона.
     *
     * @param id новый ID дракона.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Устанавливает имя дракона.
     *
     * @param name новое имя дракона.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Возвращает координаты дракона.
     *
     * @return координаты дракона.
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

    /**
     * Устанавливает координаты дракона.
     *
     * @param coordinates новые координаты дракона.
     */
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    /**
     * Возвращает дату создания дракона.
     *
     * @return дата создания дракона.
     */
    public java.time.LocalDate getCreationDate() {
        return creationDate;
    }

    /**
     * Устанавливает дату создания дракона.
     *
     * @param creationDate новая дата создания дракона.
     */
    public void setCreationDate(java.time.LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Возвращает возраст дракона.
     *
     * @return возраст дракона.
     */
    public Long getAge() {
        return age;
    }

    /**
     * Устанавливает возраст дракона.
     *
     * @param age новый возраст дракона.
     */
    public void setAge(Long age) {
        this.age = age;
    }

    /**
     * Возвращает цвет дракона.
     *
     * @return цвет дракона.
     */
    public Color getColor() {
        return color;
    }

    /**
     * Устанавливает цвет дракона.
     *
     * @param color новый цвет дракона.
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Возвращает тип дракона.
     *
     * @return тип дракона.
     */
    public DragonType getType() {
        return type;
    }

    /**
     * Устанавливает тип дракона.
     *
     * @param type новый тип дракона.
     */
    public void setType(DragonType type) {
        this.type = type;
    }

    /**
     * Возвращает характер дракона.
     *
     * @return характер дракона.
     */
    public DragonCharacter getCharacter() {
        return character;
    }

    /**
     * Устанавливает характер дракона.
     *
     * @param character новый характер дракона.
     */
    public void setCharacter(DragonCharacter character) {
        this.character = character;
    }

    /**
     * Возвращает голову дракона.
     *
     * @return голова дракона.
     */
    public DragonHead getHead() {
        return head;
    }

    /**
     * Устанавливает голову дракона.
     *
     * @param head новая голова дракона.
     */
    public void setHead(DragonHead head) {
        this.head = head;
    }
    

}