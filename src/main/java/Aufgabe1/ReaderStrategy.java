package Aufgabe1;

import java.util.ArrayList;
import java.util.List;

public class ReaderStrategy {
    public String code;
    private Class target;
    private List fieldExtractor = new ArrayList<FieldExtractor>();

    public ReaderStrategy (String _code, Class _target){
        this.code = _code;
        this.target = _target;
    }
    public void addFieldExtractor(Integer begin, Integer end, String target) throws NoSuchFieldException {
        if(fieldExtractor.contains(target)){
            throw new NoSuchFieldException(target);
        }
        fieldExtractor.add(new FieldExtractor(begin, end, target));
    }
    public Object process(String line){
        return null;
    }

}
