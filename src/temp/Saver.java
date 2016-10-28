package temp;

/**
 * Created by andre on 10/28/2016.
 */
public interface Saver {
    public void save(Object object, String source);
    public Object load(String source);
}
