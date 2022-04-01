package main.command;
import main.controller.Context;

public interface ICommand {

    void execute(Context context);
    Object getResult();
}
