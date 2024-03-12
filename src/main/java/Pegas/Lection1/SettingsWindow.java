package Pegas.Lection1;

import javax.swing.*;
import java.awt.*;

public class SettingsWindow extends JFrame {
    private static final int WINDOW_HEIGHT = 230;
    private static final int WINDOW_WIDTH = 350;
    private int mode;
    private int zX;
    private int wLen;

    JButton btnStart = new JButton("Start new game");
    public SettingsWindow(GameWindow gameWindow){
        setLocationRelativeTo(gameWindow);
        setLocation(getX()-WINDOW_WIDTH/2, getY()-WINDOW_HEIGHT/2);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        btnStart.addActionListener(e -> {
            System.out.println("Mode"+mode);
            gameWindow.startNewGame(mode,zX,zX, wLen);
            setVisible(false);
        });
        JPanel panel1 = createModeComponent();
        JPanel panel2 = createSizeComponent();
        JPanel panel3 = createWinnerComponent();
        JPanel menu = new JPanel(new GridLayout(3,1));
        menu.add(panel1);
        menu.add(panel2);
        menu.add(panel3);
        add(menu);
        add(btnStart, BorderLayout.SOUTH);
    }
    private JPanel createModeComponent(){
        JPanel modePanel = new JPanel(new GridLayout(3, 1));
        JLabel message = new JLabel("Выберите режим игры: ");
        JRadioButton button1 = new JRadioButton("Человек против человека");
        button1.setSelected(true);
        JRadioButton button2 = new JRadioButton("Человек против компьютера");
        button1.addActionListener(e-> mode = 0);
        button2.addActionListener(e-> mode = 1);
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(button1);
        buttonGroup.add(button2);

        modePanel.add(message);
        modePanel.add(button1);
        modePanel.add(button2);

        return modePanel;
    }
    private JPanel createSizeComponent(){
        JPanel modePanel = new JPanel(new GridLayout(3, 1));
        JLabel message1 = new JLabel("Выберите размеры поля: ");
        JLabel message2 = new JLabel("Установленный размер поля: 3");

        JSlider slider = new JSlider(3,10, 3);
        slider.addChangeListener(e -> {
            zX = slider.getValue();
            message2.setText("Установленный размер поля: "+zX);
        });

        modePanel.add(message1);
        modePanel.add(message2);
        modePanel.add(slider);

        return modePanel;
    }
    private JPanel createWinnerComponent(){
        JPanel modePanel = new JPanel(new GridLayout(3, 1));
        JLabel message1 = new JLabel("Выберите длину для победы: ");
        JLabel message2 = new JLabel("Установите длину победы: 3");

        JSlider slider = new JSlider(3,10, 3);
        slider.addChangeListener(e -> {
            wLen = slider.getValue();
            message2.setText("Установленный размер поля: "+ wLen);
        });

        modePanel.add(message1);
        modePanel.add(message2);
        modePanel.add(slider);

        return modePanel;
    }
}
