package managers;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

import commands.Command;


/**
 * Класс для управления командами и их выполнением.
 * Реализует хранение, регистрацию, выполнение команд, а также отслеживание истории выполненных команд.
 */
public class CommandManager {
    private Map<String, Command> commands = new HashMap<>();

    private final static int HISTORY_SIZE = 5;
    private Deque<String> history = new ArrayDeque<String>(HISTORY_SIZE);


    /**
     * Разбивает введённую команду на имя команды и её аргумент.
     *
     * @param command строка, содержащая команду и её аргумент.
     * @return массив строк, где первый элемент — имя команды, а второй — аргумент (может быть null).
     */
    public static String[] parseCommand(String command){
        String[] input = command.split(" ");
        String commandName = input[0];
        String commandArg = null;
        if (input.length > 2){
            System.out.println("У команды не может быть больше чем 1 аргумент.");
            return null;
        }
        if (input.length == 2){
            commandArg = input[1];
        } 
        return new String[]{commandName, commandArg};
    }

    /**
     * Регистрирует команду в менеджере.
     *
     * @param name имя команды.
     * @param command объект команды, реализующий интерфейс {@link Command}.
     */
    public void registerCommand(String name, Command command){
        commands.put(name, command);
    }

    /**
     * Выполняет команду, если она зарегистрирована в менеджере.
     *
     * @param name имя команды.
     * @param arg аргумент команды (может быть null).
     */
    public void executeCommand(String name, String arg){
        Command command = commands.get(name);
        if (command != null) {
            if (command.isHasArgs() == true && arg == null){
                System.out.println("У команды должны быть аргументы.");
            }
            else if (command.isHasArgs() == false && arg != null){
                System.out.println("У команды не может быть аргументов.");
            } else {
                command.execute(arg);
                storeCommand(name);
            }
            
        } else {
            System.out.println("Неизвестная команда: " + name);
        }
    }

    /**
     * Добавляет выполненную команду в историю.
     * Если история превышает размер HISTORY_SIZE, удаляет самую старую команду.
     *
     * @param command имя выполненной команды.
     */
    private void storeCommand(String command){
        if (history.size() >= HISTORY_SIZE) {
            history.removeFirst(); 
        }
        history.addLast(command);
    }

    /**
     * Возвращает историю выполненных команд.
     *
     * @return история выполненных команд.
     */
    public Deque<String> getHistory(){
        return history;
    }

    /**
     * Возвращает карту зарегистрированных команд.
     *
     * @return карта зарегистрированных команд.
     */
    public Map<String, Command> getCommands() {
        return commands;
    }

    /**
     * Устанавливает карту зарегистрированных команд.
     *
     * @param commands карта зарегистрированных команд.
     */
    public void setCommands(Map<String, Command> commands) {
        this.commands = commands;
    }

    /**
     * Возвращает максимальный размер истории команд.
     *
     * @return максимальный размер истории команд.
     */
    public static int getHistorySize() {
        return HISTORY_SIZE;
    }

    /**
     * Устанавливает историю выполненных команд.
     *
     * @param history история выполненных команд.
     */
    public void setHistory(Deque<String> history) {
        this.history = history;
    }
    
}
