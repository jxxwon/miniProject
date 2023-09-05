package login;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController implements Initializable{
	@FXML TextField idFld;
	@FXML PasswordField pwFld;
	@FXML Button loginBtn;
	
	private LoginService service;
	
	private Opener opener;
	public void setOpener(Opener opener) {
		this.opener = opener;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		loginBtn.setDisable(true);
		service = new LoginService();
	}
	
	public void idCheck() {//아이디를 입력하지 않으면 로그인 버튼 비활성화
		if(idFld.getText().length() >= 5) {
			loginBtn.setDisable(false);
		}
		
		if(idFld.getText().length() > 7) {
			CommonService.msg("아이디는 동-호수 입니다");
			idFld.setText(idFld.getText().substring(0, 7));
		}
	}
	
	public void pwCheck() {
		if(pwFld.getText().length() > 10) {
			CommonService.msg("비밀번호는 10자리 이하입니다.");
			pwFld.setText(pwFld.getText().substring(0, 10));
		}
	}
	
	// 로그인 버튼을 클릭하면 동작하는 메서드
	public void loginProc() {
		service.login(idFld.getText(), pwFld.getText());
		// 로그인성공이라면 메인화면을 로그인 창이 있는 곳에 userPage or adminPage을 실행
		if(Login.getId()!=null && Login.getId().equals("admin")) {
			opener.adminFormOpen();
		}else{
			opener.userFormOpen();
		}
	}
	
	// 회원가입 버튼을 클릭하면 회원가입창 새로 열리게
	public void regProc() {
		opener.regFormOpen();
	}
	
	// 취소 버튼을 클릭하면 동작하는 메서드
	public void cancelProc() {
		idFld.clear();
		pwFld.clear();
		idFld.requestFocus();
	}
}