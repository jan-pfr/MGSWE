package Aufgabe1;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class ReaderStrategy {
    public String code;
    private Class target;
    private String[] pattern;
    private List<FieldExtractor> fieldExtractor = new ArrayList<>();
    //create a new instance of the class
    public ReaderStrategy (String _code, Class _target, String... _pattern){
        this.code = _code;
        this.target = _target;
        this.pattern = _pattern;
    }
    public void addFieldExtractor(Integer begin, Integer end, String target) throws NoSuchFieldException {
        if(fieldExtractor.contains(target)){
            throw new NoSuchFieldException(target);
        }
        fieldExtractor.add(new FieldExtractor(begin, end, target, this.pattern));
    }
    public Object process(String line) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //.getDeclardConstructor get the constructor of the chosen class.
        // .getInstance() creates an object.
        Object result = target.getDeclaredConstructor().newInstance();
        //for-each loop
        for(FieldExtractor extractor : fieldExtractor){
            extractor.extractFiled(line, result);
        }
        return result;
    }
}
