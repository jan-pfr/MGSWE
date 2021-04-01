package Aufgabe1;

public class Main {
    private static String a1 = "src/main/resources/A1_a_service_data.txt";



    public static void main (String[] args) throws NoSuchFieldException {
        Main main = new Main();
        Reader reader = new Reader();
        main.configure(reader);
        reader.process(a1);


    }
    private void configure (Reader reader) throws NoSuchFieldException {
        reader.addStrategy(configureStrategyServiceCall());
        reader.addStrategy(configureStrategyUseageCall());
    }
    private ReaderStrategy configureStrategyServiceCall() throws NoSuchFieldException {
        ReaderStrategy readerStrategy = new ReaderStrategy("SVCL", ServiceCall.class);
        readerStrategy.addFieldExtractor(4, 18, "customerName");
        readerStrategy.addFieldExtractor(19, 23, "customerID");
        readerStrategy.addFieldExtractor(24, 27, "serviceCallCode");
        readerStrategy.addFieldExtractor(28, 35, "dateOfCall");
        return readerStrategy;


    }
    private ReaderStrategy configureStrategyUseageCall() throws NoSuchFieldException {
        ReaderStrategy readerStrategy = new ReaderStrategy("USGE", Usage.class);
        readerStrategy.addFieldExtractor(4, 8, "customerID");
        readerStrategy.addFieldExtractor(9, 22, "customerName");
        readerStrategy.addFieldExtractor(23, 30, "dateOfCall");
        return readerStrategy;
    }
}
