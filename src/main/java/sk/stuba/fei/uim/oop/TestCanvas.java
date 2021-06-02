package sk.stuba.fei.uim.oop;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

class TestCanvas extends Canvas implements MouseListener, MouseMotionListener {

    public ArrayList<Plus> our_objects1 = new ArrayList<>();
    public ArrayList<Usecka> our_objects2 = new ArrayList<>();
    Plus aktualny_Plus;
    Usecka aktualna_Usecka;
    int xpos = 0, ypos = 0, button = 1;
    String color = "GREEN";
    Color c;

    public TestCanvas () {
        super();
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    public void setButton(int button) {
        this.button = button;
    }

    public void setColor(String color){
        this.color = color;
    }

    public void mouseClicked(MouseEvent e) {

    }
    public void mousePressed(MouseEvent e) {
        xpos = e.getX();
        ypos = e.getY();
        checkColor(color);
        if(button == 1)
            aktualny_Plus = new Plus(xpos, ypos,1,1, c);
        if(button == 2)
            aktualna_Usecka = new Usecka(xpos, ypos, xpos, ypos, c);
    }
    public void mouseReleased(MouseEvent e) {
        if(button == 1)
            our_objects1.add(aktualny_Plus);
        if(button == 2)
            our_objects2.add(aktualna_Usecka);
        repaint();
        aktualny_Plus = null;

    }
    public void mouseEntered(MouseEvent e) {

    }
    public void mouseExited(MouseEvent e) {

    }
    public void mouseDragged(MouseEvent e) {
        int dx = e.getX();
        int dy = e.getY();
        if (aktualny_Plus != null || aktualna_Usecka != null) {
            if(button == 1)
                mousePlus(dx, dy);
            if(button == 2)
                mouseUsecka(dx, dy);
            repaint();
        }
    }

    public void mousePlus(int x, int y){
        if (x > xpos && y > ypos) {
            aktualny_Plus.width = x - xpos;
            aktualny_Plus.height = y - ypos;
        }
        if (x < xpos && y > ypos) {
            aktualny_Plus.x = x;
            aktualny_Plus.width = xpos - x;
            aktualny_Plus.height = y - ypos;
        }
        if (x > xpos && y < ypos) {
            aktualny_Plus.y = y;
            aktualny_Plus.width = x - xpos;
            aktualny_Plus.height = ypos - y;
        }
        if (x < xpos && y < ypos) {
            aktualny_Plus.x = x;
            aktualny_Plus.y = y;
            aktualny_Plus.width = xpos - x;
            aktualny_Plus.height = ypos - y;
        }
    }

    public void mouseUsecka(int x, int y){
        aktualna_Usecka.x = xpos;
        aktualna_Usecka.y = ypos;
        aktualna_Usecka.endx = x;
        aktualna_Usecka.endy = y;
    }

    public void mouseMoved(MouseEvent e) {

    }
    public void paint (Graphics g) {
        for (Plus a : our_objects1)
            a.kresliPlus(g);
        if (aktualny_Plus != null)
            aktualny_Plus.kresliPlus(g);
        for (Usecka b : our_objects2)
            b.kresliUsecku(g);
        if (aktualna_Usecka != null)
            aktualna_Usecka.kresliUsecku(g);
    }

    public void checkColor(String color){
        switch (color){
            case "GREEN":
                c = Color.GREEN;
                break;
            case "BLUE":
                c = Color.BLUE;
                break;
            case "YELLOW":
                c = Color.YELLOW;
                break;
            case "RED":
                c = Color.RED;
                break;
            case "BLACK":
                c = Color.BLACK;
                break;
            case "GRAY":
                c = Color.GRAY;
                break;
            case "PINK":
                c = Color.PINK;
                break;
            case "ORANGE":
                c = Color.ORANGE;
                break;
            default:
                c = Color.WHITE;
        }
    }

}
