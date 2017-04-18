import java.util.ArrayList;

/**
 * Created by Владимир on 17.04.2017.
 */
public class Sound {
    ArrayList<SingleNote> notes = new ArrayList<>();

    public Sound addNote(SingleNote note) {
        notes.add(note);
        return this;
    }

    public Sound addNote(String value) {
        notes.add(new SingleNote(value));
        return this;
    }

    public Sound(){}

    public Sound(SingleNote ... notes){
        for (SingleNote note : notes) {
            this.notes.add(note);
        }
    }

    public Sound(String ... values){
        for (String value : values){
            addNote(value);
        }
    }
}
