package commands;
import collection.Dragon;
import managers.DragonManager;
import utility.ArgHandler;
import utility.ConsoleInputHandler;

/**
 * Команда для удаления элемента коллекции по его ID.
 * Реализует интерфейс {@link Command}.
 */
public class RemoveByIdCommand implements Command {

    private DragonManager dragonManager;
    /**
     * Конструктор команды RemoveByIdCommand.
     *
     * @param dragonManager объект {@link DragonManager} для управления коллекцией драконов.
     */
    public RemoveByIdCommand(DragonManager dragonManager){
        this.dragonManager = dragonManager;
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
     * Выполняет команду удаления дракона по его ID.
     *
     * @param arg строка, содержащая ID дракона.
     */
    @Override
    public void execute(String arg){
        if (ArgHandler.checkArgForInt(arg)){
            int id = Integer.parseInt(arg);
            Dragon dragon = dragonManager.returnDragonById(id);
            if (dragon != null){
                dragonManager.removeDragon(dragon);
                ConsoleInputHandler.printIfInputIsIn("Дракон удалён.");
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
        return "удалить элемент из коллекции по его id";
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
