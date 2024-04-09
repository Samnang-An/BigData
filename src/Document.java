import org.jetbrains.annotations.NotNull;

public class Document implements Comparable<Document> {

  private String data;

  public Document(String word) {
    this.data = word;
  }

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

  @Override
  public boolean equals(Object obj) {
    return data.equalsIgnoreCase(((Document) obj).getData());
  }

  @Override
  public int hashCode() {
    return data.hashCode();
  }

  @Override
  public String toString() {
    return data;
  }

  @Override
  public int compareTo(@NotNull Document o) {
    return data.toLowerCase().compareTo(o.getData().toLowerCase());
  }
}
