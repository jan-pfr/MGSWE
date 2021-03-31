package Aufgabe1;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class ReaderStrategy {
    public String code;
    private Class target;
    //In der Liste werden die Regeln gespeichert
    private List<FieldExtractor> fieldExtractor = new ArrayList<>();
    //create a new instance of the class
    public ReaderStrategy (String _code, Class _target){
        this.code = _code;
        this.target = _target;
    }
    //Hier werden die Regel einer Strategie dem Objekt der Strategie hinzugefügt
    public void addFieldExtractor(Integer begin, Integer end, String target) throws NoSuchFieldException {
        if(fieldExtractor.contains(target)){
            throw new NoSuchFieldException(target);
        }
        //FieldExtractor = Ding, was die Regel umsetzt
        fieldExtractor.add(new FieldExtractor(begin, end, target));
    }
    public Object process(String line) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
       //.getDeclardConstructor = gibt den Constructor der target Klasse zurück.
        // .netInstance() macht mithilfe des Konstruktors ein Objekt.
        Object result = target.getDeclaredConstructor().newInstance();
        //for-each schleife
        for(FieldExtractor extractor : fieldExtractor){
            extractor.extractFiled(line, result);
        }
        return result;
    }
}
