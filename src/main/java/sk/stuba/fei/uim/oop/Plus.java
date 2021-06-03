package sk.stuba.fei.uim.oop;

import java.awt.*;

public class Plus extends Rectangle{

    Color farba;

    public Plus (int x, int y, int width, int height, Color c) {
        super (x, y, width, height);
        farba = c;
    }

    public void kresliPlus (Graphics g) {
        g.setColor(farba);
        g.fillRect(this.x + this.width / 3, this.y, this.width / 3, this.height / 3);
        g.fillRect(this.x, this.y + this.height / 3, this.width, this.height / 3);
        g.fillRect(this.x + this.width / 3, this.y + 2 * (this.height / 3), this.width / 3, this.height / 3);
    }

    public int returnX(){
        return x;
    }

    public int returnY(){
        return y;
    }

    public int returnWidth(){
        return width;
    }

    public int returnHeight(){
        return height;
    }

    public void setFarba(Color c){
        farba = c;
    }
}
