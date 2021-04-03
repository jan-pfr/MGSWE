package Aufgabe1;

import java.lang.reflect.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FieldExtractor{
    private final Integer begin;
    private final Integer end;
    private String targetPropertyName;
    private String[] patternString;

    public FieldExtractor(int _begin,int _end,String _target, String[] _pattern){
        this.begin = _begin;
        this.end = _end;
        this.targetPropertyName = _target;
        this.patternString = _pattern;

    }
    public void extractFiled(String line, Object targetObject) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        String value = line.substring(begin, end + 1);
        try {
            if (this.targetPropertyName.contains("Move")){
                Pattern pattern = Pattern.compile(patternString[0]);
                Matcher matcher = pattern.matcher(value);
                System.out.println(line+": "+ matcher.matches());
            }
        }catch (Exception e){
            System.out.println(e);
        }
        setValue(targetObject, value);
    }
    //hier kommt reflection zum einsatz - LESEN
    private void setValue(Object targetObject, String value) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = targetObject.getClass().getMethod("set" + targetPropertyName, String.class);
        method.invoke(targetObject, value);
    }
}
