package ru.gb.jcore.snakegame;

import java.awt.*;

public class Constants {
    static final String TITLE_OF_PROGRAM = "Classic Game Snake";
    static String GAME_OVER_MSG = "GAME OVER";
    static String WIN_MSG = "YOU ARE WIN!!!";
    final static int CELL_SIZE = 20;           // size of cell in pix
    final static int CANVAS_WIDTH = 30;        // width in cells
    final static int CANVAS_HEIGHT = 25;       // height in cells
    final static Color SNAKE_COLOR = Color.darkGray;
    final static Color FOOD_COLOR = Color.green;
    final static Color POISON_COLOR = Color.red;
    final static int KEY_LEFT = 37;            // codes
    final static int KEY_UP = 38;              //   of
    final static int KEY_RIGHT = 39;           //   cursor
    final static int KEY_DOWN = 40;            //   keys
    static final int START_SNAKE_SIZE = 5;            // initialization data
    static final int MAX_SNAKE_SIZE = 50;             // max size of a snake
    static final int START_SNAKE_X = CANVAS_WIDTH/2;  //   for
    static final int START_SNAKE_Y = CANVAS_HEIGHT/2; //   snake
    static final int SNAKE_DELAY = 150;               // snake delay in milliseconds
}
