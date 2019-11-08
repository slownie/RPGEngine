package gui;

//Graphics Imports:
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

public class GUIMain 
{
	//Global Variables:
	JFrame window;
	DrawingPanel drPanel;
	
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
		window.add(drPanel);
		
		window.setVisible(true);

		//Main Engine Loop:
	}
	
	
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
		}
	}
}
