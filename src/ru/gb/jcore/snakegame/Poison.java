package ru.gb.jcore.snakegame;

import java.util.Random;

public class Poison extends Cell {
    private Random random;
    private Snake snake;

    public Poison(Snake snake) {
        super(-1, -1, Constants.CELL_SIZE, Constants.POISON_COLOR);
        random = new Random();
        this.snake = snake;
    }

    public void appear(){
        int x, y;
        do{
            x = random.nextInt(Constants.CANVAS_WIDTH);
            y = random.nextInt(Constants.CANVAS_HEIGHT);
        } while(snake.isInSnake(x, y));
        set(x, y);
    }

    public boolean isPoison(int x, int y) {
        return (getX() == x && getY() == y);
    }
}
