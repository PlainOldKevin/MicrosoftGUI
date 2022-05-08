import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import git.tools.client.GitSubprocessClient;
import github.tools.client.GitHubApiClient;
import github.tools.client.RequestParams;
import github.tools.responseObjects.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class InputPanel extends JPanel {
	
	// instance variables
	private JTextField repoPathText;
	private JTextField userText;
	private JTextField tokenText;
	private JButton submit;
	private String repoPath;
	private String user;
	private String token;
	private GitSubprocessClient gitSubprocessClient;
	private GitHubApiClient gitHubApiClient;
	
	public InputPanel() {
		
		// make instances of text fields and buttons 
		repoPathText = new JTextField(12);
		userText = new JTextField(12);
		tokenText = new JTextField(15);
		submit = new JButton("Submit");
		
		// add elements to panel
		this.add(repoPathText);
		this.add(userText);
		this.add(tokenText);
		this.add(submit);
		
		// if token.txt exists
		// read in token from it
		// populate token textbox prefilled
		repoPathText.setText("repo path here");
		userText.setText("user info here");
		tokenText.setText("access token here");
	
	
	
		submit.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			gitSubprocessClient = new GitSubprocessClient(repoPath);
			gitHubApiClient = new GitHubApiClient(user, token);

			// create repo
			RequestParams requestParams = new RequestParams();
			requestParams.addParam("name", "NewRepo"); // name of repo
			requestParams.addParam("description", "this is a new repo"); // repo description
			requestParams.addParam("private", false); // if repo is private or not
			CreateRepoResponse createRepoResponse = gitHubApiClient.createRepo(requestParams);
			
			// create gitignore
			CreateFileResponse createIgnoreFile = gitHubApiClient.createFile(user, "NewRepo", repoPath, "master", ".project\r\n"
					+ ".classpath\r\n"
					+ "*.class\r\n"
					+ "bin/\r\n"
					+ ".settings/\r\n"
					+ ".idea/\r\n"
					+ "*.iml\r\n"
					+ ".DS_Store\r\n"
					+ "out/", "created a gitignore");
			
			// create readme
			CreateFileResponse createReadMeFile = gitHubApiClient.createFile
					(user, "NewRepo", repoPath, "README.md", "NewRepo", "created a readme");
			
			String gitInit = gitSubprocessClient.gitInit();
			String gitRemoteAdd = gitSubprocessClient.gitRemoteAdd("origin", "https://github.com/" + user + "NewRepo.git");
			String commitMessage = "This is a commit message";
			String commit = gitSubprocessClient.gitCommit(commitMessage);
			
		}
		
	});}
	
}
