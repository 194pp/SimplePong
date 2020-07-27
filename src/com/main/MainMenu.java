package com.main;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainMenu extends MouseAdapter {

    public boolean active;

    //button play
    private Rectangle playButton;
    private String playText = "Play";
    private boolean pHighlight = false;

    //button quit
    private Rectangle quitButton;
    private String quitText = "Quit";
    private boolean qHighlight = false;

    private Font font;

    public MainMenu(Game game) {

        active = true;
        game.start();

        int w, h, x, y;

        w = 300;
        h = 150;

        y = Game.HEIGHT / 2 - h / 2;

        x = Game.WIDTH / 4 - w / 2;
        playButton = new Rectangle(x, y, w, h);

        x = Game.WIDTH * 3 / 4 - w / 2;
        quitButton = new Rectangle(x, y, w, h);

        font = new Font("Roboto", Font.PLAIN, 100);
    }

    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g.setFont(font);

        g.setColor(Color.black);
        if (pHighlight) {
            g.setColor(Color.white);
        }
        g2d.fill(playButton);

        g.setColor(Color.black);
        if (qHighlight) {
            g.setColor(Color.white);
        }
        g2d.fill(quitButton);

        g.setColor(Color.white);
        g2d.draw(playButton);
        g2d.draw(quitButton);

        int strWidth;
        int strHeight;

        strWidth = g.getFontMetrics(font).stringWidth(playText);
        strHeight = g.getFontMetrics(font).getHeight();

        g.setColor(Color.GREEN);
        g.drawString(playText, (int) (playButton.getX() + playButton.getWidth() / 2 - strWidth / 2),
                (int) (playButton.getY() + playButton.getHeight() / 2 + strHeight / 4));

        strWidth = g.getFontMetrics(font).stringWidth(playText);
        strHeight = g.getFontMetrics(font).getHeight();

        g.setColor(Color.RED);
        g.drawString(quitText, (int) (quitButton.getX() + quitButton.getWidth() / 2 - strWidth / 2),
                (int) (quitButton.getY() + quitButton.getHeight() / 2 + strHeight / 4));
    }

    public void mouseClicked(MouseEvent e) {
        Point p = e.getPoint();

        if (playButton.contains(p)) {
            active = false;
        }
        else if (quitButton.contains(p)) {
            System.exit(0);
        }


    }

    public void mouseMoved(MouseEvent e) {
        Point p = e.getPoint();

        pHighlight = playButton.contains(p);
        qHighlight = quitButton.contains(p);
    }
}
