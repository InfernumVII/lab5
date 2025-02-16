package commands;
import java.util.Scanner;

import collection.Color;
import collection.Coordinates;
import collection.Dragon;
import collection.DragonCharacter;
import collection.DragonHead;
import collection.DragonType;
import managers.DragonManager;
import utility.ArgHandler;
import utility.ConsoleInputHandler;


/**
 * Команда для обновления значения элемента коллекции по его ID.
 * Реализует интерфейс {@link Command}.
 */
public class UpdateCommand implements Command {
    private DragonManager dragonManager;
    private Scanner scanner;

    /**
     * Конструктор команды UpdateCommand.
     *
     * @param dragonManager объект {@link DragonManager} для управления коллекцией драконов.
     * @param scanner объект {@link Scanner} для ввода данных пользователем.
     */
    public UpdateCommand(DragonManager dragonManager, Scanner scanner){
        this.dragonManager = dragonManager;
        this.scanner = scanner;
    }

    /**
     * Проверяет, имеет ли команда аргументы.
     *
     * @return возвращает {@code true}, так как команда требует ID дракона в качестве аргумента.
     */
    @Override
    public boolean isHasArgs(){
        return true;
    }

    /**
     * Выполняет команду обновления дракона по его ID.
     *
     * @param arg строка, содержащая ID дракона.
     */
    @Override
    public void execute(String arg){
        if (ArgHandler.checkArgForInt(arg)){
            int id = Integer.parseInt(arg);
            Dragon dragon = dragonManager.returnDragonById(id);
            if (dragon != null){
                
                System.out.println(String.format("Начинаем изменение дракона с ID-%d и именем %s", id, dragon.getName()));

                ConsoleInputHandler consoleInputHandler = new ConsoleInputHandler(scanner);
                String name = consoleInputHandler.promtForString("Введите имя дракона:", false);
                dragon.setName(name);
                long x = consoleInputHandler.promptForLong("Введите координату x:", false, -420, Long.MAX_VALUE);
                long y = consoleInputHandler.promptForLong("Введите координату y:", false, Long.MIN_VALUE, 699);
                dragon.setCoordinates(new Coordinates(x, y));
                Long age = consoleInputHandler.promptForLong("Введите возраст дракона:", false, 0, Long.MAX_VALUE);
                dragon.setAge(age);
                Color color = Color.valueOf(consoleInputHandler.promptForEnum("Введите цвет дракона: %s", Color.getStringColors(), false));
                dragon.setColor(color);
                DragonType type = DragonType.valueOf(consoleInputHandler.promptForEnum("Введите тип дракона: %s", DragonType.getStringColors(), false));
                dragon.setType(type);
                DragonCharacter character = DragonCharacter.valueOf(consoleInputHandler.promptForEnum("Введите характер дракона: %s", DragonCharacter.getStringColors(), false));
                dragon.setCharacter(character);
                Float eyesCount = consoleInputHandler.promptForFloat("Введите кол-во глаз у дракона:", true, -Float.MAX_VALUE, Float.MAX_VALUE);
                dragon.setHead(new DragonHead(eyesCount));

                System.out.println(String.format("Дракон с ID-%d успешно обновлён!", id));
            }
        }
    }

    /**
     * Возвращает описание команды.
     *
     * @return строковое описание команды.
     */
    @Override
    public String getDescription(){
        return "обновить значение элемента коллекции, id которого равен заданному";
    }

    /**
     * Возвращает строковое представление аргумента команды.
     *
     * @return строковое представление аргумента команды.
     */
    @Override
    public String stringArgument(){
        return "id";
    }
    
}
