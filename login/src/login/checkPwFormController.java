package login;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

public class checkPwFormController implements Initializable {
	
	@FXML PasswordField pwFld;
	private checkPwFormService service;
	private Stage checkPwStage;
	private Opener opener = new Opener();
	
	public void setcheckPwStage(Stage checkPwStage) {
		this.checkPwStage = checkPwStage;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		service = new checkPwFormService();
	}
	
	public void checkPwProc() {//확인버튼 누르면 실행
		int result = service.checkPw(Login.getId(), pwFld.getText()); 
		if(result == 1) {//비밀번호 확인 - > 회원정보 수정 창 열기
			opener.changeInfoFormOpen();
			checkPwStage.close();
		}else{
			//비밀번호 확인 창 닫기
			checkPwStage.close();
		}
	}
	
	public void cancleProc() {
		//비밀번호 입력창 닫히게 
		checkPwStage.close();
	}
}
