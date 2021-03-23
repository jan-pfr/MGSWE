package Aufgabe1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
public class Reader {
    HashMap<String, Object> strategies = new HashMap<String, Object>();
    private List process(String file){
        List list = new ArrayList<Object>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String a_line;
            while ((a_line = br.readLine()) != null){
                processLine(a_line, list);
            }
        }catch (Exception e){
           throw new RuntimeException(e);
        }
        return list;
    }
    private void processLine(String line, List result) throws Exception {
        if (isComment(line)) return;
        if (isBlank(line)) return;
        String typeCode = getTypeCode(line);
        ReaderStrategy strategy = new ReaderStrategy(typeCode);
        if(null == strategy){
            throw new Exception("Unable to find strategy");
        }
        result.add(strategy.process(line));

    }
    private boolean isComment(String line){
        return line.startsWith("#");
    }
    private boolean isBlank(String line){ return line.isBlank();}
    private String getTypeCode(String line){
        return line.substring(0,4);
    }
    public void addStrategy(ReaderStrategy arg){
        strategies.put(arg.code, arg);
    }

}
