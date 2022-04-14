package main.logging;

import java.util.Map;

public class LogEntry {

    String callerName;
    Object result;
    Map<String,Object> additionalInfo;

    LogEntry(String callerName, Object result, Map<String,Object> additionalInfo){
        this.callerName = callerName;
        this.result = result;
        this.additionalInfo = additionalInfo;

    }
    public String getResult(){
        //todo

        return null;
    }
    public String toString(){
        return "the caller name is " + callerName +
                "the result is " + result +
                "the addition information is " + additionalInfo;
    }
    
}
