package login;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class myPageFormController implements Initializable {
	private Stage myPageStage;
	private Parent myPageForm;
	private myPageFormService myPageService;

	private Opener opener = new Opener();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		myPageService = new myPageFormService();
	}

	public void setMyPageStage(Stage myPageStage) {
		this.myPageStage = myPageStage;
	}

	public void setMyPageForm(Parent myPageForm) {
		this.myPageForm = myPageForm;
	}

	// 마이페이지에서 정보수정 버튼 누르면 현재비밀번호 입력하세요 새창 뜨게
	public void changeInfoProc() {
		opener.checkPwFormOpen();
	}
	
	//마이페이지에서 활동내역 누르면 활동내역 새창 뜨게
	public void activityProc() {
		opener.activityFormOpen();
	}
	
	//마이페이지에서 관리비 조회 누르면 새창 뜨게
	public void costViewProc() {
		opener.costViewFormOpen();
	}
	
	//지갑 버튼 누르면 myMoney 보는
	public void myMoneyProc(MouseEvent event) {
		opener.myMoneyFormOpen();
	}

}
