package login;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;

public class boardManageFormController implements Initializable {

	private Opener opener = new Opener();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}
	
	public void anounceManageProc() {
		opener.anounceManageFormOpen();
	}
	
	public void secretManageProc() {
		opener.secretManageFormOpen();
	}
	
	public void freeManageProc() {
		opener.freeManageFormOpen();
	}
	
	public void carrotManageProc() {
		opener.carrotManageFormOpen();
	}
}
