package src.main.command;
import src.main.controller.Context;

public interface ICommand {

    void execute(Context context);
    long getResult();
}