package ru.spb.shefer;

import java.util.ArrayList;

public class SafeArrayList<E> extends ArrayList<E> {

    @Override
    public E set(int index, E element) {
        ensureCapacity(index);
        for (int i = size(); i <= index; ++i) {
            add(null);
        }
        return super.set(index, element);
    }

    @Override
    public E get(int index){
        return index < size() ? super.get(index) : null;
    }
}
