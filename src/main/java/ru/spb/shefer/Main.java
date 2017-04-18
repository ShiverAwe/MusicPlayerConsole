package ru.spb.shefer;

import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        Player player = new Player();
        //player.playList(100,50,30,100,40,50,40,30,50,40,60,20,40,30,20);

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

        System.out.println("Start playing");
        player.playLine(melody);

        System.out.println("END");
    }


}
