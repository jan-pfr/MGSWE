package Aufgabe1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
public class Reader {

    private List process(String file){
        String a_line;
        List list = new ArrayList<Object>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            while ((a_line = br.readLine()) != null){
                processLine(a_line, list);
            }
        }catch (IOException e){
           throw new RuntimeException(e);
        }
        return list;
    }
    private void processLine(String line, List result){
        if (isComment(line)) return;
        if (isBlank(line)) return;
        String typeCode = getTypeCode(line);

    }
    private boolean isComment(String line){
        return line.startsWith("#");
    }
    private boolean isBlank(String line){
        return line.isBlank();
    }
    private String getTypeCode(String line){
        return line.substring(0,4);
    }

}
