package ru.gb.jcore.snakegame;

import javax.swing.*;
import java.awt.*;

public class MessageWindow {
    JFrame window;

    public MessageWindow(JFrame window, String title) {
        this.window = window;
        window.setTitle(title);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setSize(500, 100);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setVisible(false);
    }

    public void showMessageWindow(String message) {
        Label text = new Label(message, Label.CENTER);
        window.add(text);
        window.show();
    }

}
