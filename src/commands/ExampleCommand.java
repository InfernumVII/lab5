package commands;
public class ExampleCommand implements Command {


    @Override
    public boolean isHasArgs(){
        return false;
    }
    @Override
    public void execute(String arg){
    }

    @Override
    public String getDescription(){
        return "desc";
    }
    
}
