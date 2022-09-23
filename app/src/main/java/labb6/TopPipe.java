package labb6;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class TopPipe {

    // GLOBAL VARS
    private Image topPipe;
    private int xLocation = 0, yLocation = 0;

    // CONSTRUCTOR
    public TopPipe(int initialWidth, int initialHeight) {
        topPipe = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("../resources/tube_top.png"));
        scaleTopPipe(initialWidth, initialHeight);
    }

    // SCALE METHOD
    public void scaleTopPipe(int width, int height) {
        topPipe = topPipe.getScaledInstance(width, height, Image.SCALE_SMOOTH);
    }

    // OBJECT GETTER
    public Image getPipe() {
        return topPipe;
    }

    // WIDTH GETTER
    public int getWidth() {
        try {
            return topPipe.getWidth(null);
        } catch (Exception e) {
            return -1;
        }
    }

    // HEIGHT GETTER
    public int getHeight() {
        try {
            return topPipe.getHeight(null);
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
        return (new Rectangle(xLocation, yLocation, topPipe.getWidth(null), topPipe.getHeight(null)));
    }

    // BUFFERED IMAGE METHOD
    public BufferedImage getBufferedImage() {
        BufferedImage bufferedImage = new BufferedImage(topPipe.getWidth(null), topPipe.getHeight(null),
                BufferedImage.TYPE_INT_ARGB);
        Graphics graphics = bufferedImage.getGraphics();
        graphics.drawImage(topPipe, 0, 0, null);
        graphics.dispose();
        return bufferedImage;
    }
}
