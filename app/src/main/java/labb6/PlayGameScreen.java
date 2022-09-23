package labb6;

import javax.swing.*;
import java.awt.Graphics;

public class PlayGameScreen extends JPanel {

    // GLOBAL VARS
    private int screenWidth, screenHeight;
    private boolean isSplashScreen = true;

    // CONSTRUCTOR
    public PlayGameScreen(int screenWidth, int screenHeight, boolean isSplashScreen) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.isSplashScreen = isSplashScreen;
    }

    // PAINTING METHOD
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
    }
}
