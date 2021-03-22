package Aufgabe1;

import java.io.*;
public class FieldExtractor{
    private final Integer begin;
    private final Integer end;
    private String targetPropertyName;
    private File file;

    public FieldExtractor(Integer _begin,Integer _end,String _target){
        this.begin = _begin;
        this.end = _end;
        this.targetPropertyName = _target;
        file = new File(targetPropertyName);

    }
    public void extractFiled(String line) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        while ((st = br.readLine()) != null)
            System.out.println(st);
    }

}
