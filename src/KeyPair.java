import org.jetbrains.annotations.NotNull;

public class KeyPair<K extends Comparable<K>, V> implements Comparable<K> {

  private K key;
  private V value;

  public KeyPair(K key, V value) {
    this.key = key;
    this.value = value;
  }

  public K getKey() {
    return key;
  }

  public void setKey(K k) {
    this.key = k;
  }

  public V getValue() {
    return value;
  }

  public void setValue(V v) {
    this.value = v;
  }

  public String toString() {
    return "< " + key + " , " + value + " >";
  }

  @Override
  public int compareTo(@NotNull K o) {
    return key.compareTo(o);
  }
}
