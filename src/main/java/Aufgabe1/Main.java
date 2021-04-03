package Aufgabe1;

public class Main {
    private static String a1 = "src/main/resources/A1_a_service_data.txt";
    private static String a2 = "src/main/resources/A1_b_chess_1_wm2019_short.txt";



    public static void main (String[] args) throws Exception {
        Main main = new Main();
        Reader reader = new Reader();
        main.configure(reader);
        System.out.println(reader.process(a1).toString());
        System.out.println(reader.process(a2).toString());


    }
    private void configure (Reader reader) throws Exception {
        reader.addStrategy(configureStrategyServiceCall());
        reader.addStrategy(configureStrategyUseageCall());
        reader.addStrategy(configureChessNotation());
    }
    private ReaderStrategy configureStrategyServiceCall() throws Exception {
        ReaderStrategy readerStrategy = new ReaderStrategy("SVCL", ServiceCall.class);
        readerStrategy.addFieldExtractor(4, 18, "customerName");
        readerStrategy.addFieldExtractor(19, 23, "customerID");
        readerStrategy.addFieldExtractor(24, 27, "serviceCallCode");
        readerStrategy.addFieldExtractor(28, 35, "dateOfCall");
        return readerStrategy;


    }
    private ReaderStrategy configureStrategyUseageCall() throws Exception {
        ReaderStrategy readerStrategy = new ReaderStrategy("USGE", Usage.class);
        readerStrategy.addFieldExtractor(4, 8, "customerID");
        readerStrategy.addFieldExtractor(9, 22, "customerName");
        readerStrategy.addFieldExtractor(23, 30, "dateOfCall");
        return readerStrategy;
    }
    private ReaderStrategy configureChessNotation() throws Exception{
        String pattern ="([a-h]|\\s|[KDTLSO])([a-h]|\\d|[KDTLSx-]|\\s)([a-h]|\\s|[+#xO]|\\d)([a-h]|\\s|\\d|[+#-])(\\s|[+#O]|\\d)";
        ReaderStrategy readerStrategy = new ReaderStrategy("MOVE", ChessMove.class, pattern);
        readerStrategy.addFieldExtractor(4,8,"ID");
        readerStrategy.addFieldExtractor(9,13,"WhiteMove");
        readerStrategy.addFieldExtractor(14,18,"BlackMove");
        return readerStrategy;
    }
}

