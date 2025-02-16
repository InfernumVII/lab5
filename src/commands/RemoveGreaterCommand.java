package commands;

import java.util.Scanner;

import collection.Dragon;
import managers.DragonManager;
import utility.ConsoleInputHandler;


/**
 * Команда для удаления всех элементов коллекции, превышающих заданный по координатам.
 * Реализует интерфейс {@link Command}.
 */
public class RemoveGreaterCommand implements Command {

    private DragonManager dragonManager;
    private Scanner scanner;

    /**
     * Конструктор команды RemoveGreaterCommand.
     *
     * @param dragonManager объект {@link DragonManager} для управления коллекцией драконов.
     * @param scanner объект {@link Scanner} для ввода данных пользователем.
     */
    public RemoveGreaterCommand(DragonManager dragonManager, Scanner scanner){
        this.dragonManager = dragonManager;
        this.scanner = scanner;
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
     * Выполняет команду удаления всех драконов, превышающих заданный по координатам.
     *
     * @param arg аргумент команды (в данной команде не используется).
     */
    @Override
    public void execute(String arg){
        System.out.println("Введите координаты элемента: ");
        ConsoleInputHandler consoleInputHandler = new ConsoleInputHandler(scanner);
        long x = consoleInputHandler.promptForLong("Введите координату x:", false, -420, Long.MAX_VALUE);
        long y = consoleInputHandler.promptForLong("Введите координату y:", false, Long.MIN_VALUE, 699);
        boolean finded = false;
        for (Dragon dragon : dragonManager.getDragonSet()) {
            if (x + y > dragon.getCoordinates().getX() + dragon.getCoordinates().getY()){
                dragonManager.removeDragon(dragon);
                System.out.println(String.format("Дракон с именем %s и айди %d был удалён", dragon.getName(), dragon.getId()));
                finded = true;
            }
        }
        if (finded == false){
            System.out.println("Драконы для удаления не найдены.");
        }
    }

    /**
     * Возвращает описание команды.
     *
     * @return строковое описание команды.
     */
    @Override
    public String getDescription(){
        return "удалить из коллекции все элементы, превышающие заданный по координатам";
    }

    /**
     * Возвращает строковое представление аргумента команды.
     *
     * @return строковое представление аргумента команды.
     */
    @Override
    public String stringArgument(){
        return "{element}";
    }
    
}
