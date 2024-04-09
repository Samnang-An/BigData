import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

class Reducer<K extends Comparable<K>> {

  private final List<KeyPair<K, List<Integer>>> inputKeyPairList = new ArrayList<>();
  private final List<KeyPair<K, Integer>> reduceList = new ArrayList<>();
  private List<KeyPair> originalList = new ArrayList<>();

  public Reducer() {

  }

  public Reducer(List<KeyPair> lst) {
    this.originalList = lst;
    map();
  }

  public void proceed() {
    map();
    reduce();
  }

  public void map() {
    originalList.stream().forEach(this::addInputKeyPair);

  }

  public void reduce() {
    inputKeyPairList.stream().forEach(this::sum);
  }

  private void sum(KeyPair<K, List<Integer>> keyPair) {
    int sum = keyPair.getValue().stream().mapToInt(i -> i).sum();
    reduceList.add(new KeyPair<>(keyPair.getKey(), sum));
  }

  public void addInputKeyPair(KeyPair<K, Integer> keyPair) {

    getInputKeyPair(keyPair.getKey()).ifPresentOrElse(kp -> kp.getValue().add(1),
        () -> {
          List<Integer> value = new ArrayList<>();
          value.add(keyPair.getValue());
          addNewInputKeyPair(keyPair.getKey(), value);
        });
  }

  private void addNewInputKeyPair(K key, List<Integer> value) {
    inputKeyPairList.add(new KeyPair(key, value));
  }

  public Optional<KeyPair<K, List<Integer>>> getInputKeyPair(K key) {
    return inputKeyPairList.stream()
        .filter(kp -> (kp.getKey()).equals((key)))
        .findFirst();
  }

  public List<KeyPair> getOriginalList() {
    return originalList;
  }

  public void addAllToOriginalList(List<KeyPair> transfer) {
    this.originalList.addAll(transfer);
  }

  public List<KeyPair<K, List<Integer>>> getAllInputKeyPair() {
    Collections.sort(inputKeyPairList, Comparator.comparing(KeyPair::getKey));
    return inputKeyPairList;
  }

  public List<KeyPair<K, Integer>> getAllReduceKeyPair() {
    Collections.sort(reduceList, Comparator.comparing(KeyPair::getKey));
    return reduceList;
  }
}
