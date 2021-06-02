package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Window extends JFrame implements ItemListener, ActionListener{

    Panel first;
    Choice color;
    private TestCanvas can;
    private final JButton button1 = new JButton("Plus");
    private final JButton button2 = new JButton("Usecka");
    String[] types = {"GREEN", "BLUE", "YELLOW", "RED", "BLACK", "GRAY", "PINK",  "ORANGE"};
    String colorSelected;

    public Window(String title){
        super(title);
        this.setVisible(true);
        this.setSize(600, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        can = new TestCanvas();
        add(BorderLayout.CENTER, can);

        color = new Choice();
        color.addItemListener(this);

        for (String type : types)
            color.add(type);

        color.select(0);
        colorSelected = color.getSelectedItem();

        first = new Panel();
        first.add(button1);
        first.add(button2);
        first.add(color);

        button1.addActionListener(this);
        button1.setFocusable(false);
        button2.addActionListener(this);
        button2.setFocusable(false);

        this.add("North", first);
        var panelLayout = new GridLayout(1, 3);
        first.setLayout(panelLayout);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        can.setColor(color.getSelectedItem());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1)
            can.setButton(1);
        else if (e.getSource() == button2)
            can.setButton(2);
    }
}
