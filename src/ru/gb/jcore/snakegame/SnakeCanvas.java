package ru.gb.jcore.snakegame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SnakeCanvas extends JFrame {
    Canvas canvas;                   // canvas object for rendering (drawing)
    Snake snake;                     // declare a snake object
    Food food;                       // declare a food object
    Poison poison;                   // declare a poison object

    public SnakeCanvas(Snake snake, Food food, Poison poison){
        setTitle(Constants.TITLE_OF_PROGRAM);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.snake = snake;
        this.food = food;
        this.poison = poison;
        canvas = new Canvas();
        canvas.setBackground(Color.WHITE);
        canvas.setPreferredSize(new Dimension( Constants.CELL_SIZE * Constants.CANVAS_WIDTH,
                            Constants.CELL_SIZE * Constants.CANVAS_HEIGHT));
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                snake.setDirection(e.getKeyCode());
            }
        });

        add(canvas);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    public void canvasSetTitle(String title, int size, int score) {
        setTitle(title + ":" + size + ",   Score: " + score);
    }

    public void canvasSetTitle(String title, int score) {
        setTitle(title + ",   Score: " + score);
    }

    public void canvasRepaint() {
        canvas.repaint();
        sleep(Constants.SNAKE_DELAY);
    }

    private void sleep(long ms) {    // method for suspending
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    class Canvas extends JPanel {     // class for rendering (drawing)
        @Override
        public void paint(Graphics g) {
            super.paint(g);
            Graphics2D g2D = (Graphics2D) g;
            g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            snake.paint(g2D);
            food.paint(g2D);
            poison.paint(g2D);
        }
    }

}
