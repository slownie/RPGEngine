package gui;

import java.awt.*;

public class GUIEnemy
{
    String name;
    int stats [];
    int x, y, sizeX, sizeY;

    GUIEnemy(String name, int stats [], int x, int y, int sizeX, int sizeY)
    {
        this.name = name;
        this.stats = stats;
        this.x = x;
        this.y = y;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }

    public void drawEnemy(Graphics g, int x, int y, int sizeX, int sizeY)
    {
        g.setColor(Color.WHITE);
        g.drawRect(x, y, sizeX, sizeY);
    }
}
