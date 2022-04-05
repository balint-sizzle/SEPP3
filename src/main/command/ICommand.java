package main.command;
import main.controller.Context;

public interface ICommand {

    boolean execute(Context context);
    Object getResult();
}
