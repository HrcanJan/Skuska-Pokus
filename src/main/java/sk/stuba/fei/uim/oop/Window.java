package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Window extends JFrame implements ItemListener, ActionListener{

    Panel first, second;
    Choice color;
    Label label;
    private final TestCanvas can;
    private final JButton button1 = new JButton("Plus");
    private final JButton button2 = new JButton("Usecka");
    private final JButton button4 = new JButton("Draw");
    private final JButton button5 = new JButton("Select");
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

        label = new Label();
        label.setBackground(Color.GREEN);

        for (String type : types)
            color.add(type);

        color.select(0);
        colorSelected = color.getSelectedItem();

        first = new Panel();
        first.add(button1);
        first.add(button2);
        first.add(color);
        first.add(label);

        second = new Panel();
        second.add(button4);
        second.add(button5);

        button1.addActionListener(this);
        button1.setFocusable(false);
        button2.addActionListener(this);
        button2.setFocusable(false);
        button4.addActionListener(this);
        button4.setFocusable(false);
        button5.addActionListener(this);
        button5.setFocusable(false);

        this.add("North", first);
        var panelLayout = new GridLayout(1, 4);
        first.setLayout(panelLayout);
        this.add("South", second);
        panelLayout = new GridLayout(1, 2);
        second.setLayout(panelLayout);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        can.setColor(color.getSelectedItem());
        label.setBackground(can.getColor());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1)
            can.setButton(1);
        else if (e.getSource() == button2)
            can.setButton(2);
        else if (e.getSource() == button4)
            can.setMode(4);
        else if (e.getSource() == button5)
            can.setMode(5);
    }
}
