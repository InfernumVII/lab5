package commands;
import java.time.LocalDate;

import collection.Color;
import collection.Coordinates;
import collection.Dragon;
import collection.DragonCharacter;
import collection.DragonHead;
import collection.DragonType;
import managers.CommandManager;
import managers.DragonManager;
import utility.ConsoleInputHandler;


/**
 * Команда для добавления нового дракона в коллекцию.
 * Реализует интерфейс {@link Command}.
 */
public class AddCommand implements Command {
    private DragonManager dragonManager;
    private CommandManager commandManager;

    /**
     * Конструктор команды AddCommand.
     *
     * @param commandManager объект {@link CommandManager} для управления командами.
     * @param dragonManager  объект {@link DragonManager} для управления коллекцией драконов.
     */
    public AddCommand(CommandManager commandManager, DragonManager dragonManager) {
        this.commandManager = commandManager;
        this.dragonManager = dragonManager;
    }

    /**
     * Проверяет, имеет ли команда аргументы.
     *
     * @return возвращает {@code false}, так как команда не принимает аргументов.
     */
    @Override
    public boolean isHasArgs(){
        return false;
    }


    /**
     * Выполняет команду добавления нового дракона в коллекцию.
     * Запрашивает у пользователя данные для создания нового объекта {@link Dragon}.
     *
     * @param arg аргумент команды (в данной команде не используется).
     */
    @Override
    public void execute(String arg){

        System.out.println("Добавление нового дракона.");
        ConsoleInputHandler consoleInputHandler = new ConsoleInputHandler(commandManager);
        Integer id = dragonManager.getUniqueId();
        String name = consoleInputHandler.promtForString("Введите имя дракона:", false);
        long x = consoleInputHandler.promptForLong("Введите координату x:", false, -420, Long.MAX_VALUE);
        long y = consoleInputHandler.promptForLong("Введите координату y:", false, Long.MIN_VALUE, 699);
        LocalDate creationDate = LocalDate.now();
        Long age = consoleInputHandler.promptForLong("Введите возраст дракона:", false, 0, Long.MAX_VALUE);
        Color color = consoleInputHandler.promptForEnum("Введите цвет дракона: %s", Color.values(), false);
        DragonType type = consoleInputHandler.promptForEnum("Введите тип дракона: %s", DragonType.values(), false);
        DragonCharacter character = consoleInputHandler.promptForEnum("Введите характер дракона: %s", DragonCharacter.values(), false);
        Float eyesCount = consoleInputHandler.promptForFloat("Введите кол-во глаз у дракона:", true, -Float.MAX_VALUE, Float.MAX_VALUE);
        dragonManager.addDragon(new Dragon(id, name, new Coordinates(x, y), creationDate, age, color, type, character, new DragonHead(eyesCount)));
        System.out.println("Новый дракон успешно добавлен.");
        
    }

    /**
     * Возвращает описание команды.
     *
     * @return строковое описание команды.
     */
    @Override
    public String getDescription(){
        return "добавить новый элемент в коллекцию";
    }
    
}