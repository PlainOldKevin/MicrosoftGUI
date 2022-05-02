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
		timer = new Timer(1, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		
		
		this.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {

			}

			public static void main(String[] args) {
				// TODO Auto-generated method stub

			}

		});

	}
}