package labb6;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class Player {

    // GLOBAL VARS
    private Image florpyDog;
    private int xLocation = 0, yLocation = 0;

    // CONSTRUCTOR
    public Player(int initialWidth, int initialHeight) {
        florpyDog = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("../resources/florpy_dog.png"));
        scaleDog(initialWidth, initialHeight);
    }

    // SCALE METHOD
    public void scaleDog(int width, int height) {
        florpyDog = florpyDog.getScaledInstance(width, height, Image.SCALE_SMOOTH);
    }

    // OBJECT GETTER
    public Image getDog() {
        return florpyDog;
    }

    // WIDTH GETTER
    public int getWidth() {
        try {
            return florpyDog.getWidth(null);
        } catch (Exception e) {
            return -1;
        }
    }

    // HEIGHT GETTER
    public int getHeight() {
        try {
            return florpyDog.getHeight(null);
        } catch (Exception e) {
            return -1;
        }
    }

    // X LOCATION SETTER
    public void setX(int x) {
        xLocation = x;
    }

    // X LOCATION GETTER
    public int getX() {
        return xLocation;
    }

    // Y LOCATION SETTER
    public void setY(int y) {
        yLocation = y;
    }

    // Y LOCATION GETTER
    public int getY() {
        return yLocation;
    }

    // OUTLINE RECTANGLE METHOD
    public Rectangle getRectangle() {
        return (new Rectangle(xLocation, yLocation, florpyDog.getWidth(null), florpyDog.getHeight(null)));
    }

    // BUFFERED IMAGE METHOD
    public BufferedImage getBufferedImage() {
        BufferedImage bufferedImage = new BufferedImage(florpyDog.getWidth(null), florpyDog.getHeight(null),
                BufferedImage.TYPE_INT_ARGB);
        Graphics graphics = bufferedImage.getGraphics();
        graphics.drawImage(florpyDog, 0, 0, null);
        graphics.dispose();
        return bufferedImage;
    }
}
