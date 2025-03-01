package commands;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import managers.CommandManager;

/**
 * Команда для выполнения скрипта из указанного файла.
 * Реализует интерфейс {@link Command}.
 */
public class ExecuteSciptCommand implements Command {
    private CommandManager commandManager;

    /**
     * Конструктор команды ExecuteSciptCommand.
     *
     * @param commandManager объект {@link CommandManager} для управления выполнением команд.
     */
    public ExecuteSciptCommand(CommandManager commandManager){
        this.commandManager = commandManager;
    }

    /**
     * Проверяет, имеет ли команда аргументы.
     *
     * @return возвращает {@code true}, так как команда требует указания имени файла.
     */
    @Override
    public boolean isHasArgs(){
        return true;
    }

    /**
     * Выполняет команду выполнения скрипта из указанного файла.
     * Читает команды из файла и выполняет их последовательно.
     *
     * @param arg имя файла, содержащего команды для выполнения.
     */
    @Override
    public void execute(String arg){
        System.out.println(String.format("Запуск команд из файла: %s", arg));
        try (FileInputStream file = new FileInputStream(arg)) {
            
            Scanner scanner = new Scanner(file);
            Scanner previousScanner = commandManager.getScanner();
        
            commandManager.setScanner(scanner);
            //commandManager.setInputIsIn(true);
            
            while (scanner.hasNextLine()) {
                String command = scanner.nextLine().trim();
                //System.out.println("> " + command); 
                String[] commanda = CommandManager.parseCommand(command);
                if (commanda != null){
                    commandManager.executeCommand(commanda[0], commanda[1]); 
                }
                
            }
            
            commandManager.setScanner(previousScanner);
            System.out.println("Все команды были выполнены");
            //commandManager.setInputIsIn(false);

        } catch (IOException e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }
        
        
    }

    /**
     * Возвращает описание команды.
     *
     * @return строковое описание команды.
     */
    @Override
    public String getDescription(){
        return "считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.";
    }

    /**
     * Возвращает строковое представление аргумента команды.
     *
     * @return строковое представление аргумента команды (имя файла).
     */
    @Override
    public String stringArgument(){
        return "file_name";
    }
    
}
