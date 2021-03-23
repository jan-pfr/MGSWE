package Aufgabe1;

import java.lang.reflect.*;
import java.util.*;

public class FieldExtractor{
    private final Integer begin;
    private final Integer end;
    private String targetPropertyName;

    public FieldExtractor(Integer _begin,Integer _end,String _target){
        this.begin = _begin;
        this.end = _end;
        this.targetPropertyName = _target;

    }
    public void extractFiled(String line, Object targetObject){
        String value = line.substring(begin, end - begin -1);
        setValue(targetObject, value);
    }
    private List<String> setValue(Object targetObject, String value){
        Field[] fields = targetObject.getClass().getDeclaredFields();
        List<String> actualFieldNames = getFieldNames(fields);
        return actualFieldNames;

    }
    private List<String> getFieldNames(Field[] fields) {
        List<String> fieldNames = new ArrayList<>();
        for (Field field : fields)
            fieldNames.add(field.getName());
        return fieldNames;
    }

}
