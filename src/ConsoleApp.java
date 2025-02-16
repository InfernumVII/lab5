import java.util.List;
import java.util.Scanner;

import commands.AddCommand;
import commands.AddIfMinCommand;
import commands.ClearCommand;
import commands.CountByTypeCommand;
import commands.ExecuteSciptCommand;
import commands.ExitCommand;
import commands.FilterByCharacterCommmand;
import commands.FilterLessThanHeadCommand;
import commands.HelpCommand;
import commands.HistoryCommand;
import commands.InfoCommand;
import commands.RemoveByIdCommand;
import commands.RemoveGreaterCommand;
import commands.SaveCommand;
import commands.ShowCommand;
import commands.UpdateCommand;
import managers.CommandManager;
import managers.DragonManager;
import utility.CSV;


/**
 * Основной класс приложения, отвечающий за взаимодействие с пользователем через консоль.
 * Реализует загрузку данных из файла, регистрацию команд и их выполнение.
 */
public class ConsoleApp {
    /**
     * Точка входа в приложение.
     *
     * @param args аргументы командной строки.
     */
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        

        String fileName = System.getenv("DRAGON_FILE");
        if (fileName == null || fileName.isEmpty()) {
            System.err.println("Ошибка: переменная окружения DRAGON_FILE не задана.");
            System.exit(1); 
        }
        DragonManager dragonManager = new DragonManager();
        try {
            List<String[]> fileData = CSV.read(fileName);
            dragonManager.collectParsedDragons(fileData);
            System.out.println("Коллекция успешно загружена из файла: " + fileName);
        } catch (Exception e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
            System.exit(1); 
        }

        CommandManager manager = new CommandManager();
        manager.registerCommand("help", new HelpCommand(manager));
        manager.registerCommand("info", new InfoCommand(dragonManager));
        manager.registerCommand("show", new ShowCommand(dragonManager));
        manager.registerCommand("add", new AddCommand(scanner, dragonManager));
        manager.registerCommand("update", new UpdateCommand(dragonManager, scanner));
        manager.registerCommand("remove_by_id", new RemoveByIdCommand(dragonManager));
        manager.registerCommand("clear", new ClearCommand(dragonManager));
        manager.registerCommand("save", new SaveCommand(dragonManager));
        manager.registerCommand("execute_script", new ExecuteSciptCommand(manager));
        manager.registerCommand("exit", new ExitCommand());
        manager.registerCommand("add_if_min", new AddIfMinCommand(scanner, dragonManager));
        manager.registerCommand("remove_greater", new RemoveGreaterCommand(dragonManager, scanner));
        manager.registerCommand("history", new HistoryCommand(manager));
        manager.registerCommand("count_by_type", new CountByTypeCommand(dragonManager));
        manager.registerCommand("filter_by_character", new FilterByCharacterCommmand(dragonManager));
        manager.registerCommand("filter_less_than_head", new FilterLessThanHeadCommand(dragonManager));
         
        while (true){
            System.out.print("> ");
            String in = scanner.nextLine();
            String[] parsedCommand = CommandManager.parseCommand(in);
            
            if (parsedCommand != null){
                manager.executeCommand(parsedCommand[0], parsedCommand[1]);
            }
        }
        
        
    }
}