public class Main {

  public static void main(String[] args) {
//    mainProcess();
    WordCount<Document> wordCount = new WordCount();
    wordCount.getMappers().add(new Mapper<>("/file1.txt"));
    wordCount.getMappers().add(new Mapper<>("/file2.txt"));
    wordCount.getMappers().add(new Mapper<>("/file3.txt"));
    wordCount.getReducers().add(new Reducer<>());
    wordCount.getReducers().add(new Reducer<>());
    wordCount.getReducers().add(new Reducer<>());
    wordCount.getReducers().add(new Reducer<>());
    System.out.println("Number of Input-Splits: " + wordCount.getMappers().size());
    System.out.println("Number of Reducers: " + wordCount.getReducers().size());
    System.out.println("Mapper 0 Input");
    System.out.println(wordCount.getMappers().get(0).getTxtFile());
    System.out.println("Mapper 1 Input");
    System.out.println(wordCount.getMappers().get(1).getTxtFile());
    System.out.println("Mapper 2 Input");
    System.out.println(wordCount.getMappers().get(2).getTxtFile());
    System.out.println("Pairs send from Mapper 0 Reducer 0");
    wordCount.prepareDataTransfer(0,0).stream().forEach(System.out::println);
    System.out.println("Pairs send from Mapper 0 Reducer 1");
    wordCount.prepareDataTransfer(0,1).stream().forEach(System.out::println);
    System.out.println("Pairs send from Mapper 0 Reducer 2");
    wordCount.prepareDataTransfer(0,2).stream().forEach(System.out::println);
    System.out.println("Pairs send from Mapper 0 Reducer 3");
    wordCount.prepareDataTransfer(0,3).stream().forEach(System.out::println);
    System.out.println("Pairs send from Mapper 1 Reducer 0");
    wordCount.prepareDataTransfer(1,0).stream().forEach(System.out::println);
    System.out.println("Pairs send from Mapper 1 Reducer 1");
    wordCount.prepareDataTransfer(1,1).stream().forEach(System.out::println);
    System.out.println("Pairs send from Mapper 1 Reducer 2");
    wordCount.prepareDataTransfer(1,2).stream().forEach(System.out::println);
    System.out.println("Pairs send from Mapper 1 Reducer 3");
    wordCount.prepareDataTransfer(1,3).stream().forEach(System.out::println);
    System.out.println("Pairs send from Mapper 2 Reducer 0");
    wordCount.prepareDataTransfer(2,0).stream().forEach(System.out::println);
    System.out.println("Pairs send from Mapper 2 Reducer 1");
    wordCount.prepareDataTransfer(2,1).stream().forEach(System.out::println);
    System.out.println("Pairs send from Mapper 2 Reducer 2");
    wordCount.prepareDataTransfer(2,2).stream().forEach(System.out::println);
    System.out.println("Pairs send from Mapper 2 Reducer 3");
    wordCount.prepareDataTransfer(2,3).stream().forEach(System.out::println);
    wordCount.proceed();
    System.out.println("Reducer 0 input");
    wordCount.getReducers().get(0).getAllInputKeyPair().stream().forEach(System.out::println);
    System.out.println("Reducer 1 input");
    wordCount.getReducers().get(1).getAllInputKeyPair().stream().forEach(System.out::println);
    System.out.println("Reducer 2 input");
    wordCount.getReducers().get(2).getAllInputKeyPair().stream().forEach(System.out::println);
    System.out.println("Reducer 3 input");
    wordCount.getReducers().get(3).getAllInputKeyPair().stream().forEach(System.out::println);

    System.out.println("Reducer 0 output");
    wordCount.getReducers().get(0).getAllReduceKeyPair().stream().forEach(System.out::println);
    System.out.println("Reducer 1 output");
    wordCount.getReducers().get(1).getAllReduceKeyPair().stream().forEach(System.out::println);
    System.out.println("Reducer 2 output");
    wordCount.getReducers().get(2).getAllReduceKeyPair().stream().forEach(System.out::println);
    System.out.println("Reducer 3 output");
    wordCount.getReducers().get(3).getAllReduceKeyPair().stream().forEach(System.out::println);

  }

  private static void mainProcess() {
    Mapper<Document> instance = new Mapper<>("/testDataForW1D1.txt");
    System.out.println("Mapper Input");
    System.out.println("----------------------");
    System.out.println(instance.getTxtFile());
    System.out.println("----------------------");
    System.out.println("Mapper Output");
    System.out.println("----------------------");
    instance.getAll().forEach(System.out::println);
    Reducer<Document> reducer = new Reducer<>(instance.getAll());
    System.out.println("----------------------");
    System.out.println("Reducer Input");
    System.out.println("----------------------");
    reducer.getOriginalList().forEach(System.out::println);
    System.out.println("----------------------");
    System.out.println("Reducer Output");
    System.out.println("----------------------");
    reducer.getAllInputKeyPair().stream().forEach(System.out::println);
  }
}