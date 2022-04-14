package main.logging;

import main.model.EntertainmentProvider;

import java.util.List;
import java.util.Map;

public class Logger {
    // fields
    public static Logger instance;
    String callerName;
    Object result;
    Map<String,Object> additionalInfo;

    public static Logger getInstance(){
        return instance;
    }
    public void logAction(String callerName,Object result){
        //todo

    }
    public void logAction(String callerName,Object result,Map<String,Object> additionalInfo){
        //todo

    }
    public List<LogEntry> getLog(){
        //todo

        return null;
    }
    public void clearLog(){
        //todo

    }
    
}
