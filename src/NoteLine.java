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



    public static NoteLine getDemoLine(){
        NoteLine melody = new NoteLine();
        int position = 0;

        melody.setSound(position+=0, "G*B*16", "G*C*16");
        melody.setSound(position+=16, "Hb*S*8");
        melody.setSound(position+=8,  "G*S*8");
        melody.setSound(position+=8,  "A*B*16", "A*C*16", "C*I*8");
        melody.setSound(position+=16, "A*S*8");

        melody.setSound(position+=16, "Hb*C*16", "Hb*SC*16");
        melody.setSound(position+=16, "D*I*8");
        melody.setSound(position+=16, "Hb*S*8", "C*B*16", "C*C*16");
        melody.setSound(position+=16, "A*S*8");
        melody.setSound(position+=8,  "C*I*8");

        melody.setSound(position+=8,  "D*C*8", "D*CS*16");
        melody.setSound(position+=16, "Hb*S*8", "D*S*8");
        melody.setSound(position+=8,  "D*I*8", "Hb*C*8");
        melody.setSound(position+=8,  "G*I*12", "G*II*12", "Eb*B*16", "Eb*C*16");
        melody.setSound(position+=24, "G*I*4", "G*II*4");

        melody.setSound(position+=8,  "G*I*12", "G*II*12", "H*C*16", "H*SC*16");
        melody.setSound(position+=16, "F*I*8", "F*II*8");
        melody.setSound(position+=16, "F*I*8", "F*II*8", "C*B*16", "C*C*16");
        melody.setSound(position+=16, "Eb*I*8", "Eb*II*8");
        melody.setSound(position+=16, "D*I*8", "D*II*8", "G*B*16", "G*C*16");

        melody.setSound(position+=16, "Hb*S*8", "Hb*I*8");
        melody.setSound(position+=8,  "G*S*8", "G*I*8");
        melody.setSound(position+=8,  "Hb*S*8", "Hb*I*8", "C*C*16", "C*B*16");
        melody.setSound(position+=16,  "A*S*8", "A*I*8", "D*C*16", "D*B*16" );
        melody.setSound(position+=16,  "G*S*32", "G*I*32", "G*B*32", "G*C*32");

        return melody;
    }
}