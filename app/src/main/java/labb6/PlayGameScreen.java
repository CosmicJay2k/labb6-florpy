package labb6;

import javax.swing.*;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Color;

public class PlayGameScreen extends JPanel {

    // REFERENCE ID
    private static final long serialVersionUID = 1L;

    // GLOBAL VARS
    private int screenWidth, screenHeight;
    private boolean isSplashScreen = true;
    private String message = "Florpy Dog";
    private Font primaryFont = new Font("Goudy Stout", Font.BOLD, 56),
            failFont = new Font("Calibiri", Font.BOLD, 56);
    private int messageWidth = 0;
    private BottomPipe bottomPipe1, bottomPipe2;
    private TopPipe topPipe1, topPipe2;

    // CONSTRUCTOR
    public PlayGameScreen(int screenWidth, int screenHeight, boolean isSplashScreen) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.isSplashScreen = isSplashScreen;
    }

    // PAINTING METHOD
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        graphics.setColor(new Color(90, 80, 250));
        graphics.fillRect(0, 0, screenWidth, screenHeight * 7 / 8);
        graphics.setColor(new Color(150, 140, 10));
        graphics.fillRect(0, screenHeight * 7 / 8, screenWidth, screenHeight / 8);
        graphics.setColor(Color.BLACK);
        graphics.drawLine(0, screenHeight * 7 / 8, screenWidth, screenHeight * 7 / 8);

        if (bottomPipe1 != null && bottomPipe2 != null && topPipe1 != null && topPipe2 != null) {
            graphics.drawImage(bottomPipe1.getPipe(), bottomPipe1.getX(), bottomPipe1.getY(), null);
            graphics.drawImage(bottomPipe2.getPipe(), bottomPipe2.getX(), bottomPipe2.getY(), null);
            graphics.drawImage(topPipe1.getPipe(), topPipe1.getX(), topPipe1.getY(), null);
            graphics.drawImage(topPipe2.getPipe(), topPipe2.getX(), topPipe2.getY(), null);
        }

        // IF PRIMARY FONT FAILS
        try {
            graphics.setFont(primaryFont);
            FontMetrics metric = graphics.getFontMetrics(primaryFont);
            messageWidth = metric.stringWidth(message);
        } catch (Exception fe) {
            graphics.setFont(failFont);
            FontMetrics metric = graphics.getFontMetrics(failFont);
            messageWidth = metric.stringWidth(message);
        }
        graphics.drawString(message, screenWidth / 2 - messageWidth / 2, screenHeight / 4);
    }

    // PARSE BOTTOM PIPE
    public void setBottomPipe(BottomPipe bottomPipe1, BottomPipe bottomPipe2) {
        this.bottomPipe1 = bottomPipe1;
        this.bottomPipe2 = bottomPipe2;
    }

    // PARSE TOP PIPE
    public void setTopPipe(TopPipe topPipe1, TopPipe topPipe2) {
        this.topPipe1 = topPipe1;
        this.topPipe2 = topPipe2;
    }

    // PARSE MESSAGE METHOD
    public void sendMessage(String message) {
        this.message = message;
    }
}
