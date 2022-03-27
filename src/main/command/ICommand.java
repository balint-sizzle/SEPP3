package main.command;

public interface ICommand {
    public void execute(main.controller.Context context);
    public Object getResult();
}
