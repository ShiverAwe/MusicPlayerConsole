package ru.spb.shefer;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;

public class Player {

    private MidiChannel[] channels = null;
    private Synthesizer synth = null;
    private int unitLength = 100;

    public Player() {
        try {
            synth = MidiSystem.getSynthesizer();
            synth.open();
            channels = synth.getChannels();
            channels[0].programChange(41);
        } catch (MidiUnavailableException ex) {
            //Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void close() {
        synth.close();
    }

    public void playSound(int channel, int duration, int volume, int... notes) {
        for (int note : notes) {
            channels[channel].noteOn(note, volume);
        }
        try {
            Thread.sleep(duration);
        } catch (InterruptedException ex) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int note : notes) {
            channels[channel].noteOff(note);
        }
    }

    public void playList(int ... values){
        boolean [] used = new boolean [200];
        for (int i = 0; i < 200; i++) {
            used[i] = false;
        }
        for (int value : values){
            if (!used[value]) {
                channels[1].noteOn(value, 100);try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else {
                channels[1].noteOff(value);  try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void playLine(NoteLine melody){
        int count = melody.getCount();
        unitLength = melody.getUnitLength();
        OnOffTable onOffTable = melody.toOnOffTable();
        for (int i = 0; i < count; i++) {
           // channels[1].noteOn( i ,100);
            if (onOffTable.ons.get(i) != null)
            while (!onOffTable.ons.get(i).isEmpty()){
                System.out.println(i + " : on : " + onOffTable.ons.get(i).peek());
                channels[1].noteOn( onOffTable.ons.get(i).pop() ,100);
            } else System.out.println(i + " : on : null ");
            if (onOffTable.offs.get(i) != null)
            while (!onOffTable.offs.get(i).isEmpty()){
                System.out.println(i + " : off : " + onOffTable.offs.get(i).peek());
                channels[1].noteOff(onOffTable.offs.get(i).pop());
            } else System.out.println(i + " : off : null ");
            try {
                Thread.sleep(unitLength);
            } catch (InterruptedException ex) {
                Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
