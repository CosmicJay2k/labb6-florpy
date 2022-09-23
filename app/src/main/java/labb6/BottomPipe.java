package labb6;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class BottomPipe {

    // GLOBAL VARS
    private Image bottomPipe;
    private int xLocation = 0, yLocation = 0;

    // CONSTRUCTOR
    public BottomPipe(int initialWidth, int initialHeight) {
        bottomPipe = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("../resources/tube_bottom.png"));
        scaleBottomPipe(initialWidth, initialHeight);
    }

    // SCALE METHOD
    public void scaleBottomPipe(int width, int height) {
        bottomPipe = bottomPipe.getScaledInstance(width, height, Image.SCALE_SMOOTH);
    }

    // OBJECT GETTER
    public Image getPipe() {
        return bottomPipe;
    }

    // WIDTH GETTER
    public int getWidth() {
        try {
            return bottomPipe.getWidth(null);
        } catch (Exception e) {
            return -1;
        }
    }

    // HEIGHT GETTER
    public int getHeight() {
        try {
            return bottomPipe.getHeight(null);
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
        return (new Rectangle(xLocation, yLocation, bottomPipe.getWidth(null), bottomPipe.getHeight(null)));
    }

    // BUFFERED IMAGE METHOD
    public BufferedImage getBufferedImage() {
        BufferedImage bufferedImage = new BufferedImage(bottomPipe.getWidth(null), bottomPipe.getHeight(null),
                BufferedImage.TYPE_INT_ARGB);
        Graphics graphics = bufferedImage.getGraphics();
        graphics.drawImage(bottomPipe, 0, 0, null);
        graphics.dispose();
        return bufferedImage;
    }
}
