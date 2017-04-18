package ru.spb.shefer;

import java.util.*;

/**
 * Created by Владимир on 16.04.2017.
 */
public class NoteLine {
    int key;
    int tone;
    private int unitLength = 60;
    public int getUnitLength() {
        return unitLength;
    }
    private int count = 100;
    public int getCount() {
        return count;
    }
    boolean sustain = true;

    EasyArray<Sound> melody = new EasyArray<Sound>();
    
    void ensureSize(int size){
        for (int i = 0; i < size - melody.size() + 1; i++) {
            melody.add(null);
        }
    }
        
    void setSound(int position, Sound sound){
        if (count<position) count = position+32;
        melody.safeSet(position, sound);
    }

    void setSound(int position, String ... values){
        setSound(position, new Sound(values));
    }

    public OnOffTable toOnOffTable(){
        OnOffTable result = new OnOffTable();
        for (int i = 0; i < count; i++) {
            Sound sound = melody.safeGet(i);
            if (sound != null)
            for(SingleNote note : sound.notes){
                if (result.ons.safeGet(i) == null)
                    result.ons.safeSet(i, new ArrayDeque<Integer>());
                result.ons.safeGet(i).push(note.value);
                if (result.offs.safeGet(i + (int) (note.length*(sustain?1.5:1))) == null)
                    result.offs.safeSet(i + (int) (note.length*(sustain?1.5:1)), new ArrayDeque<Integer>());
                result.offs.safeGet(i + (int) (note.length*(sustain?1.5:1))).push(note.value);

            }
            else {

            }
        }
        return result;
    }

}