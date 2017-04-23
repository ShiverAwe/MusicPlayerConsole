package ru.spb.shefer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Владимир on 16.04.2017.
 */
public class SingleNote extends Sound{
    int value;
    int length;
    int volume = 100;
    int instrument = 0;

    public SingleNote(int value, int length, int volume, int instrument) {
        this.value = value;
        this.length = length;
        this.volume = volume;
        this.instrument = instrument;
    }

    public SingleNote(int value, int length) {
        this.value = value;
        this.length = length;
    }

    public SingleNote(String note){
        Pattern p = Pattern.compile("^([cdefgah])([#b]?)\\*(sc|c|b|s|i|ii|iii|iiii)?\\*([0-9]+)$");
        Matcher m = p.matcher(note.toLowerCase());
        if (!m.matches()) return;
        int value = 0;
        switch (m.group(1)) {
            case "c" : value = 0;  break;
            case "d" : value = 2;  break;
            case "e" : value = 4;  break;
            case "f" : value = 5;  break;
            case "g" : value = 7;  break;
            case "a" : value = 9;  break;
            case "h" : value = 11; break;
        }
        switch (m.group(2)) {
            case "#" : value++; break;
            case "b" : value--; break;
        }
        switch (m.group(3)) {
            case "iiii" : value+=12;
            case "iii"  : value+=12;
            case "ii"   : value+=12;
            case "i"    : value+=12;
            case "s"    : value+=12;
            case "b"    : value+=12;
            case "c"    : value+=12;
            case "sc"   : value+=12;
            default:
            System.out.println("sdfdf " + m.group(3));
            value+=12; break;
        }
        this.value = value;
        this.length = Integer.parseInt(m.group(4));
    }
}