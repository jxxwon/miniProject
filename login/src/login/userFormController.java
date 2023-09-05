package login;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class userFormController implements Initializable {
	
	private Opener opener = new Opener();
//	public void setOpener(Opener opener) {//오프너를 받아와서 써야함 어디서?... -> 몰라서 그냥 객체 새로 생성..ㅠ
//		this.opener = opener;
//	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	//마이페이지 버튼 누르면 마이페이지 창 새로 열리게
	public void myPageProc() {
		opener.myPageFormOpen();//오프너 받아서 사용하려고 하자 NullPointerException
	}

	//커뮤니티 버튼 누르면 커뮤니티 창 새로 열리게
	public void communityProc() {
		opener.communityFormOpen();
	}
	
}
