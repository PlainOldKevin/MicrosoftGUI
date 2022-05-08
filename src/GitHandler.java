import git.tools.client.GitSubprocessClient;
import github.tools.client.GitHubApiClient;
import github.tools.client.RequestParams;
import github.tools.responseObjects.*;

public class GitHandler {

	private String repoPath = "C:/Users/kevin/eclipse-workspace/MicrosoftGUI";
	private GitSubprocessClient gitSubprocessClient;
	private GitHubApiClient gitHubApiClient;

	public void handleGit(String repoPath /* etc... */) {

		gitSubprocessClient = new GitSubprocessClient(repoPath);
		//gitHubApiClient = new GitHubApiClient(user, token);

		RequestParams requestParams = new RequestParams();
		requestParams.addParam("name", "NewRepo"); // name of repo
		requestParams.addParam("description", "this is a new repo"); // repo description
		requestParams.addParam("private", false); // if repo is private or not

		CreateRepoResponse createRepoResponse = gitHubApiClient.createRepo(requestParams);

	}

}
