package gui;

//Graphics Imports:
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GUIMain implements KeyListener
{
    //Global Variables:

    //Graphics Variables:
    JFrame window;
    DrawingPanel drPanel;

    //Timer Variables:
    Timer bTimer;

    //Player Inputs:
    static boolean W, A, S, D, J, K = false;

    //Enemy Variables:
    static int [] eStats = {20, 10, 4, 1, 2, 3, 1};
    GUIEnemy e1 = new GUIEnemy("Enemy", eStats, 100, 100, 50, 50);

    public static void main (String [] args)
    {
        new GUIMain();
    }

    GUIMain()
    {
        //JFrame Setup:
        window = new JFrame("RPG Engine");
        window.setSize(400, 400); //Might change this later
        window.setResizable(false); //TODO: change to any resolution
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);

        //DrawingPanel Setup:
        drPanel = new DrawingPanel();
        drPanel.addKeyListener(this);
        window.add(drPanel);


        //Timer Setup:
        int timerSpeed = 120;
        bTimer = new Timer(timerSpeed, new BattleTimerListener());
        bTimer.setDelay(100);
        bTimer.start();

        window.setVisible(true);

    }

    /** Classes used in this Program **/

    @SuppressWarnings("serial")
    private class DrawingPanel extends JPanel
    {
        DrawingPanel()
        {
            this.setBackground(Color.BLACK);
        }

        @Override
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            this.requestFocus();

            drawHUD(g);
        }
    }

    private class BattleTimerListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            readInputs();
            window.repaint();
        }
    }

    /** Methods used in this program **/
    public void readInputs()
    {

    }

    public void playerPhase()
    {

    }

    //Draws the HUD in the GraphicsPanel:
    public void drawHUD(Graphics g)
    {
        //Top Text Box:
        Color textBoxColour = new Color(36, 255, 248);
        g.setColor(textBoxColour);
        //TODO: Make these work with most screen resolutions
        g.drawRect(20, 20, 355, 60);
        g.setColor(Color.WHITE);
        g.drawString("* This is a test message.", 30, 40);
        g.drawString("*This is a test message too.", 30, 60);

        e1.drawEnemy(g, e1.x, e1.y, e1.sizeX, e1.sizeY);
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        if (e.getKeyCode() == KeyEvent.VK_W) W = true;
        if (e.getKeyCode() == KeyEvent.VK_A) A = true;
        if (e.getKeyCode() == KeyEvent.VK_S) S = true;
        if (e.getKeyCode() == KeyEvent.VK_D) D = true;
        if (e.getKeyCode() == KeyEvent.VK_J) J = true;
        if (e.getKeyCode() == KeyEvent.VK_K) K = true;
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        if (e.getKeyCode() == KeyEvent.VK_W) W = false;
        if (e.getKeyCode() == KeyEvent.VK_A) A = false;
        if (e.getKeyCode() == KeyEvent.VK_S) S = false;
        if (e.getKeyCode() == KeyEvent.VK_D) D = false;
        if (e.getKeyCode() == KeyEvent.VK_J) J = false;
        if (e.getKeyCode() == KeyEvent.VK_K) K = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {}
}
