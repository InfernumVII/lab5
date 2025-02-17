package commands;

import managers.DragonManager;

/**
 * Команда для вывода информации о коллекции.
 * Реализует интерфейс {@link Command}.
 */
public class InfoCommand implements Command {
    private DragonManager dragonManager;
    /**
     * Конструктор команды InfoCommand.
     *
     * @param dragonManager объект {@link DragonManager} для управления коллекцией драконов.
     */
    public InfoCommand(DragonManager dragonManager){
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
     * Выполняет команду вывода информации о коллекции.
     *
     * @param arg аргумент команды (в данной команде не используется).
     */
    @Override
    public void execute(String arg){
        System.out.println("Тип коллекции: " + dragonManager.getTypeName());
        System.out.println("Дата инициализации: " + dragonManager.getInitializationDate());
        System.out.println("Количество элементов: " + dragonManager.getDragonSet().size());
    }

    /**
     * Возвращает описание команды.
     *
     * @return строковое описание команды.
     */
    @Override
    public String getDescription(){
        return "вывод информации о коллекции.";
    }
    
}
