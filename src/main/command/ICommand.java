package src.main.command;
import main.controller.Context;

public interface ICommand {
    public void execute(Context context);
    public Object getResult();
}
