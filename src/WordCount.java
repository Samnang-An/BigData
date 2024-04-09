import java.util.ArrayList;
import java.util.List;

public class WordCount<K> {

  private final List<Mapper> mappers = new ArrayList<>();

  private final List<Reducer> reducers = new ArrayList<>();

  public List<KeyPair> prepareDataTransfer(int mapperIndex, int reducerIndex) {
    List<KeyPair> transfer = new ArrayList<>();
    List<KeyPair> mapper = mappers.get(mapperIndex).getAll();
    mapper.stream().filter(
        keyPair -> getPartition((K) keyPair.getKey()) == reducerIndex).forEach(transfer::add);
    getReducers().get(reducerIndex).addAllToOriginalList(transfer);
    return transfer;
  }
  
  public void proceed(){
    getReducers().forEach(Reducer::proceed);
  }

  public int getPartition(K key) {
    return key.hashCode() % getReducers().size();
  }

  public List<Mapper> getMappers() {
    return mappers;
  }

  public List<Reducer> getReducers() {
    return reducers;
  }
}
