package Aufgabe1;

import java.lang.reflect.*;
import java.util.*;

public class FieldExtractor{
    private final Integer begin;
    private final Integer end;
    private String targetPropertyName;

    public FieldExtractor(int _begin,int _end,String _target){
        this.begin = _begin;
        this.end = _end;
        this.targetPropertyName = _target;

    }
    public void extractFiled(String line, Object targetObject){
        String value = line.substring(begin, end);
       // setValue(targetObject, value);
    }
    //hier kommt reflection zum einsatz - LESEN
  //  private Method setValue(Object targetObject, String value){

        //return actualFieldNames;

   // }
}
