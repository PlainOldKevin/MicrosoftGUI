import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Pannel extends JPanel {

	private Sprites QULogo;
	private Sprites MicrosoftLogo;

	public Pannel() {
		Timer timer;

		// this is where the QU logo is implemented
		QULogo = new Sprites("./images/QULogo.png");
		QULogo.getX();
		QULogo.getY();

		MicrosoftLogo = new Sprites("./images/MicrosoftLogo.png");
		MicrosoftLogo.getX();
		MicrosoftLogo.getY();

		// this sets the background
		this.setBackground(Color.green);
		// TODO Auto-generated method stub
		MicrosoftLogo.setHeight(50);
		MicrosoftLogo.setWidth(50);
	
		MicrosoftLogo.setLocation(100, 100);
		//QULogo.setLocation(200,200);
		repaint();
	}
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D brush = (Graphics2D) g;
		//	QULogo.paint(brush);
			
			MicrosoftLogo.paint(brush);
		
		
		
		this.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {

			}

			

		});

		
	}
}