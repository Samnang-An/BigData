import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Mapper<K extends Comparable<K>> {

  public static final String DIR = "/home/samnang/Documents/Docs/MIU/BD/lab/lab2/src/storage/";
  private static final String PATTERN_REG_EXP = "\\b(?![a-zA-Z0-9_]*\\d)(?![a-zA-Z0-9_]*\\.[a-zA-Z0-9_]*)(?![a-zA-Z0-9_]*_[a-zA-Z0-9_]*)(?![a-zA-Z0-9_]*_ptr\\b)[a-zA-Z.]+\\b";
  private final List<KeyPair> keyPairList = new ArrayList<>();
  private String txtFile;

  public Mapper(String path) {
    map(path);
  }

  public void add(K key, int value) {
    keyPairList.add(new KeyPair<>(key, value));
  }

  public String getTxtFile() {
    return this.txtFile;
  }

  public List<KeyPair> getAll() {
    Collections.sort(keyPairList,Comparator.comparing(KeyPair::getKey));
    return keyPairList;
  }

  private void map(String path) {
    txtFile = (String) readFromStorage(path);
    Pattern regex = Pattern.compile(PATTERN_REG_EXP);
    Matcher matcher = regex.matcher(txtFile);
    while (matcher.find()) {
      String word = matcher.group();
      keyPairList.add(new KeyPair(new Document(word), 1));
    }
  }

  private Object readFromStorage(String filename) {
    FileReader fileReader;
    try {
      fileReader = new FileReader(DIR + filename);
      BufferedReader bufferedReader = new BufferedReader(fileReader);
      return bufferedReader.lines().collect(Collectors.joining(" "));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
