
import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import git.tools.client.GitSubprocessClient;
import github.tools.client.GitHubApiClient;
import github.tools.responseObjects.*;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class App extends JFrame {

	public App() {
		
		super("Microsoft Demo");
		this.setLayout(new BorderLayout());
		this.setSize(800, 700);
		Pannel drawingPanel = new Pannel();
		this.add(drawingPanel, BorderLayout.CENTER);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    this.add(new Pannel());
	    this.setVisible(true);
	    
	    
	    //GitHandler gitHandler = new GitHandler(); 
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
new App();
	}

}
