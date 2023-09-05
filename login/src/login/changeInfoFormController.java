package login;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class changeInfoFormController implements Initializable {
	
	@FXML TextField nameFld;
	@FXML TextField phoneFld;
	@FXML PasswordField pwFld;
	@FXML PasswordField confirmFld;
	
	private Parent changeInfoForm;
	private Stage changeInfoStage;
	private changeInfoFormService service;
	
	public void setChangeInfoForm(Parent changeInfoForm) {
		this.changeInfoForm = changeInfoForm;
	}
	//창 받기
	public void setChangeInfoStage(Stage changeInfoStage) {
		this.changeInfoStage = changeInfoStage;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		service = new changeInfoFormService();
	}
	
	//수정버튼 눌렀을 때 실행
	public void changeProc() {
		int result = service.change(changeInfoForm);
		if(result == 1) {
			CommonService.msg("회원정보가 수정되었습니다.");
			//창닫기
			changeInfoStage.close();
		}
		
	}
	//취소버튼 눌렀을 때 실행
	public void cancleProc() {
		nameFld.clear();
		phoneFld.clear();
		pwFld.clear();
		confirmFld.clear();
		nameFld.requestFocus();
	}

}
