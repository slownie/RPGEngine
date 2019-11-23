package gui;

import java.awt.*;

public class GUIPlayer
{
    String name;
    int stats [];
    int x, y, sizeX, sizeY;

    GUIPlayer(String name, int stats [], int x, int y)
    {
        this.name = name;
        this.stats = stats;
        this.x = x;
        this.y = y;
    }

    public void drawPlayer(Graphics g, String name, int x, int y)
    {
        g.setColor(Color.WHITE);
        g.drawString(name, x + 5, y + 15);
        g.drawRect(x, y, 50, 50);
    }
}
