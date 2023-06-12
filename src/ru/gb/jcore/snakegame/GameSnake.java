package ru.gb.jcore.snakegame;

import javax.swing.*;

public class GameSnake {
    static boolean gameOver = false;           // a sign game is over or not
    static int snakeSize = 0;                         // current snake size
    static int score = 0;                             // number of points scored

    public static void main(String[] args) {
        Snake snake = new Snake(
                Constants.START_SNAKE_X,
                Constants.START_SNAKE_Y,
                Constants.START_SNAKE_SIZE,
                Constants.KEY_RIGHT);
        Food food = new Food(snake);
        Poison poison = new Poison(snake);;

        SnakeCanvas snakeCanvas = new SnakeCanvas(snake, food, poison);
        game(snakeCanvas, snake, food, poison);
    }

    public static void game(SnakeCanvas snakeCanvas, Snake snake, Food food, Poison poison) {
        boolean flag = false;
        snake.setFood(food);
        snake.setPoison(poison);

        while(!gameOver){
            snake.move();
            if(snake.size() > snakeSize){
                snakeSize = snake.size();
                snakeCanvas.canvasSetTitle(Constants.TITLE_OF_PROGRAM, snakeSize, score);
                score += 50;
            }

            if (snakeSize == Constants.MAX_SNAKE_SIZE) {
                snakeCanvas.canvasSetTitle(Constants.WIN_MSG, score);
                MessageWindow msgWin = new MessageWindow(new JFrame(), Constants.WIN_MSG);
                msgWin.showMessageWindow(Constants.WIN_MSG + "     YOUR SCORED: " + score);
                flag = true;
                break;
            }

            if(food.isEaten()){
                food.appear();
                poison.appear();
            }

            snakeCanvas.canvasRepaint();
        }
        if (!flag) {
            score -= 50;
            snakeCanvas.canvasSetTitle(Constants.GAME_OVER_MSG, score);
            MessageWindow msgWin = new MessageWindow(new JFrame(), Constants.GAME_OVER_MSG);
            msgWin.showMessageWindow(Constants.GAME_OVER_MSG + "     YOUR SCORED: " + score);
        }
    }

}
