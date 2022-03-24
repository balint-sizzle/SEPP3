package main.controller;
import main.command.ICommand;

public class Controller extends Object{
    Context context;
    public Controller(){
        this.context = new Context();
    }

    public void runCommand(ICommand command){
        command.execute(this.context);
    }
}
