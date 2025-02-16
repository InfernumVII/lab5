package commands;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import collection.Color;
import collection.Coordinates;
import collection.Dragon;
import collection.DragonCharacter;
import collection.DragonHead;
import collection.DragonType;
import managers.DragonManager;
import utility.ConsoleInputHandler;


/**
 * Команда для добавления нового дракона в коллекцию, если его значение меньше, чем у наименьшего элемента коллекции.
 * Реализует интерфейс {@link Command}.
 */
public class AddIfMinCommand implements Command {

    private Scanner scanner;
    private DragonManager dragonManager;

    /**
     * Конструктор команды AddIfMinCommand.
     *
     * @param scanner        объект {@link Scanner} для считывания пользовательского ввода.
     * @param dragonManager  объект {@link DragonManager} для управления коллекцией драконов.
     */
    public AddIfMinCommand(Scanner scanner, DragonManager dragonManager) {
        this.scanner = scanner;
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
     * Выполняет команду добавления нового дракона в коллекцию, если его значение меньше, чем у наименьшего элемента коллекции.
     * Запрашивает у пользователя данные для создания нового объекта {@link Dragon}.
     *
     * @param arg аргумент команды (в данной команде не используется).
     */
    @Override
    public void execute(String arg){
        System.out.println("Добавление нового дракона.");
        ConsoleInputHandler consoleInputHandler = new ConsoleInputHandler(scanner);
        Integer id = dragonManager.getUniqueId();
        String name = consoleInputHandler.promtForString("Введите имя дракона:", false);
        long x = consoleInputHandler.promptForLong("Введите координату x:", false, -420, Long.MAX_VALUE);
        long y = consoleInputHandler.promptForLong("Введите координату y:", false, Long.MIN_VALUE, 699);
        LocalDate creationDate = LocalDate.now();
        Long age = consoleInputHandler.promptForLong("Введите возраст дракона:", false, 0, Long.MAX_VALUE);
        Color color = Color.valueOf(consoleInputHandler.promptForEnum("Введите цвет дракона: %s", Color.getStringColors(), false));
        DragonType type = DragonType.valueOf(consoleInputHandler.promptForEnum("Введите тип дракона: %s", DragonType.getStringColors(), false));
        DragonCharacter character = DragonCharacter.valueOf(consoleInputHandler.promptForEnum("Введите характер дракона: %s", DragonCharacter.getStringColors(), false));
        Float eyesCount = consoleInputHandler.promptForFloat("Введите кол-во глаз у дракона:", true, -Float.MAX_VALUE, Float.MAX_VALUE);
        Dragon minDragon = Collections.min(dragonManager.getDragonSet(), new Comparator<Dragon>() {
            @Override
            public int compare(Dragon d1, Dragon d2) {
                int xCompare = Long.compare(d1.getCoordinates().getX(), d2.getCoordinates().getX());
                if (xCompare != 0) {
                    return xCompare; 
                }
                return Long.compare(d1.getCoordinates().getY(), d2.getCoordinates().getY());
            }
        });
        if (x + y < minDragon.getCoordinates().getX() + minDragon.getCoordinates().getY()){
            dragonManager.addDragon(new Dragon(id, name, new Coordinates(x, y), creationDate, age, color, type, character, new DragonHead(eyesCount)));
            System.out.println("Новый дракон успешно добавлен.");
        } else {
            System.out.println("Ваш дракон имеет большее значение, чем у минимального элемента коллекции.");
        }
        
    }

    /**
     * Возвращает описание команды.
     *
     * @return строковое описание команды.
     */
    @Override
    public String getDescription(){
        return "добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции";
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
