package sk.stuba.fei.uim.oop;

import java.awt.*;

public class Usecka{
    int x, y, endx, endy;
    Color farba;

    public Usecka (int x, int y, int endx, int endy, Color c) {
        this.x = x;
        this.y = y;
        this.endx = endx;
        this.endy = endy;
        farba = c;
    }

    public void kresliUsecku(Graphics g){
        g.setColor(farba);
        g.drawLine(x, y, endx, endy);
    }
}
