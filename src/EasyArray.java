import java.util.ArrayList;

/**
 * Created by Владимир on 17.04.2017.
 */
public class EasyArray<E> extends ArrayList<E> {

    public void safeSet(int index, E element) {
        int capacity = index;
        ensureCapacity(capacity);
        while (capacity >= size()){
            add(null);
        }
        set(index, element);
    }

    public E safeGet(int index){
        if (index >= size()){
            return null;
        }
        else {
            return get(index);
        }
    }
}
