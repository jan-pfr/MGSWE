package Aufgabe1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
public class Reader {
    //Hashmap, in which strategies are stored. The string is the index.
    HashMap<String, ReaderStrategy> strategies = new HashMap<>();
    // reads the File
    public List process(String file){
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
    //examines a line, and depending on what's in it, it does something
    private void processLine(String line, List result) throws Exception {
        if (isComment(line)) return;
        if (isBlank(line)) return;
        String typeCode = getTypeCode(line); //reads the first four chars
        ReaderStrategy strategy = strategies.get(typeCode); //Hier wird ein Objekt referenziert, da das Objekt in der Hashmap bereit existiert.
        if(null == strategy){
            throw new Exception("Unable to find strategy");
        }
        //hier wird die Zeile mit der entsprechenden Regel verarbeitet
        result.add(strategy.process(line));

    }
    //helper method
    private boolean isComment(String line){
        return line.startsWith("#");
    }
    //helper method
    private boolean isBlank(String line){ return line.isBlank();}
    //helper method
    private String getTypeCode(String line){
        return line.substring(0,4);
    }
    //adding a strategy to the Hashtable "strategies"
    public void addStrategy(Aufgabe1.ReaderStrategy arg){
        strategies.put(arg.code, arg);
    }

}
